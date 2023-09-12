import React from 'react';
import styled from 'styled-components';

const ResultList = () => {
  return (
    <ResultFrame>
      <NowToggle>
        <div className="toggleTitle">모집중인 NFT 만 보기</div>
      </NowToggle>
    </ResultFrame>
  );
};

const ResultFrame = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 100px;
`;

const NowToggle = styled.div`
  .toggleTitle {
    font-size: 25px;
    font-weight: 700;
  }
`;
export default ResultList;
