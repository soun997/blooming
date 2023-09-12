import React from 'react';
import styled from 'styled-components';

const MainPage = () => {
  return (
    <FundingDetailBox>
      <div className="funding_detail">투자 상품 상세</div>
      <TabBox></TabBox>

      <DetailBox>
        <AlbumInfoBox>
          <div className="detail_title">앨범 정보</div>
          <div className="detail_sub_title">앨범 소개</div>
          <div className="detail_text">
            폭넓은 보컬 스펙트럼과 특유의 매력적인 보이스로 수많은 리스너를
            매료시키고 있는 가수 김재환.지난해 12월 미니앨범 [THE LETTER] 발매
            이후 약 9개월 만에 발표하는 김재환의 다섯번째 미니앨범. `그 시절
            우리는`은 이별 후 함께했던 시간을 떠올리며 상대방에 대한 그리움을
            김재환만의 감성을 통해 서정적으로 풀어낸 미디엄 R&B 팝 장르의
            곡이다. 직접 작사, 작곡에 참여한 김재환은 과거의 행복하고 반짝였던
            기억을 회고하는 듯한 독백적인 가사와 이별의 그리움을 청량하게 표현한
            멜로디로 곡을 완성해 이별을 겪어 본 사람들의 아련한 감성을 자극했다.
          </div>
          <div className="detail_sub_title">앨범 트랙리스트</div>
          <img src="" alt="앨범 트랙리스트" className="album_tracklist" />
          <div className="detail_sub_title">앨범 티저영상</div>
          <div className="detail_sub_title">앨범 구성품</div>
          <div className="detail_sub_title">투자상품 개요</div>
        </AlbumInfoBox>
        <RevenueAnalysisBox>
          <div className="detail_title">지난 활동 수익 분석</div>
        </RevenueAnalysisBox>
        <OtherActionBox>
          <div className="detail_title">기타 활동</div>
        </OtherActionBox>
        <PortfolioBox>
          <div className="detail_title">아티스트 포트폴리오</div>
        </PortfolioBox>
        <InvestmentInfoBox>
          <div className="detail_title">투자 위험 안내</div>
        </InvestmentInfoBox>
      </DetailBox>
    </FundingDetailBox>
  );
};

const InvestmentInfoBox = styled.div``;
const PortfolioBox = styled.div``;
const OtherActionBox = styled.div``;
const RevenueAnalysisBox = styled.div``;
const AlbumInfoBox = styled.div``;
const DetailBox = styled.div`
  .detail_text {
    font-size: 14px;
    font-weight: 600;
    line-height: 30px;
  }
  .detail_sub_title {
    font-size: 18px;
    font-weight: 700;
    line-height: 30px;
    margin-bottom: 15px;
  }

  .detail_title {
    font-size: 20px;
    font-weight: 700;
    margin-bottom: 36px;
  }
`;
const TabBox = styled.div``;

const FundingDetailBox = styled.div`
  .funding_detail {
    font-size: 25px;
    font-style: normal;
    font-weight: 700;
    line-height: normal;
    color: #000000;
  }
`;

export default MainPage;
