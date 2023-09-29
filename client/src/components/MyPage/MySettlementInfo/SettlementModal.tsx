import React, { useState } from 'react';
import styled from 'styled-components';

import { FundingProcessApplication } from '@type/ApplicationList';

interface SettlementModalProps {
  funding: FundingProcessApplication;
  onClose: () => void;
}

const SettlementModal: React.FC<SettlementModalProps> = ({
  funding,
  onClose,
}) => {
  const [revenue, setRevenue] = useState<number>(0);

  // 정산 정보 입력 처리 함수
  const handleSettlementSubmit = () => {
    // revenue 상태를 이용하여 처리
    console.log(`정산 정보 입력 - 수익: ${revenue}`);
    onClose(); // 모달 닫기
  };

  return (
    <ModalOverlay>
      <ModalWrapper>
        <ModalHeader>
          <h2>정산 정보 입력</h2>
          <button onClick={onClose}>닫기</button>
        </ModalHeader>
        <ModalContent>
          <RevenueInput
            type="number"
            placeholder="수익을 입력하세요"
            value={revenue}
            onChange={(e) => setRevenue(Number(e.target.value))}
          />
          <SubmitButton onClick={handleSettlementSubmit}>입력</SubmitButton>
        </ModalContent>
      </ModalWrapper>
    </ModalOverlay>
  );
};

// 모달 스타일 컴포넌트
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

  /* 다른 스타일 속성들... */
`;

const ModalHeader = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px;

  h2 {
    margin: 0;
  }

  button {
    background: none;
    border: none;
    cursor: pointer;
    font-size: 16px;
    color: var(--main1-color);
    font-weight: 600;
  }
`;

const ModalContent = styled.div`
  padding: 16px;
`;

const RevenueInput = styled.input`
  width: 100%;
  padding: 8px;
  font-size: 16px;
  border: 1px solid var(--main3-color);
  border-radius: 4px;
`;

const SubmitButton = styled.button`
  width: 100%;
  margin-top: 16px;
  padding: 8px;
  background-color: var(--main1-color);
  color: var(--white-color);
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  font-weight: 600;
`;

export default SettlementModal;
