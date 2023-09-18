import React from 'react';
import styled from 'styled-components';
import OpenViduVideoComponent from './OvVideo';
import { Publisher } from 'openvidu-browser'; // Import the Publisher type from openvidu-browser

interface UserVideoComponentProps {
  nickname: string;
  streamManager?: Publisher | null; // Define the streamManager as optional
}

const UserVideoComponent: React.FC<UserVideoComponentProps> = ({
  nickname,
  streamManager,
}) => {
  /**
   * Get the nickname from the streamManager's connection data.
   * @returns {string}
   */
  function getNicknameTag(): string {
    if (streamManager) {
      const connectionData = streamManager.stream.connection?.data;
      if (connectionData) {
        return JSON.parse(connectionData).clientData;
      }
    }
    return nickname;
  }

  return (
    <div>
      {streamManager !== undefined ? (
        <MainVideoContainer>
          <OpenViduVideoComponent streamManager={streamManager} />
          <NicknameBox>{getNicknameTag()}</NicknameBox>
        </MainVideoContainer>
      ) : null}
    </div>
  );
};

const MainVideoContainer = styled.div`
  position: relative;
  margin: 0 auto;

  video {
    width: 100%;
    height: auto;
    cursor: pointer;
  }
`;

const NicknameBox = styled.div`
  position: absolute;
  background: #f8f8f8;
  padding-left: 5px;
  padding-right: 5px;
  color: #777777;
  font-weight: bold;
  border-bottom-right-radius: 4px;
  top: 0;
  left: 0;
`;

export default UserVideoComponent;
