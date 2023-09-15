import React from 'react';
import styled from 'styled-components';
import { ReactComponent as LikeIcon } from '../../assets/icons/LikeIcon.svg';
import { ReactComponent as LiveIcon } from '../../assets/icons/LiveIcon.svg';
import { Swiper, SwiperSlide } from 'swiper/react';

import { Navigation, Pagination } from 'swiper/modules';

const ArtistDetailInfo = () => {
  return (
    <>
      <LiveInfoBox>
        <LiveIcon></LiveIcon>
        <div className="live_info">현재 LIVE 중입니다</div>
      </LiveInfoBox>
      {/*  그리드 구조 시작 */}
      <ArtistInfoBox>
        <ImgBox>
          <img
            className="profile_img"
            src="src/assets/images/IU_profile_Img.png"
          ></img>
        </ImgBox>
        <ArtistInfo>
          <TextBox>
            <ArtistName>
              <div className="artist_name">아이유</div>
              <LikeBtn>
                <LikeIcon className="likeIcon"></LikeIcon>
                <div>관심 아티스트 등록</div>
              </LikeBtn>
            </ArtistName>
            <div className="artist_desc">
              아이유는 대한민국의 가수이다. 2008년 EP [Lost And Found]로
              데뷔하여 활동을 시작한 그는 이후 '마쉬멜로우', 임슬옹과 호흡을
              맞춘 '잔소리' 등으로 인기를 얻기 시작했고, 2010년에 발표한 세 번째
              EP [Real]의 타이틀곡 '좋은날'이 종전의 히트를 기록하며 하나의
              신드롬을 형성하기도 했다.
            </div>
          </TextBox>

          <ActiveListBox>
            <div className="recent_actions">최근 활동 내역</div>
            <AlbumListBox>
              <img
                src="src/assets/images/sub_album_img1.png"
                alt="서브 앨범 이미지 1"
                className="album_list_img"
              />
              <img
                src="src/assets/images/sub_album_img2.png"
                alt="서브 앨범 이미지 2"
                className="album_list_img"
              />
              <img
                src="src/assets/images/sub_album_img3.png"
                alt="서브 앨범 이미지 3"
                className="album_list_img"
              />
              <img
                src="src/assets/images/sub_album_img4.png"
                alt="서브 앨범 이미지 4"
                className="album_list_img"
              />
              <img
                src="src/assets/images/sub_album_img2.png"
                alt="서브 앨범 이미지 2"
                className="album_list_img"
              />
            </AlbumListBox>
          </ActiveListBox>
        </ArtistInfo>
      </ArtistInfoBox>
    </>
  );
};

const AlbumListBox = styled.div`
  /* display: -webkit-inline-box; */
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  overflow: hidden;
  justify-content: space-around;
  /* align-items: center; */
  width: 100%;

  .album_list_img {
    /* display: flex;
    justify-content: center; */
    /* flex-direction: row; */
    /* width: 100%; */
    /* height: 100%; */
    /* object-fit: cover; */
    padding: 10px;
  }
`;

const ActiveListBox = styled.div`
  .recent_actions {
    color: var(--Black, var(--black-color, #000));

    font-size: 20px;

    font-weight: 700;
    line-height: 25px;
    margin-bottom: 13px;
  }
`;

const LikeBtn = styled.button`
  color: #3061b9;
  font-size: 14px;
  font-weight: 700;
  line-height: 25px;

  display: flex;
  flex-direction: row;

  cursor: pointer;
  border: none;
  background: none;

  .likeIcon {
    margin-right: 4px;
    align-self: center;
  }
`;

const ArtistName = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

const TextBox = styled.div`
  display: flex;
  flex-direction: column;

  .artist_name {
    align-self: center;
    font-size: 30px;
    font-weight: 700;
    line-height: normal;
  }
  .artist_desc {
    font-size: 14px;
    font-weight: 500;
    line-height: 25px;
    margin-top: 10px;
    margin-left: 2px;
  }
`;

const ImgBox = styled.div`
  width: 252px;
  height: 252px;
  border-radius: 500px;
  align-self: center;

  .profile_img {
    /* width: 100%; */
    /* height: 100%; */
    /* object-fit: cover; */
    /* border: solid 10px linear-gradient(to bottom, #a8bee1, #ebf7f2); */
    /* margin-right: 54px; */
  }
`;

const ArtistInfo = styled.div`
  display: flex;
  flex-direction: column;
  gap: 35px;
`;
const ArtistInfoBox = styled.div`
  display: flex;
  gap: 35px;
`;
const LiveInfoBox = styled.div`
  display: flex;
  margin-left: 50px;

  .live_info {
    color: var(--Main, #3061b9);
    font-size: 16px;
    font-style: normal;
    font-weight: 800;
    line-height: 25px;

    margin-left: 7px;
  }
`;

export default ArtistDetailInfo;
