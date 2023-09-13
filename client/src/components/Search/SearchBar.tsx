import { ReactComponent as SearchSvg } from '@assets/icons/search.svg';
import { ARTIST } from '@components/common/constant';
import styled from 'styled-components';

interface Props {
  nowStat: string;
}

const SearchBar: React.FC<Props> = ({ nowStat }) => {
  return (
    <BarFrame>
      {nowStat !== ARTIST && <CheckBox>아티스트로 검색하기</CheckBox>}
      <SearchFrame>
        <Input placeholder="검색어를 입력해주세요." />
        <SearchSvg />
      </SearchFrame>
    </BarFrame>
  );
};
const BarFrame = styled.div`
  text-align: right;
`;
const SearchFrame = styled.div`
  display: flex;
  align-items: center;
  gap: 12px;
`;
const CheckBox = styled.div`
  color: var(--main1-color);
  font-weight: 500;
  font-size: 14px;
  margin-bottom: 10px;
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
    color: var(--main1-color);
  }

  &:focus {
    outline: none !important;
  }
`;
export default SearchBar;
