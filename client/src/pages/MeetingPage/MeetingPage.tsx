import React, { useEffect, useState, useRef } from 'react';
import {
  OpenVidu,
  Session,
  Publisher,
  Subscriber,
  StreamManager,
} from 'openvidu-browser';
import CONSOLE from '@utils/consoleColors';
import axios from '@api/openViduController';
import UserVideoComponent from '@components/Meeting/UserVideoComponent';
import { MeetingInfo } from '@type/MeetingInfo';

const OV = new OpenVidu();

let mySession: Session;

const sessionId = 'SessionA';
const loggedInUserNickname = 'ksm';

const additionalBaseUrl = `/api/sessions/`;

async function createSession(sessionId: string) {
  const response = await axios.post(additionalBaseUrl, {
    customSessionId: sessionId,
  });
  return response.data;
}

async function createToken(sessionId: string) {
  const response = await axios.post(
    additionalBaseUrl + sessionId + '/connections',
    {},
  );
  return response.data;
}

const MeetingPage = ({ isArtist }: { isArtist: boolean }) => {
  const [meetingInfo, setMeetingInfo] = useState<MeetingInfo>({
    mySessionId: sessionId,
    myUserName: isArtist ? '아티스트' : loggedInUserNickname,
    session: null as Session | null,
    mainStreamManager: undefined as Publisher | undefined,
    publisher: undefined as Publisher | undefined,
    prevPublisher: undefined as Publisher | undefined,
    subscribers: [],
    isArtist: isArtist,
  });

  const [videoOption, setVideoOption] = useState({
    audioSource: undefined,
    videoSource: undefined,
    publishAudio: isArtist,
    publishVideo: true,
    resolution: '640x480',
    frameRate: 30,
    insertMode: 'APPEND',
    mirror: true,
  });

  const isTokenRequested = useRef(false);

  useEffect(() => {
    CONSOLE.info('세션을 시작합니다.');

    setMeetingInfo((prevState) => ({
      ...prevState,
      session: OV.initSession(),
    }));
  }, []);

  useEffect(() => {
    if (meetingInfo.session && !isTokenRequested.current) {
      CONSOLE.info('서버에 토큰을 요청합니다.');
      isTokenRequested.current = true;
      mySession = meetingInfo.session;

      mySession.on('streamCreated', (event) => {
        CONSOLE.event('누군가 참여했습니다!!!!!');
        console.log('mySession', mySession);
        const subscriber = mySession.subscribe(event.stream, undefined);
        console.log('>>> 기존 ', meetingInfo);
        const subscribers = meetingInfo.subscribers;
        subscribers.push(subscriber);

        console.log('SUBSCRIBER!!!!!!!!!!');
        console.log(subscribers);

        setMeetingInfo((prevState) => ({
          ...prevState,
          subscribers,
        }));
      });

      mySession.on('streamDestroyed', (event) => {
        CONSOLE.event('누군가 나갔습니다!');
        deleteSubscriber(
          event.stream.streamManager,
          meetingInfo.subscribers,
          setMeetingInfo,
        );
      });

      mySession.on('exception', (exception) => {
        CONSOLE.event('비동기적 에러가 발생했습니다!');
        console.warn(exception);
      });

      getToken(meetingInfo.mySessionId).then((token) => {
        const mySession = meetingInfo.session;
        mySession &&
          mySession
            .connect(token, {
              clientData: isArtist ? '아티스트' : loggedInUserNickname,
            })
            .then(async () => {
              const publisher = await OV.initPublisherAsync(
                undefined,
                videoOption,
              );

              mySession && mySession.publish(publisher);
              setMeetingInfo((prevState) => ({
                ...prevState,
                mainStreamManager: publisher,
                publisher: publisher,
                prevPublisher: undefined,
              }));
            });
      });
    }
  }, [meetingInfo]);

  return (
    <div>
      <UserVideoComponent
        nickname={meetingInfo.myUserName}
        streamManager={meetingInfo.publisher}
      />
      {meetingInfo.subscribers.map((sub, idx) => (
        <div
          key={idx}
          className=""
          onClick={() => {
            console.log('>> print sub, ', sub);
          }}
        >
          <span>{sub.stream.streamId}</span>
          <UserVideoComponent
            nickname={sub.stream.streamId}
            streamManager={sub}
          />
        </div>
      ))}
    </div>
  );
};

async function getToken(newSessionId: string) {
  const sessionId = await createSession(newSessionId).catch((error) => {
    processError(error, '세션 생성 중 오류 발생!');
  });
  return await createToken(sessionId).catch((error) => {
    processError(error, '커넥션 생성 중 오류 발생!');
  });
}

function processError(error: any, message: string) {
  CONSOLE.error('==== ERROR OCCURED!! ====');
  CONSOLE.error(message);
  console.log(error);
}

function deleteSubscriber(
  streamManager: StreamManager,
  subscribers: StreamManager[],
  setMeetingInfo: React.Dispatch<React.SetStateAction<any>>,
) {
  const index = subscribers.indexOf(streamManager);
  if (index > -1) {
    subscribers.splice(index, 1);
    setMeetingInfo((prevState: MeetingInfo) => ({
      ...prevState,
      subscribers: subscribers,
    }));
  }
}

export default MeetingPage;
