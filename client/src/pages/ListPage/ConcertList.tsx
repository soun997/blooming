import styled from 'styled-components';
import { useQuery } from 'react-query';
import { useState } from 'react';
import axios from '@api/apiController';

import SearchBar from '@components/Search/SearchBar';
import { MainTitle } from '@style/common';
import TopRankList from '@components/ListPage/TopRankList';
import ResultList from '@components/ListPage/ResultList';
import { CONCERT } from '@components/common/constant';
import { ProcessInfo } from '@type/ProcessInfo';

const ConcertList = () => {
  const [keyword, setKeyword] = useState<string>('');
  const [showResult, setShowResult] = useState(false);

  const { isLoading: isLoadingList, data: concertData } = useQuery<
    ProcessInfo[]
  >(['concert-list'], fetchConcertList);
  const { isLoading: isLoadingBest, data: bestConcertData } = useQuery<
    ProcessInfo[]
  >(['concert-best'], fetchBestConcert);

  if (!concertData || !bestConcertData || isLoadingBest || isLoadingList) {
    return <></>;
  }

  const handleSearch = (data?: string) => {
    if (data) {
      console.log(`검색할게 ${data}`);
    } else {
      console.log(`검색할게 ${keyword}`);
    }
    setShowResult(true);
  };

  return (
    <div>
      <TopFrame>
        <MainTitle>
          콘서트<div className="dot"></div>
        </MainTitle>
        <SearchBar
          nowStat={CONCERT}
          keyword={keyword}
          setKeyword={setKeyword}
          onSearch={handleSearch}
        />
      </TopFrame>
      <TopRankList nowStat={CONCERT} bestData={bestConcertData} />
      <ResultList datas={concertData} nowStat={CONCERT} />
    </div>
  );
};

const fetchConcertList = async () => {
  try {
    const response = await axios.get('/concert');
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error('콘서트 리스트 요청 실패');
  }
};

const fetchBestConcert = async () => {
  try {
    const response = await axios.get('/concert-best');
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error('콘서트 베스트 리스트 요청 실패');
  }
};

const TopFrame = styled.div`
  margin-top: 100px;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

export default ConcertList;
