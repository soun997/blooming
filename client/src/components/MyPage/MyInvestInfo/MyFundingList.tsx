import { MySettleFundingInfo, MyUnSettleFundingInfo } from '@type/MyPage';
import React from 'react';
import styled from 'styled-components';
import { ReactComponent as ArrowSvg } from '@assets/icons/arrow-right.svg';

interface Props {
  nowSettleFundingInfo: MySettleFundingInfo[] | undefined;
  nowUnSettleFundingInfo: MyUnSettleFundingInfo[] | undefined;
}
const MyFundingList = ({
  nowSettleFundingInfo,
  nowUnSettleFundingInfo,
}: Props) => {
  if (!nowSettleFundingInfo || !nowUnSettleFundingInfo) {
    return <></>;
  }
  return (
    <>
      <ResultEachFrame>
        <div className="title">
          <div className="text">정산 완료된 활동</div>
          <div className="moreInfo">
            더보기 <ArrowSvg />
          </div>
        </div>
        {nowSettleFundingInfo?.slice(0, 3).map((funding, idx) => (
          <ListElement key={idx}>
            <div className="left">
              <img src={funding.fundingImg} />
              <div className="info">
                <div className="name">{funding.name}</div>
                <div className="artist">{funding.artistName}</div>
              </div>
            </div>

            <div className="rate">{funding.profitRate} %</div>
          </ListElement>
        ))}
      </ResultEachFrame>
      <ResultEachFrame>
        <div className="title">
          <div className="text">진행 중인 활동</div>
          <div className="moreInfo">
            더보기 <ArrowSvg />
          </div>
        </div>
        {nowUnSettleFundingInfo?.slice(0, 3).map((funding, idx) => (
          <ListElement key={idx}>
            <div className="left">
              <img src={funding.fundingImg} />
              <div className="info">
                <div className="name">{funding.name}</div>
                <div className="artist">{funding.artistName}</div>
              </div>
            </div>

            <div className="rate">{funding.achiveRate} %</div>
          </ListElement>
        ))}
      </ResultEachFrame>
    </>
  );
};

const ResultEachFrame = styled.div`
  flex: 1;
  gap: 15px;
  display: flex;
  flex-direction: column;

  .title {
    font-weight: 700;
    font-size: 20px;
    margin-bottom: 10px;
    display: flex;
    justify-content: space-between;

    .moreInfo {
      cursor: pointer;
      display: flex;
      align-items: center;
      gap: 2px;
      color: var(--main1-color);
      font-weight: 600;
      font-size: 14px;
      svg {
        width: 14px;
        height: 14px;
      }
    }
  }
`;

const ListElement = styled.div`
  display: flex;
  gap: 20px;
  justify-content: space-between;

  .rate {
    font-weight: 700;
    color: var(--main1-color);
  }
  .left {
    display: flex;
    gap: 12px;
    .info {
      display: flex;
      flex-direction: column;
      gap: 5px;
      .name {
        font-weight: 600;
        font-size: 16px;
      }
      .artist {
        font-size: 14px;
        color: var(--main2-color);
        font-weight: 600;
      }
    }
  }
  img {
    width: 50px;
    height: 50px;
    object-fit: cover;
    border-radius: 6px;
  }
`;

export default MyFundingList;
