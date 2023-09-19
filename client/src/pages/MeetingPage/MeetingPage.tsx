import { OpenVidu } from 'openvidu-browser';

import UserVideoComponent from '@components/Meeting/UserVideoComponent';

import { useMeeting } from '@hooks/useMeeting'; // 새로 추가된 Hook
import { ARTIST } from '@components/common/constant';

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
      <div>
        <UserVideoComponent
          nickname={meetingInfo.myUserName}
          streamManager={meetingInfo.publisher}
        />
      </div>
    );
  }

  return (
    <div>
      <UserVideoComponent
        nickname={meetingInfo.myUserName}
        streamManager={meetingInfo.publisher}
      />

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
            <span>{'아티스트 명 출력할 부분'}</span>
            <UserVideoComponent
              nickname={sub.stream.streamId}
              streamManager={sub}
            />
          </div>
        ))}
    </div>
  );
}

export default MeetingPage;
