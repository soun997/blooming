import { useEffect, useState, useRef } from 'react';
import { OpenVidu, Session, Publisher, StreamManager } from 'openvidu-browser';
import CONSOLE from '@utils/consoleColors';
import axios from '@api/openViduController';
import { MeetingInfo } from '@type/MeetingInfo';
import { ARTIST } from '@components/common/constant';

const OV = new OpenVidu();
const sessionId = 'SessionA';
const loggedInUserNickname = 'ksm';

async function createSession(sessionId: string) {
  const response = await axios.post(`/api/sessions/`, {
    customSessionId: sessionId,
  });
  return response.data;
}

async function createToken(sessionId: string) {
  const response = await axios.post(
    `/api/sessions/${sessionId}/connections`,
    {},
  );
  return response.data;
}

export function useMeeting(isArtist: boolean) {
  const [meetingInfo, setMeetingInfo] = useState<MeetingInfo>({
    mySessionId: sessionId,
    myUserName: isArtist ? ARTIST : loggedInUserNickname,
    session: null,
    mainStreamManager: undefined,
    publisher: undefined,
    prevPublisher: undefined,
    subscribers: [],
    isArtist: isArtist,
  });

  const [videoOption] = useState({
    audioSource: undefined,
    videoSource: undefined,
    publishAudio: false, //!isArtist로 변경할것
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
      const mySession = meetingInfo.session;

      mySession.on('streamCreated', handleStreamCreated);
      mySession.on('streamDestroyed', handleStreamDestroyed);
      mySession.on('exception', handleException);

      getToken(meetingInfo.mySessionId).then((token) => {
        mySession
          .connect(token, {
            clientData: isArtist ? ARTIST : loggedInUserNickname,
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

  const handleStreamCreated = (event: any) => {
    CONSOLE.event('누군가 참여했습니다!!!!!');
    const subscriber = meetingInfo.session?.subscribe(event.stream, undefined);
    const subscribers = meetingInfo.subscribers;
    if (subscriber) {
      subscribers.push(subscriber);
    }

    setMeetingInfo((prevState) => ({
      ...prevState,
      subscribers,
    }));
  };

  const handleStreamDestroyed = (event: any) => {
    CONSOLE.event('누군가 나갔습니다!');
    deleteSubscriber(
      event.stream.streamManager,
      meetingInfo.subscribers,
      setMeetingInfo,
    );
  };

  const handleException = (exception: any) => {
    CONSOLE.event('비동기적 에러가 발생했습니다!');
    console.warn(exception);
  };

  const getToken = async (newSessionId: string) => {
    const sessionId = await createSession(newSessionId).catch((error) => {
      processError(error, '세션 생성 중 오류 발생!');
    });
    return await createToken(sessionId).catch((error) => {
      processError(error, '커넥션 생성 중 오류 발생!');
    });
  };

  const processError = (error: any, message: string) => {
    CONSOLE.error('==== ERROR OCCURED!! ====');
    CONSOLE.error(message);
    console.log(error);
  };

  const deleteSubscriber = (
    streamManager: StreamManager,
    subscribers: StreamManager[],
    setMeetingInfo: React.Dispatch<React.SetStateAction<any>>,
  ) => {
    const index = subscribers.indexOf(streamManager);
    if (index > -1) {
      subscribers.splice(index, 1);
      setMeetingInfo((prevState: MeetingInfo) => ({
        ...prevState,
        subscribers: subscribers,
      }));
    }
  };

  return {
    meetingInfo,
    videoOption,
    isTokenRequested,
    handleStreamCreated,
    handleStreamDestroyed,
    handleException,
    getToken,
  };
}
