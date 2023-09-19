import styled from 'styled-components';
import { useQuery } from 'react-query';

import axios from '@api/apiController';

import SearchBar from '@components/Search/SearchBar';
import { MainTitle } from '@style/common';
import TopRankList from '@components/ListPage/TopRankList';
import ResultList from '@components/ListPage/ResultList';
import { ProcessInfo } from '@type/ProcessInfo';
import { ACTIVE } from '@components/common/constant';

const ActiveList = () => {
  const { data: activeData } = useQuery<ProcessInfo[]>(
    ['active-list'],
    fetchConcertList,
  );
  const { data: bestActiveData } = useQuery<ProcessInfo[]>(
    ['active-best'],
    fetchBestConcert,
  );

  if (!activeData || !bestActiveData) {
    return <></>;
  }

  return (
    <div>
      <TopFrame>
        <MainTitle>
          활동<div className="dot"></div>
        </MainTitle>
        <SearchBar nowStat={ACTIVE} />
      </TopFrame>
      <TopRankList nowStat={ACTIVE} bestData={bestActiveData} />
      <ResultList datas={activeData} nowStat={ACTIVE} />
    </div>
  );
};

const fetchConcertList = async () => {
  console.log('fetch 까지 들어옴');
  try {
    const response = await axios.get('/active');
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error('활동 리스트 요청 실패');
  }
};

const fetchBestConcert = async () => {
  try {
    const response = await axios.get('/active-best');
    return response.data;
  } catch (error) {
    console.log(error);
    throw new Error('활동 베스트 리스트 요청 실패');
  }
};

const TopFrame = styled.div`
  margin-top: 100px;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

export default ActiveList;
