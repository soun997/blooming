import { useState } from 'react';
import styled from 'styled-components';
import { ARTIST } from '@components/common/constant';
import UserVideoComponent from '@components/Meeting/UserVideoComponent';
import { useMeeting } from '@hooks/useMeeting';
import { ReactComponent as CameraOff } from '@assets/icons/camera-off.svg';
import { ReactComponent as CameraOn } from '@assets/icons/camera-on.svg';
import { ReactComponent as HideCamera } from '@assets/icons/eye-slash.svg';
import { ReactComponent as ShowCamera } from '@assets/icons/eye.svg';
import { ReactComponent as NoticeSvg } from '@assets/icons/megaphone.svg';
import { ReactComponent as LiveSvg } from '@assets/icons/youtube-logo.svg';
import { ReactComponent as ArrowLeft } from '@assets/icons/arrow-left.svg';
import { ReactComponent as ExitSvg } from '@assets/icons/sign-out.svg';
import { useNavigate } from 'react-router-dom';

const MeetingName = '나 김아무개 아티스트가 여는 콘서트다!';
const MeetingPage = ({ isArtist }: { isArtist: boolean }) => {
  const navigate = useNavigate();
  const {
    meetingInfo,
    videoOption,
    isTokenRequested,
    handleCameraOnOff,
    handleStreamCreated,
    handleStreamDestroyed,
    handleException,
    getToken,
  } = useMeeting(isArtist);

  const [notArtistCamera, setNotArtistCamera] = useState<boolean>(false);
  const [onMyCamera, setMyCamera] = useState<boolean>(true);
  const [showNotice, setShowNotice] = useState<boolean>(true);

  const handleVisibleMyCamera = () => {
    setNotArtistCamera(!notArtistCamera);
  };

  const handleCamera = () => {
    handleCameraOnOff({ onMyCamera: !onMyCamera });
    setMyCamera(!onMyCamera);
  };
  const handlePageOut = () => {
    navigate(-1);
  };

  const handleNoticeInfo = () => {
    setShowNotice(!showNotice);
  };

  const handleExit = () => {
    //나가기 처리
  };

  // 아티스트일 경우!!
  if (meetingInfo.isArtist) {
    return (
      <MeetingFrame>
        <UserVideoComponent
          nickname={meetingInfo.myUserName}
          streamManager={meetingInfo.publisher}
          isMain={true}
        />
        <Buttons>
          <Button className="exit" onClick={handleExit}>
            <ExitSvg />
            종료하기
          </Button>
        </Buttons>
        <NoticeBoard>
          {showNotice ? (
            <span>
              <LiveSvg />
              {MeetingName}
            </span>
          ) : (
            `현재 ${meetingInfo.subscribers.length}명이 시청 중입니다`
          )}
          <NoticeSvg onClick={handleNoticeInfo} />
        </NoticeBoard>
      </MeetingFrame>
    );
  }

  //일반 사용자의 경우
  return (
    <MeetingFrame>
      <div className="navigateBtn" onClick={handlePageOut}>
        <ArrowLeft />
      </div>
      {/* 아티스트만 띄우기 */}
      {meetingInfo.subscribers
        .filter((sub) => {
          if (sub.stream.connection?.data) {
            return JSON.parse(sub.stream.connection.data).clientData === ARTIST;
          }
          return false;
        })
        .slice(0, 1)
        .map((sub, idx) => (
          <div
            key={idx}
            className=""
            onClick={() => {
              console.log('>> print sub, ', sub);
            }}
          >
            <UserVideoComponent
              nickname={sub.stream.streamId}
              streamManager={sub}
              isMain={true}
            />
          </div>
        ))}
      <NoticeBoard>
        {showNotice ? (
          <span>
            <LiveSvg />
            {MeetingName}
          </span>
        ) : (
          `현재 ${meetingInfo.subscribers.length}명이 시청 중입니다`
        )}
        <NoticeSvg onClick={handleNoticeInfo} />
      </NoticeBoard>
      {notArtistCamera ? (
        <MyCamera>
          <div className="buttons">
            <Button className="hideCamera" onClick={handleCamera}>
              <CameraOff />
              {onMyCamera ? '카메라 끄기' : '카메라 키기'}
            </Button>
            <Button className="offCamera" onClick={handleVisibleMyCamera}>
              <HideCamera />
              숨기기
            </Button>
          </div>
          <UserVideoComponent
            nickname={meetingInfo.myUserName}
            streamManager={meetingInfo.publisher}
          />
        </MyCamera>
      ) : (
        <Buttons>
          <div className="settingBtn" onClick={handleVisibleMyCamera}>
            <span className="text">내 화면 보기</span>
            <div className="settingBackgroud">
              <ShowCamera />
            </div>
          </div>
          <div className="settingBtn" onClick={handleCamera}>
            <span className="text">
              {onMyCamera ? '카메라 끄기' : '카메라 키기'}
            </span>
            <div className="settingBackgroud">
              {onMyCamera ? <CameraOff /> : <CameraOn />}
            </div>
          </div>
        </Buttons>
      )}
    </MeetingFrame>
  );
};

const NoticeBoard = styled.div`
  display: flex;
  align-items: center;
  gap: 10px;
  z-index: 1;
  position: absolute;
  top: 15px;
  right: 20px;
  color: var(--white-color);
  font-size: 15px;
  span {
    width: 280px;
    height: fit-content;
    padding: 5px 14px;
    background-color: #ffffffba;
    border-radius: 6px;
    display: flex;
    align-items: center;
    justify-content: space-evenly;
    font-weight: 600;
    color: var(--black-color);
  }

  svg {
    cursor: pointer;
  }
`;
const MeetingFrame = styled.div`
  margin: 0px -280px -100px;
  display: flex;
  justify-content: center;
  min-height: 100dvh;
  background-color: var(--black-color);

  .navigateBtn {
    cursor: pointer;
    position: absolute;
    top: 10px;
    left: 10px;
  }
`;
const Buttons = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-end;
  gap: 10px;
  z-index: 1;
  position: absolute;
  bottom: 20px;
  right: 20px;

  .settingBackgroud {
    background-color: var(--main3-color);
    border-radius: 50%;
    width: 40px;
    height: 40px;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .isNotShow {
    display: flex;
    gap: 6px;
    flex-direction: column;
  }

  .settingBtn {
    cursor: pointer;
    display: flex;
    align-items: center;
    gap: 10px;
    color: var(--white-color);
    font-size: 12px;
  }

  .exit {
    background-color: var(--error-color);
    color: white;
    font-weight: 600;
    font-size: 15px;
  }
`;
const Button = styled.button`
  cursor: pointer;
  border: none;
  background-color: var(--main3-color);
  padding: 10px 10px;
  width: 160px;
  border-radius: 6px;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 10px;
  font-weight: 600;
`;

const MyCamera = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1;
  position: absolute;
  bottom: 0;
  right: 0;
  width: 280px;

  .buttons {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    display: none; /* 기본적으로 숨겨짐 */
  }

  &:hover .buttons {
    display: flex; /* hover 시 버튼 표시 */
    flex-direction: column;
    gap: 10px;
    z-index: 2;
  }
`;
export default MeetingPage;
