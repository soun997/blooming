import { useState } from 'react';
import styled from 'styled-components';
import { ARTIST } from '@components/common/constant';
import UserVideoComponent from '@components/Meeting/UserVideoComponent';
import { useMeeting } from '@hooks/useMeeting';
import { ReactComponent as CameraOff } from '@assets/icons/camera-off.svg';
import { ReactComponent as HideCamera } from '@assets/icons/eye-slash.svg';
import { ReactComponent as ShowCamera } from '@assets/icons/eye.svg';
import { ReactComponent as Setting } from '@assets/icons/setting.svg';

const MeetingPage = ({ isArtist }: { isArtist: boolean }) => {
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
  const [isSettingVisible, setIsSettingVisible] = useState<boolean>(false);
  const [onMyCamera, setMyCamera] = useState<boolean>(true);

  const handleVisibleMyCamera = () => {
    setNotArtistCamera(!notArtistCamera);
    setIsSettingVisible(false);
  };

  const handleSettingBtn = () => {
    setIsSettingVisible(!isSettingVisible); // 설정 버튼 클릭시 설정 메뉴 보이기/숨기기
  };

  const handleCamera = () => {
    handleCameraOnOff({ onMyCamera: !onMyCamera });
    setMyCamera(!onMyCamera);
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
      </MeetingFrame>
    );
  }

  //일반 사용자의 경우
  return (
    <MeetingFrame>
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
          {isSettingVisible && (
            <div className="isNotShow">
              <Button className="hideCamera" onClick={handleCamera}>
                <CameraOff />
                {onMyCamera ? '카메라 끄기' : '카메라 키기'}
              </Button>
              <Button className="offCamera" onClick={handleVisibleMyCamera}>
                <ShowCamera />내 카메라 보기
              </Button>
            </div>
          )}

          <div className="settingBtn" onClick={handleSettingBtn}>
            <div className="settingBackgroud">
              <Setting />
            </div>
          </div>
        </Buttons>
      )}
    </MeetingFrame>
  );
};

const MeetingFrame = styled.div`
  margin: 0px -280px -100px;
  display: flex;
  justify-content: center;
  background-color: var(--black-color);
`;
const Buttons = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-end;
  gap: 10px;
  z-index: 1;
  position: absolute;
  bottom: 10px;
  right: 10px;

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
`;
const Button = styled.button`
  cursor: pointer;
  border: none;
  background-color: var(--main4-color);
  color: var(--white-color);
  padding: 10px 10px;
  width: 160px;
  border-radius: 6px;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 10px;
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
