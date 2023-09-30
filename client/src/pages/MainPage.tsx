import React from 'react';
import styled from 'styled-components';

import Navbar from '@components/common/NavBar';
import PopBannerBox from '@components/MainPage/PopBannerBox';
import PopActiveBox from '@components/MainPage/PopActiveBox';
import PopConcertBox from '@components/MainPage/PopConcertBox';
import PopStreamBox from '@components/MainPage/PopStreamBox';

const MainPage = () => {
  return (
    <div>
      <Navbar />
      <br />
      <PopBannerBox></PopBannerBox>
      <br />
      <br />
      <br />
      <br />
      <PopActiveBox></PopActiveBox>
      <br />
      <br />
      <br />
      <br />
      <PopConcertBox></PopConcertBox>
      <br />
      <br />
      <br />
      <br />
      <PopStreamBox></PopStreamBox>
    </div>
  );
};

export default MainPage;
