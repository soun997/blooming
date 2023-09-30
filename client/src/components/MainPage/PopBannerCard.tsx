import React, { useState, useEffect } from 'react';
import styled from 'styled-components';

interface Props {
  imgSrc: string;
}

const PopBannerCard: React.FC<Props> = ({ imgSrc }) => {
  const [rightEdgeColor, setRightEdgeColor] = useState('');

  useEffect(() => {
    const img = new Image();
    img.src = imgSrc;
    img.onload = () => {
      const canvas = document.createElement('canvas');
      canvas.width = 1;
      canvas.height = img.height;
      const ctx = canvas.getContext('2d');

      if (ctx) {
        ctx.drawImage(img, 0, 0, 1, img.height);
        const pixelData = ctx.getImageData(0, 0, 1, img.height).data;
        const rightEdgePixel: number[] = Array.from(pixelData.slice(-4));
        // 오른쪽 가장자리 픽셀의 RGBA값 추출

        // RGBA 값을 HEX로 변환하여 오른쪽 가장자리 색상 설정
        const hexColor = `#${rightEdgePixel
          .slice(0, 3)
          .map((value) => value.toString(16).padStart(2, '0'))
          .join('')}`;

        setRightEdgeColor(hexColor);

        const bannerCard = document.querySelector('.banner-card');
        if (bannerCard instanceof HTMLElement) {
          bannerCard.style.background = `linear-gradient(180deg, ${hexColor} 0%, rgba(30, 30, 30, 0) 100%)`;
        }
      }
    };
  }, []);

  return (
    <BannerCard className="banner-card">
      <img src={imgSrc} alt="" className="banner_img" />
      <BannerInfo>
        <div className="banner_title">
          2023 에일리 전국투어 ‘I AM : COLORFUL’
        </div>
        <div className="banner_desc">
          2023년 겨울, 화려한 무대 매너와 다채로운 음악, 웅장한 무대로 무채색 위
          에일리만의 색을 하나씩 덧그려 완성될 에일리 전국투어 ‘I AM: COLORFUL’
        </div>
      </BannerInfo>
    </BannerCard>
  );
};

const BannerInfo = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 30px auto 0;
  /* padding: 0 10px; */

  .banner_desc {
    color: white;
    font-size: 13px;
    font-weight: 500;
    line-height: 20px;
    justify-self: center;
    margin-top: 30px;
    width: 240px;
    text-align: center;
  }
`;
const BannerCard = styled.div`
  display: flex;
  border-radius: 40px;
  /* border: 0.5px solid rgba(0, 0, 0, 0.15); */
  background: transparent;

  height: 355px;
  width: 700px;

  .banner_title {
    color: white;
    text-align: center;
    font-size: 20px;
    font-weight: 700;
    line-height: 25px;

    margin-top: 17px;
    /* width: 240px; */
  }

  .banner_img {
    object-fit: cover;
    height: 355px;
    /* width: 100%; */
    border-radius: 40px 6px 6px 40px;
  }
`;

export default PopBannerCard;
