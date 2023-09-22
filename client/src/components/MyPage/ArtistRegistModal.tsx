import styled from 'styled-components';

const ArtistRegistModal = ({
  isOpen,
  closeModal,
}: {
  isOpen: boolean;
  closeModal: () => void;
}) => {
  if (!isOpen) return null;

  return (
    <ModalOverlay>
      <ModalWrapper>
        <ModalHeader>
          <h2>아티스트 등록 신청</h2>
          <button onClick={closeModal}>닫기</button>
        </ModalHeader>
        <ModalContent>
          {/* 모달 내용을 입력하세요 */}
          {/* 아티스트 등록 신청 양식, 텍스트 등을 여기에 추가합니다 */}
        </ModalContent>
      </ModalWrapper>
    </ModalOverlay>
  );
};

const ModalOverlay = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 999;
`;

const ModalWrapper = styled.div`
  background: white;
  border-radius: 4px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
  max-width: 400px;
  width: 100%;
`;

const ModalHeader = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #ccc;
  padding: 10px 20px;

  h2 {
    margin: 0;
  }

  button {
    background: none;
    border: none;
    cursor: pointer;
    font-size: 16px;
    color: #333;
  }
`;

const ModalContent = styled.div`
  padding: 20px;
`;

export default ArtistRegistModal;
