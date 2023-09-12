import ToggleButton from '@components/Button/ToggleButton';
import { ArtistInfo } from '@type/Artist';
import { useState } from 'react';
import styled from 'styled-components';
import ThumbnailEach from './ThumbnailEach';

interface Props {
  datas: ArtistInfo[];
}
const ResultList: React.FC<Props> = ({ datas }) => {
  const [isToggled, setIsToggled] = useState(false);

  const handleToggleChange = (checked: boolean) => {
    setIsToggled(checked);
  };

  return (
    <ResultFrame>
      <NowToggle>
        <div className="toggleTitle">모집중인 NFT 만 보기</div>
        <ToggleButton
          defaultChecked={isToggled}
          onChange={handleToggleChange}
        />
      </NowToggle>
      <BoxFrame>
        {datas.map((data) => (
          <ThumbnailEach data={data} />
        ))}
      </BoxFrame>
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
  display: flex;
  gap: 10px;
  align-items: center;
`;

const BoxFrame = styled.div`
  margin-top: 48px;
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
`;
export default ResultList;
