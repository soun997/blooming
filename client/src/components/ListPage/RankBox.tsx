import React from 'react';
import styled from 'styled-components';
import { Bar, Progress, ProgressBar } from '@style/common';
import { ArtistInfo } from '@type/Artist';
import { ReactComponent as RightArrowSvg } from '@assets/icons/angle-right.svg';

interface FirstBoxProps {
  data: ArtistInfo;
}

// 남은 일자 계산
const calculateDateDifference = (
  startDate: string,
  endDate: string,
): number => {
  const start = new Date(startDate);
  const end = new Date(endDate);

  const oneDayInMilliseconds = 24 * 60 * 60 * 1000;

  const differenceInMilliseconds = end.getTime() - start.getTime();

  const differenceInDays = Math.round(
    differenceInMilliseconds / oneDayInMilliseconds,
  );

  return differenceInDays;
};

//남은 상품 % 계산
const calculateCntDifference = (now: number, end: number): string => {
  return ((now / end) * 100).toFixed(1);
};

const FirstBox: React.FC<FirstBoxProps> = ({ data }) => {
  return (
    <CardBox>
      <img src={data.profile_img}></img>
      <InfoBox>
        <div className="artist_name">{data.name}</div>
        <div className="artist_desc">{data.desc}</div>
        <RateBox>
          <ProgressBox>
            <div className="title">
              <div className="subtitle">발행일</div>
              <div className="remainDate">
                {calculateDateDifference(data.startDate, data.endDate)} 일 남음
              </div>
            </div>
            <ProgressBar>
              <Progress
                score={calculateDateDifference(
                  data.startDate,
                  new Date().toString(),
                )}
                total={calculateDateDifference(data.startDate, data.endDate)}
              >
                <Bar></Bar>
              </Progress>
            </ProgressBar>
          </ProgressBox>
          <ProgressBox>
            <div className="title">
              <div className="subtitle">NFT 판매량</div>
              <div className="remainDate">
                {calculateCntDifference(data.nowNft, data.totalNft)} % 달성
              </div>
            </div>
            <ProgressBar>
              <Progress score={data.nowNft} total={data.totalNft}>
                <Bar></Bar>
              </Progress>
            </ProgressBar>
          </ProgressBox>
        </RateBox>
      </InfoBox>
      <ConfirmButton>발행하기</ConfirmButton>
    </CardBox>
  );
};

const SecondBox: React.FC<FirstBoxProps> = ({ data }) => {
  return (
    <CardBoxMedium>
      <img src={data.profile_img}></img>
      <InfoBox>
        <div className="artist_name">{data.name}</div>
        <div className="artist_desc">{data.desc.slice(0, 200) + '...'}</div>
        <RateBox>
          <ProgressBox>
            <div className="title">
              <div className="subtitle">발행일</div>
              <div className="remainDate">
                {calculateDateDifference(data.startDate, data.endDate)} 일 남음
              </div>
            </div>
            <ProgressBar>
              <Progress
                score={calculateDateDifference(
                  data.startDate,
                  new Date().toString(),
                )}
                total={calculateDateDifference(data.startDate, data.endDate)}
              >
                <Bar></Bar>
              </Progress>
            </ProgressBar>
          </ProgressBox>
          <ProgressBox>
            <div className="title">
              <div className="subtitle">NFT 판매량</div>
              <div className="remainDate">
                {calculateCntDifference(data.nowNft, data.totalNft)} % 달성
              </div>
            </div>
            <ProgressBar>
              <Progress score={data.nowNft} total={data.totalNft}>
                <Bar></Bar>
              </Progress>
            </ProgressBar>
          </ProgressBox>
        </RateBox>
        <div className="button">
          <div>발행하기</div>
          <RightArrowSvg />
        </div>
      </InfoBox>
    </CardBoxMedium>
  );
};

const CardBoxMedium = styled.div`
  display: flex;
  box-shadow: 0px 0px 10px 0px rgba(48, 97, 185, 0.1);
  img {
    width: 320px;
    height: 100%;
    flex-shrink: 0;
    border-radius: 6px 0 0 6px;
  }

  .button {
    display: flex;
    align-self: flex-end;
    align-items: center;
    margin-top: 50px;
    margin-bottom: -18px;
    font-size: 16px;
    font-weight: 700;
    line-height: 25px; /* 156.25% */
    color: var(--main1-color);
    cursor: pointer;
  }
`;

const CardBox = styled.div`
display : flex;
flex-direction : column;
  box-shadow: 0px 0px 10px 0px rgba(48, 97, 185, 0.1);
  img {
    width: 100%
    height: 445px;
    flex-shrink: 0;
    border-radius: 6px 6px 0 0;
  }
`;

const RateBox = styled.div`
  margin-top: 50px;
  display: flex;
  flex-direction: column;
  gap: 30px;
`;

const ProgressBox = styled.div`
  display: flex;
  flex-direction: column;

  .title {
    font-size: 16px;
    font-weight: 600;
    line-height: 17px; /* 121.429% */
    display: flex;
    justify-content: space-between;
  }
`;

const InfoBox = styled.div`
  display: flex;
  flex-direction: column;
  padding: 40px 35px;
  .artist_name {
    font-size: 25px;
    font-weight: 700;
    line-height: 25px; /* 100% */
  }

  .artist_desc {
    margin-top: 30px;
    height: 130px;
    font-size: 14px;
    font-weight: 500;
    line-height: 22px;
  }
`;

const ConfirmButton = styled.div`
  align-self: flex-end;
  width: fit-content;
  margin-bottom: 30px;
  margin-right: 30px;
  padding: 10px 27px;
  border-radius: 6px;
  background: var(--main1-color);
  color: var(--white-color);
  font-size: 18px;
  font-weight: 600;
  line-height: 25px; /* 125% */
  cursor: pointer;
`;

export { FirstBox, SecondBox };
