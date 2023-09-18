import { Session, Publisher, Subscriber } from 'openvidu-browser'; // Import Session, Publisher, Subscriber

export interface MeetingInfo {
  mySessionId: string;
  myUserName: string;
  session: undefined | Session;
  mainStreamManager: Publisher | undefined;
  publisher: Publisher | undefined;
  prevPublisher: Publisher | undefined;
  subscribers: Subscriber[];
}
