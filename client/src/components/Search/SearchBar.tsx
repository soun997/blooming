import React from 'react';
import { ReactComponent as SearchSvg } from '../../assets/icons/search.svg';
import styled from 'styled-components';
const SearchBar = () => {
  return (
    <BarFrame>
      <Input placeholder="검색어를 입력해주세요." />
      <SearchSvg />
    </BarFrame>
  );
};
const BarFrame = styled.div`
  display: flex;
  align-items: center;
  gap: 12px;
`;

const Input = styled.input`
  border: none;
  display: flex;
  padding: 12px 16px;
  width: 300px;
  align-items: center;
  gap: 4px;
  flex: 1 0 0;
  align-self: stretch;
  border-radius: 8px;
  background: rgba(168, 190, 225, 0.22);

  &::placeholder {
    font-size: 14px;
    font-weight: 500;
    line-height: 130%;
    letter-spacing: -0.014px;
    color: var(--main4-color);
  }

  &:focus {
    outline: none !important;
  }
`;
export default SearchBar;
