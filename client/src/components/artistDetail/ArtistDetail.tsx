import React from 'react';
import styled from 'styled-components';
import { ReactComponent as LikeIcon } from '../../assets/icons/LikeIcon.svg';
import { ReactComponent as LiveIcon } from '../../assets/icons/LiveIcon.svg';
import { Swiper, SwiperSlide } from 'swiper/react';

import { Navigation, Pagination } from 'swiper/modules';

const ArtistDetail = () => {
  return (
    <ArtistDetailBox>
      <ActiveFundingBox>
        <div className="detail_title">현재 진행중인 활동 펀딩</div>
        <FundingBox>
          <img
            src="src/assets/images/active_funding_img.png"
            alt=""
            className="active_funding_img"
          />
          <FundingTextBox>
            <FundingDesc>
              <div className="funding_desc"></div>
            </FundingDesc>
            <FundingInfo>
              <div className="funding_info"></div>
            </FundingInfo>
          </FundingTextBox>
        </FundingBox>
      </ActiveFundingBox>

      <ConcertFundingBox>
        <div className="detail_title">아티스트 콘서트 펀딩</div>
      </ConcertFundingBox>
      <YoutubeBox>
        <div className="detail_title">아티스트 YOUTUBE</div>
      </YoutubeBox>
      <SearchGraphBox>
        <div className="detail_title">검색결과 분석</div>
      </SearchGraphBox>
    </ArtistDetailBox>
  );
};

const SearchGraphBox = styled.div``;
const YoutubeBox = styled.div``;
const ConcertFundingBox = styled.div``;
const FundingInfo = styled.div``;
const FundingDesc = styled.div``;
const FundingTextBox = styled.div``;
const FundingBox = styled.div`
  height: 360px;
`;
const ActiveFundingBox = styled.div``;
const ArtistDetailBox = styled.div`
  .detail_title {
    color: var(--Black, var(--black-color, #000));
    font-size: 25px;
    font-weight: 700;
    margin-bottom: 24px;
  }
`;
export default ArtistDetail;
