import React from 'react';
import styled from 'styled-components';
import { LiveInfo, ProcessInfo } from '@type/ProcessInfo';
import { calculateDateDifference } from './EachRankBox';
import ProgressBarFrame from '@components/Button/ProgressBar';
import { ReactComponent as LiveSvg } from '@assets/icons/broadcast.svg';
import axios from '@api/apiController';
import {
  setLiveNickName,
  setLiveSessionId,
  setLiveTitle,
} from '@hooks/useLiveAuth';
import { useNavigate } from 'react-router-dom';
import { DebugDiv } from '@components/util/DebugComponent';

interface Props {
  data: ProcessInfo;
}
const ThumbnailEach: React.FC<Props> = ({ data }) => {
  const leftDate = calculateDateDifference(new Date().toString(), data.endDate);
  return (
    <EachFrame>
      <img
        src={data.profileImg ? data.profileImg : 'src/assets/images/nopic.jpg'}
      ></img>
      <Info>
        <div className="txtInfo">
          <div className="name">{data.title}</div>
          <div className="leftDate">
            {Math.abs(leftDate)} 일{leftDate >= 0 ? ' 남음' : ' 지남'}
          </div>
        </div>
        <ProgressBarFrame
          score={data.nowProcess}
          total={data.totalProcess}
          background="var(--main1-color)"
          height={'6px'}
        />
      </Info>
    </EachFrame>
  );
};
const ThumbnailEachLive = ({ data }: { data: LiveInfo }) => {
  const navigate = useNavigate();
  const handleJoinLive = () => {
    navigate(`/meeting/${data.id}`)
  }

  return (
    <EachFrame onClick={handleJoinLive} >
      <img
        src={
          data.artist.profileImageUrl
            ? data.artist.profileImageUrl
            : 'src/assets/images/nopic.jpg'
        }
      ></img>
      <Info>
        <div className="txtInfo">
          <div className="name">
            <LiveSvg />
            <span className="liveinfo">
              <div className="title">{data.title}</div>
              <DebugDiv>liveId : {data.id}</DebugDiv>
              <div className="artist"> @ {data.artist.stageName}</div>
            </span>
          </div>
        </div>
      </Info>
    </EachFrame>
  );
};

const EachFrame = styled.div`
  display: flex;
  flex-direction: column;
  margin-bottom: 60px;
  cursor: pointer;
  img {
    width: 350px;
    height: 230px;
    border-radius: 3px;
    object-fit: cover;
  }
`;
const Info = styled.div`
  margin-top: 12px;

  .txtInfo {
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 16px;
    font-weight: 700;
    line-height: 25px; /* 125% */

    .leftDate {
      color: var(--main1-color);
      font-size: 14px;
      font-weight: 600;
      line-height: 25px; /* 178.571% */
    }

    .name {
      display: flex;
      align-items: center;
      gap: 5px;
    }

    .liveinfo {
      display: flex;
      align-items: center;
      justify-content: space-between;
      width: 320px;

      svg {
        width: 15px;
        fill: var(--main4-color);
      }

      .title {
        color: var(--main4-color);
        font-weight: 700;
        font-size: 15px;
      }

      .artist {
        color: var(--main4-color);
        font-weight: 500;
        font-size: 14px;
      }
    }
  }
`;
export { ThumbnailEach, ThumbnailEachLive };
