import CONSOLE from "@utils/consoleColors";

const emojiSUB = (client: React.MutableRefObject<any>, callback:Function, liveId:number | string | undefined) => {
  client.current.subscribe(`/topic/meeting/${liveId}/emoji`, (message:string) => {
    const getEmojiInfo = JSON.parse(message);
    CONSOLE.socket(`RECEIVED ${getEmojiInfo}`);
    callback(getEmojiInfo);
  });
};


const errorSUB = (client: React.MutableRefObject<any>, callback:Function) => {
    client.current.subscribe(`/user/queue/error`, (message:string) => {
      const error = JSON.parse(message);
      callback(error);
    });
  }
export { emojiSUB, errorSUB };
