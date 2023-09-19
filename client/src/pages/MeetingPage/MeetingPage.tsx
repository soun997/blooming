import { OpenVidu } from 'openvidu-browser';
import styled from 'styled-components';

import { ARTIST } from '@components/common/constant';
import UserVideoComponent from '@components/Meeting/UserVideoComponent';
import { useMeeting } from '@hooks/useMeeting';
import { ReactComponent as CameraOff } from '@assets/icons/camera-off.svg';
import { ReactComponent as HideCamera } from '@assets/icons/eye-slash.svg';

function MeetingPage({ isArtist }: { isArtist: boolean }) {
  const {
    meetingInfo,
    videoOption,
    isTokenRequested,
    handleStreamCreated,
    handleStreamDestroyed,
    handleException,
    getToken,
  } = useMeeting(isArtist);

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

      <MyCamera>
        <div className="buttons">
          <button className="hideCamera">
            <CameraOff />
            카메라 끄기
          </button>
          <button className="offCamera">
            <HideCamera />
            숨기기
          </button>
        </div>
        <UserVideoComponent
          nickname={meetingInfo.myUserName}
          streamManager={meetingInfo.publisher}
        />
      </MyCamera>
    </MeetingFrame>
  );
}

const MeetingFrame = styled.div`
  margin: 0px -280px -100px;
  display: flex;
  justify-content: center;
  background-color: var(--black-color);
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

    button {
      cursor: pointer;
      border: none;
      background-color: var(--main4-color);
      color: var(--white-color);
      padding: 10px 10px;
      width: 120px;
      border-radius: 6px;
      display: flex;
      align-items: center;
      justify-content: center;
      gap: 10px;

      svg.fill {
        color: white;
      }
    }
  }

  &:hover .buttons {
    display: flex; /* hover 시 버튼 표시 */
    flex-direction: column;
    gap: 10px;
    z-index: 2;
  }
`;
export default MeetingPage;
