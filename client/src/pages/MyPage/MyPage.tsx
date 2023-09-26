import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import axiosTemp from '@api/apiControllerTemp';
import Navbar from '@components/common/NavBar';

import {
  MyNftInfo,
  MyPageInfo,
  MySettleFundingInfo,
  MyUnSettleFundingInfo,
  ProfileInfo,
  ProfitInfo,
  SettlementInfo,
} from '@type/MyPage';
import { ACTIVE, ARTIST, CONCERT } from '@components/common/constant';
import Profile from '@components/MyPage/ProfileInfo';

const MyPage = () => {
  const [nowProcessTab, setNowProcessTab] = useState<string>(ACTIVE);
  const [profileInfo, setProfileInfo] = useState<ProfileInfo>();
  const [isArtist, setIsArtist] = useState<boolean>(false);
  const [profitInfo, setProfitInfo] = useState<ProfitInfo>();
  const [settleInfo, setSettleInfo] = useState<SettlementInfo>();
  const [nowNftInfo, setNowNftInfo] = useState<MyNftInfo[]>();
  const [doneNftInfo, setDoneNftInfo] = useState<MyNftInfo[]>();
  const [nowSettleFundingInfo, setNowSettleFundingInfo] =
    useState<MySettleFundingInfo[]>();
  const [nowUnSettleFundingInfo, setNowUnSettleFundingInfo] =
    useState<MyUnSettleFundingInfo[]>();

  useEffect(() => {
    axiosTemp.get('/mypage-general').then((res) => {
      const data: MyPageInfo = res.data;
      setProfileInfo(data.profileInfo);
      setIsArtist(data.profileInfo.isArtist);
      setProfitInfo(data.profitInfo);
      setSettleInfo(data.settlementInfo);
    });
  }, []);

  useEffect(() => {
    switch (nowProcessTab) {
      case ACTIVE:
        axiosTemp.get('/my-nft').then((res) => {
          const data = res.data;
          setNowNftInfo(data.ing);
          setDoneNftInfo(data.done);
        });
        break;
      case CONCERT:
        axiosTemp.get('/my-fund').then((res) => {
          const data = res.data;
          setNowUnSettleFundingInfo(data.ing);
          setNowSettleFundingInfo(data.done);
        });
        break;
      case ARTIST:
        axiosTemp.get('/my-fund').then((res) => {
          const data = res.data;
          setNowUnSettleFundingInfo(data.ing);
          setNowSettleFundingInfo(data.done);
        });
        break;
    }
  }, [nowProcessTab]);

  return (
    <>
      <Navbar />
      <MyPageFrame>
        <LeftSection>
          <Profile isArtist={isArtist} profileInfo={profileInfo} />
        </LeftSection>
        <RightSection></RightSection>
      </MyPageFrame>
    </>
  );
};

const MyPageFrame = styled.div`
  margin: 1px -280px -100px;
  display: flex;
`;

const LeftSection = styled.div`
  width: 20%;
  background-color: #f0f1f3c6;
`;

const RightSection = styled.div`
  height: 100dvh;
  width: 80%;
  background-color: var(--white-color);
  height: 100dvh;
`;

export default MyPage;
