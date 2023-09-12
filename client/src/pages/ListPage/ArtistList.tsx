import styled from 'styled-components';
import SearchBar from '@components/Search/SearchBar';
import { MainTitle } from '@style/common';
import TopRankList from '@components/ListPage/TopRankList';

const ArtistList = () => {
  return (
    <div>
      <TopFrame>
        <MainTitle>
          아티스트<div className="dot"></div>
        </MainTitle>
        <SearchBar />
      </TopFrame>
      <TopRankList />
    </div>
  );
};

const TopFrame = styled.div`
  margin-top: 103px;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

export default ArtistList;
