import { useState } from 'react';
import styled from 'styled-components';
import DefaultInfo from '@components/AddPage/DefaultInfo';
import Policy from '@components/AddPage/Policy';
import ProjectInfo from '@components/AddPage/ProjectInfo';
import RepresentInfo from '@components/AddPage/RepresentInfo';
import Reward from '@components/AddPage/Reward';
import StoryWrite from '@components/AddPage/StoryWrite';
import { ReactComponent as LogoutSvg } from '@assets/icons/logout.svg';

const subtitleData = [
  '프로젝트 정보',
  '기본 정보',
  '스토리 작성',
  '리워드 설계',
  '정책',
  '대표자 및 정산 정보',
];

const components = [
  <ProjectInfo />,
  <DefaultInfo />,
  <StoryWrite />,
  <Reward />,
  <Policy />,
  <RepresentInfo />,
];

const AddFund = () => {
  const [activeIndex, setActiveIndex] = useState<number>(0);

  const handleSubtitleClick = (index: number) => {
    setActiveIndex(index);
  };

  return (
    <BackgroundGrad>
      <AddFrame>
        <TopInfoFrame>
          <Title>내 펀딩 등록</Title>
          <AddButton>등록하기</AddButton>
        </TopInfoFrame>
        <ContextFrame>
          <LeftContext>
            {subtitleData.map((subtitle, index) => (
              <Subtitle
                key={index}
                onClick={() => handleSubtitleClick(index)}
                active={index === activeIndex}
              >
                {subtitle}
              </Subtitle>
            ))}
            <Exit>
              나가기 <LogoutSvg />
            </Exit>
          </LeftContext>
          <RightContext>{components[activeIndex]}</RightContext>
        </ContextFrame>
      </AddFrame>
    </BackgroundGrad>
  );
};

const BackgroundGrad = styled.div`
  background-image: url('src/assets/images/AddBackground.jpg');
  /* background-image: url(https://images.unsplash.com/photo-1640963269654-3fe248c5fba6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1932&q=80); */
  /* background: linear-gradient(180deg, #35ebdf 0%, #ba8ffb 100%); */
  background-repeat: no-repeat;
  background-size: cover;
  margin: 0 -280px -100px;
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const AddFrame = styled.div`
  background-color: rgb(255 255 255 / 40%);
  max-width: 1400px;
  max-height: 860px;
  height: 90vh;
  display: flex;
  flex-direction: column;
  overflow: hidden;
  position: relative;
  width: 100%;
  border-radius: 14px;
  backdrop-filter: blur(20px);
  -webkit-backdrop-filter: blur(20px);
  font-size: 15px;
  font-weight: 500;
`;

const Title = styled.div`
  padding: 30px 0 20px 40px;
  font-size: 20px;
  font-weight: 700;
  color: var(--main4-color);
`;

const ContextFrame = styled.div`
  display: flex;
`;
const LeftContext = styled.div`
  background-color: #ffffff69;
  width: 20%;
  height: 100vh;
  padding: 50px 0 0 40px;
  display: flex;
  flex-direction: column;
  gap: 35px;
`;

interface Props {
  active: boolean;
}

const Subtitle = styled.div<Props>`
  color: ${(props) =>
    props.active ? 'var(--main1-color)' : 'var(--black-color)'};
  font-size: 16px;
  font-weight: ${(props) => (props.active ? '700' : '600')};
  margin-bottom: 10px;
  cursor: pointer;

  &:hover {
    color: var(--main1-color);
  }
`;

const RightContext = styled.div`
  height: 100vh;
  width: 80%;
  overflow-x: hidden;
  overflow-y: scroll;
`;
const Exit = styled.div`
  display: flex;
  align-items: center;
  gap: 6px;
  margin-top: 60px;
  color: var(--error-color);
  font-size: 14px;
  font-weight: 700;
  cursor: pointer;
`;

const TopInfoFrame = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;

  border-bottom: 0.1px solid var(--white-color);
`;

const AddButton = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 10px 30px;
  background-color: var(--white-color);
  color: var(--main1-color);
  font-weight: 700;
  margin-right: 30px;
  border-radius: 6px;
  cursor: pointer;
`;

export default AddFund;

/*
  scroll 바 custom

  /* 
  &::-webkit-scrollbar {
    width: 14px;
    height: 100vh;
  }
  &::-webkit-scrollbar-thumb {
    border-radius: 2px;
    height: 100dvh;
    background-color: #131212;
  } 
*/
