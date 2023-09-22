import ArtistRegistModal from '@components/MyPage/ArtistRegistModal';
import React, { useState } from 'react';
import styled from 'styled-components';

const MyPage = () => {
  const [isModalOpen, setModalOpen] = useState(false);

  const openModal = () => {
    setModalOpen(true);
  };

  const closeModal = () => {
    setModalOpen(false);
  };

  return (
    <div>
      <button onClick={openModal}>아티스트 등록 신청</button>

      <ArtistRegistModal isOpen={isModalOpen} closeModal={closeModal} />
    </div>
  );
};

export default MyPage;
