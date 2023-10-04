import React, { useState } from 'react';
import styled from 'styled-components';
import { useQuery } from 'react-query';
import Loading from '@components/Animation/Loading';
import NoSearchResults from '@components/Search/NoSearchResults';
import { APPROVE, INPROGRESS, REJECT } from '@components/common/constant';
import { ArtistAdmit } from '@type/AdminAdmit';
import DetailModal from './DetailModal';

import axiosTemp from '@api/apiControllerTemp';

const ArtistList = () => {
  const [activeTab, setActiveTab] = useState(INPROGRESS); // 현재 활성 탭 상태
  const [selectedArtistData, setArtistData] = useState<ArtistAdmit | null>(
    null,
  );

  const handleArtistData = (artistData: ArtistAdmit) => {
    if (activeTab === INPROGRESS) {
      setArtistData(artistData);
    }
  };

  const handleModalClose = () => {
    setArtistData(null);
  };

  const handleApprove = () => {
    // !승인 처리 로직 추가
    handleModalClose();
  };

  const handleReject = () => {
    // ! 거절 처리 로직 추가
    handleModalClose();
  };

  // API 엔드포인트와 쿼리 키 설정
  const apiEndpoint = getApiEndpointByTab(activeTab); // activeTab에 따라 엔드포인트 설정
  const queryKey = ['artistList', activeTab];

  // React Query를 사용하여 데이터 가져오기
  const { data, isLoading, isError } = useQuery<ArtistAdmit[], Error>(
    queryKey,
    fetchArtistData,
  );

  function getApiEndpointByTab(tab: string): string {
    switch (tab) {
      //추후 변경
      case INPROGRESS:
        return '/artist-admit';
      case APPROVE:
        return '/artist-admit';
      case REJECT:
        return '/artist-admit';
      default:
        throw new Error(`Invalid tab: ${tab}`);
    }
  }

  // 데이터를 가져오는 함수
  async function fetchArtistData(): Promise<ArtistAdmit[]> {
    const response = await axiosTemp.get(apiEndpoint);
    console.log(response.data);
    return response.data.results.content;
  }

  return (
    <div>
      {/* 탭 메뉴 */}
      <TabMenu>
        <TabItem
          onClick={() => setActiveTab(INPROGRESS)}
          $isActive={activeTab === INPROGRESS}
        >
          승인 대기중
        </TabItem>
        <TabItem
          onClick={() => setActiveTab(APPROVE)}
          $isActive={activeTab === APPROVE}
        >
          승인됨
        </TabItem>
        <TabItem
          onClick={() => setActiveTab(REJECT)}
          $isActive={activeTab === REJECT}
        >
          승인거부
        </TabItem>
      </TabMenu>

      {/* 데이터 표시 */}
      {isLoading ? (
        <div>
          <Loading />
        </div>
      ) : isError ? (
        <div>
          <NoSearchResults />
        </div>
      ) : (
        <>
          <ResultDataFrame>
            {data?.map((artist, idx) => (
              <EachResultData
                key={idx}
                onClick={() => handleArtistData(artist)}
              >
                <ThumbnailImg>
                  <img src={artist.profileImageUrl} />
                </ThumbnailImg>
                <TextInfo>
                  <div className="title">{artist.stageName}</div>
                  <div className="info">{artist.agency}</div>
                </TextInfo>
              </EachResultData>
            ))}
          </ResultDataFrame>
          <DetailModal
            isOpen={!!selectedArtistData}
            onClose={handleModalClose}
            artistData={selectedArtistData || ({} as ArtistAdmit)}
            onApprove={handleApprove}
            onReject={handleReject}
          />
        </>
      )}
    </div>
  );
};

const TabMenu = styled.div`
  display: flex;
  gap: 12px;
`;

const TabItem = styled.div<{ $isActive: boolean }>`
  padding: 8px 16px;
  cursor: pointer;
  background-color: ${(props) =>
    props.$isActive ? 'var(--main1-color)' : 'var(--white-color)'};
  color: ${(props) =>
    props.$isActive ? 'var(--white-color)' : 'var(--black-color)'};
  border: 2px solid
    ${(props) =>
      props.$isActive ? 'var(--white-color)' : 'var(--background2-color)'};
  border-radius: 4px;
`;

const ResultDataFrame = styled.div`
  margin-top: 30px;
  display: flex;
  /* flex-direction: column; */
  justify-content: space-between;
  flex-wrap: wrap;
`;

const EachResultData = styled.div`
  cursor: pointer;
  display: flex;
  align-items: center;
  /* justify-content: space-between; */
  gap: 30px;
  width: 500px;
  height: 100px;
  margin-bottom: 20px;
  padding: 20px;
  border: 1px solid var(--main3-color);
  border-radius: 6px;
`;

const ThumbnailImg = styled.div`
  img {
    width: 100px;
    height: 100px;
    object-fit: cover;
    border-radius: 6px;
  }
`;

const TextInfo = styled.div`
  display: flex;
  flex-direction: column;

  .title {
    font-weight: 600;
    font-size: 18px;
  }
  .info {
    margin-top: 20px;
    font-weight: 400;
    font-size: 14px;
  }
`;
export default ArtistList;
