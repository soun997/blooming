import styled from 'styled-components';
import { useQuery } from 'react-query';
import { useState } from 'react';

import axios from '@api/apiController';

import SearchBar from '@components/Search/SearchBar';
import { MainTitle } from '@style/common';
import TopRankList from '@components/ListPage/TopRankList';
import ResultList from '@components/ListPage/ResultList';
import { ProcessInfo } from '@type/ProcessInfo';
import {
  ACTIVE,
  FUNDING_PHRASES,
  POPULAR,
  RECENTLY,
} from '@components/common/constant';
import SearchResultTitle from '@components/ListPage/SearchResultTitle';
import { LeftSection, NowToggle, RightSection, SortOption } from './ArtistList';
import ToggleButton from '@components/Button/ToggleButton';

const ActiveList = () => {
  const [keyword, setKeyword] = useState<string>('');
  const [showResult, setShowResult] = useState(false);
  const [searchKeyword, setSearchKeyword] = useState<string>('');
  const [isToggled, setIsToggled] = useState(true);
  const [selectedSort, setSelectedSort] = useState<string>(POPULAR);

  const { data: activeData } = useQuery<ProcessInfo[]>(
    ['active-list'],
    fetchConcertList,
  );
  const { data: bestActiveData } = useQuery<ProcessInfo[]>(
    ['active-best'],
    fetchBestConcert,
  );
  const { isLoading, data: searchData } = useQuery(
    ['search-result-active', searchKeyword],
    () => fetchSearchResult(),
  );

  const handleSearch = (data?: string, isArtistSearch?: boolean) => {
    setSearchKeyword(data ? data : keyword);
    setShowResult(true);
    if (isArtistSearch === undefined) {
      //아티스트 NFT 검색
      console.log('i am nft');
    } else {
      if (isArtistSearch) {
        //아티스트로 검색
        console.log('artist');
      } else {
        //콘서트나 활동명으로 검색
        console.log('concert or activity');
      }
    }
  };

  const handleToggleChange = (checked: boolean) => {
    setIsToggled(checked);
  };

  const handleSortChange = (sort: string) => {
    setSelectedSort(sort);
  };

  if (!activeData || !bestActiveData || !searchData) {
    return <></>;
  }

  return (
    <div>
      <TopFrame>
        <MainTitle>
          활동<div className="dot"></div>
        </MainTitle>
        <SearchBar
          nowStat={ACTIVE}
          keyword={keyword}
          setKeyword={setKeyword}
          onSearch={handleSearch}
        />
      </TopFrame>
      {showResult ? (
        <>
          <SearchResultTitle title={searchKeyword} />
          <ResultList datas={searchData} nowStat={ACTIVE} />
        </>
      ) : (
        <>
          <TopRankList bestData={bestActiveData} nowStat={ACTIVE} />
          <NowToggle>
            <LeftSection>
              <div className="toggleTitle">
                모집중인 {FUNDING_PHRASES.name}만 보기
              </div>
              <ToggleButton
                defaultChecked={isToggled}
                onChange={handleToggleChange}
              />
            </LeftSection>
            <RightSection>
              <SortOption
                onClick={() => handleSortChange(POPULAR)}
                isSelected={selectedSort === POPULAR}
              >
                인기순
              </SortOption>
              |
              <SortOption
                onClick={() => handleSortChange(RECENTLY)}
                isSelected={selectedSort === RECENTLY}
              >
                최신순
              </SortOption>
            </RightSection>
          </NowToggle>
          <ResultList datas={activeData} nowStat={ACTIVE} />
        </>
      )}
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
const fetchSearchResult = async () => {
  try {
    const response = await axios.get('/search-result');
    return response.data;
  } catch (error) {
    console.log(error);
  }
};

const TopFrame = styled.div`
  margin-top: 100px;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

export default ActiveList;
