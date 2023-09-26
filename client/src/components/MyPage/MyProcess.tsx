import { ACTIVE, ARTIST, CONCERT } from '@components/common/constant';
import React, { useEffect, useState } from 'react';
import axiosTemp from '@api/apiControllerTemp';
import {
  MyNftInfo,
  MySettleFundingInfo,
  MyUnSettleFundingInfo,
  ProfitInfo,
  SettlementInfo,
} from '@type/MyPage';

const MyProcess = () => {
  const [nowProcessTab, setNowProcessTab] = useState<string>(ACTIVE);
  const [nowNftInfo, setNowNftInfo] = useState<MyNftInfo[]>();
  const [doneNftInfo, setDoneNftInfo] = useState<MyNftInfo[]>();
  const [nowSettleFundingInfo, setNowSettleFundingInfo] =
    useState<MySettleFundingInfo[]>();
  const [nowUnSettleFundingInfo, setNowUnSettleFundingInfo] =
    useState<MyUnSettleFundingInfo[]>();

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

  return <div>MyProcess</div>;
};

export default MyProcess;
