import React, { useState } from 'react';
import styled from 'styled-components';
import { Carousel } from 'react-responsive-carousel';
import { Swiper, SwiperSlide } from 'swiper/react';
import { Pagination } from 'swiper/modules';

import PopBannerCard from './PopBannerCard';

const PopBannerBox = () => {
  return (
    <BannerBox>
      <Swiper
        slidesPerView={2}
        spaceBetween={1}
        autoplay={true}
        pagination={{
          clickable: true,
        }}
        modules={[Pagination]}
        className="mySwiper"
      >
        <SwiperSlide>
          <PopBannerCard imgSrc="../../src/assets/images/pop_banner_concert1.png" />
        </SwiperSlide>
        <SwiperSlide>
          <PopBannerCard imgSrc="../../src/assets/images/pop_banner_album1.jfif" />
        </SwiperSlide>
        <SwiperSlide>
          <PopBannerCard imgSrc="../../src/assets/images/bts-concert.jpg" />
        </SwiperSlide>
        <SwiperSlide>
          <PopBannerCard imgSrc="../../src/assets/images/pop_banner_concert1.png" />
        </SwiperSlide>
        <SwiperSlide>
          <PopBannerCard imgSrc="../../src/assets/images/pop_banner_album1.jfif" />
        </SwiperSlide>
      </Swiper>
    </BannerBox>
  );
};

const BannerBox = styled.div``;

export default PopBannerBox;
