import styled from 'styled-components';
import { useQuery } from 'react-query';
import { useState } from 'react';
import axios from '@api/apiController';

import SearchBar from '@components/Search/SearchBar';
import { MainTitle } from '@style/common';
import TopRankList from '@components/ListPage/TopRankList';
import ResultList from '@components/ListPage/ResultList';
import {
  ARTIST,
  CONCERT,
  FUNDING_PHRASES,
  NFT_PHRASES,
  POPULAR,
  RECENTLY,
} from '@components/common/constant';
import { ProcessInfo } from '@type/ProcessInfo';
import Loading from '@components/common/Loading';
import SearchResultTitle from '@components/ListPage/SearchResultTitle';
import { LeftSection, NowToggle, RightSection, SortOption } from './ArtistList';
import ToggleButton from '@components/Button/ToggleButton';

const ConcertList = () => {
  const [keyword, setKeyword] = useState<string>('');
  const [showResult, setShowResult] = useState(false);
  const [searchKeyword, setSearchKeyword] = useState<string>('');
  const [isToggled, setIsToggled] = useState(true);
  const [selectedSort, setSelectedSort] = useState<string>(POPULAR);

  const { isLoading: isLoadingList, data: concertData } = useQuery<
    ProcessInfo[]
  >(['concert-list'], fetchConcertList);
  const { isLoading: isLoadingBest, data: bestConcertData } = useQuery<
    ProcessInfo[]
  >(['concert-best'], fetchBestConcert);
  const { isLoading, data: searchData } = useQuery(
    ['search-result-concert', searchKeyword],
    () => fetchSearchResult(),
  );

  if (
    !concertData ||
    !bestConcertData ||
    !searchData ||
    isLoadingBest ||
    isLoadingList
  ) {
    return <Loading />;
  }

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
      {showResult ? (
        <>
          <SearchResultTitle title={searchKeyword} />
          <ResultList datas={searchData} nowStat={CONCERT} />
        </>
      ) : (
        <>
          <TopRankList nowStat={CONCERT} bestData={bestConcertData} />
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
          <ResultList datas={concertData} nowStat={CONCERT} />
        </>
      )}
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

export default ConcertList;
