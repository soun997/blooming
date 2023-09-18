import React, { useEffect, useState, useRef } from 'react';
import {
  OpenVidu,
  Session,
  Publisher,
  Subscriber,
  StreamManager,
} from 'openvidu-browser'; // Import Session, Publisher, Subscriber
import CONSOLE from '@utils/consoleColors';
import axios from '@api/openViduController';
import UserVideoComponent from '@components/Meeting/UserVideoComponent';
import { MeetingInfo } from '@type/MeetingInfo';

const OV = new OpenVidu();

let mySession: Session | null;

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

const MeetingPage = () => {
  const initialMeetingInfo = {
    mySessionId: sessionId,
    myUserName: loggedInUserNickname,
    session: undefined as Session | undefined,
    mainStreamManager: undefined as Publisher | undefined,
    publisher: undefined as Publisher | undefined,
    prevPublisher: undefined as Publisher | undefined,
    subscribers: [] as Subscriber[],
  };

  const [meetingInfo, setMeetingInfo] = useState(initialMeetingInfo);
  const [videoOption, setVideoOption] = useState({
    audioSource: undefined,
    videoSource: undefined,
    publishAudio: true,
    publishVideo: true,
    resolution: '640x480',
    frameRate: 30,
    insertMode: 'APPEND',
    mirror: false,
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
        CONSOLE.event('누군가 참여했습니다!');
        if (mySession) {
          const subscriber = mySession.subscribe(event.stream, undefined);
          const subscribers = [...meetingInfo.subscribers];
          subscribers.push(subscriber);
          setMeetingInfo((prevState) => ({
            ...prevState,
            subscribers: subscribers,
          }));
        }
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
        mySession &&
          mySession
            .connect(token, { clientData: loggedInUserNickname })
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
  subscribers: Subscriber[],
  setMeetingInfo: React.Dispatch<React.SetStateAction<any>>,
) {
  // StreamManager를 Subscriber로 변환
  const subscriber = subscribers.find(
    (sub) => sub.stream.streamManager === streamManager,
  );
  if (subscriber) {
    subscribers.splice(subscribers.indexOf(subscriber), 1);
    setMeetingInfo((prevState: MeetingInfo) => ({
      ...prevState,
      subscribers: subscribers,
    }));
  }
}

export default MeetingPage;
