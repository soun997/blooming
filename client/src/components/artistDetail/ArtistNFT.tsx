import React from 'react';
import styled from 'styled-components';
import { ReactComponent as LikeIcon } from '../../assets/icons/LikeIcon.svg';
import { ReactComponent as LiveIcon } from '../../assets/icons/LiveIcon.svg';
import { Swiper, SwiperSlide } from 'swiper/react';

import { Navigation, Pagination } from 'swiper/modules';

const ArtistNFT = () => {
  return (
    <NFTInfoBox>
      <NFTInfo>
        <div className="now_nft">NOW NFT</div>
        <img src="src/assets/images/NFT_img.png" alt="" className="nft_img" />
        <div className="nft_name">The Golden Hour: Under the Or..</div>
      </NFTInfo>
      <BuyNFT>
        <div className="buying_number">125 명이 구매한 상품입니다.</div>
        <BuyNFTBtn>구매하기</BuyNFTBtn>
      </BuyNFT>
    </NFTInfoBox>
  );
};
const BuyNFTBtn = styled.button`
  width: 127px;
  height: 38px;
  flex-shrink: 0;

  border-radius: 6px;
  border: none;
  background: var(--Main, #3061b9);

  flex-shrink: 0;

  color: var(--White, #fdfdfd);
  text-align: center;
  font-size: 16px;
  font-weight: 800;
  line-height: 38px;
  letter-spacing: 1.6px;
`;
const BuyNFT = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  width: 285px;
  .buying_number {
    color: var(--Black, var(--black-color, #000));
    font-size: 14px;
    font-weight: 600;
    line-height: 25px;

    margin-bottom: 6px;
  }
`;
const NFTInfo = styled.div`
  .nft_img {
    margin-bottom: 6px;
  }
  .nft_name {
    color: var(--Black, var(--black-color, #000));
    font-size: 14px;
    font-weight: 600;
    line-height: 25px;

    margin-bottom: 55px;
    width: 285px;
    text-align: center;
  }
  .now_nft {
    width: 127px;
    height: 30px;
    flex-shrink: 0;
    margin-bottom: 17px;

    border-radius: 6px;
    border: 2px solid var(--Main, #3061b9);

    color: var(--Main, #3061b9);
    text-align: center;
    font-size: 16px;
    font-weight: 800;
    line-height: 30px;
  }
`;
const NFTInfoBox = styled.div``;
export default ArtistNFT;
