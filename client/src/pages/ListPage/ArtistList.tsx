import styled from 'styled-components';
import { useQuery } from 'react-query';

import axios from '@api/apiController';
import SearchBar from '@components/Search/SearchBar';
import { MainTitle } from '@style/common';
import TopRankList from '@components/ListPage/TopRankList';
import ResultList from '@components/ListPage/ResultList';
import { ARTIST } from '@components/common/constant';
import { useState } from 'react';

const ArtistList = () => {
  const { data: artistData } = useArtistQuery();
  const { data: bestArtistData } = useArtistBestQuery();
  const [keyword, setKeyword] = useState<string>('');
  const [showResult, setShowResult] = useState(false);

  if (!artistData || !bestArtistData) {
    //!oading 페이지
    return <></>;
  }

  const handleSearch = () => {
    setShowResult(true);
  };
  return (
    <div>
      <TopFrame>
        <MainTitle>
          아티스트<div className="dot"></div>
        </MainTitle>
        <SearchBar
          nowStat={ARTIST}
          keyword={keyword}
          setKeyword={setKeyword}
          onSearch={handleSearch}
        />
      </TopFrame>
      <TopRankList bestData={bestArtistData} nowStat={ARTIST} />
      <ResultList datas={artistData} nowStat={ARTIST} />
    </div>
  );
};

const fetchArtistList = async () => {
  try {
    const response = await axios.get('/artist');
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error('아티스트 리스트 요청 실패');
  }
};

const fetchBestArtist = async () => {
  try {
    const response = await axios.get('/artist-best');
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error('아티스트 베스트 리스트 요청 실패');
  }
};

const useArtistQuery = () => {
  return useQuery(['artist-list'], () => fetchArtistList(), {});
};
const useArtistBestQuery = () => {
  return useQuery(['artist-best'], () => fetchBestArtist(), {});
};

const TopFrame = styled.div`
  margin-top: 100px;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

export default ArtistList;
