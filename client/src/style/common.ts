import styled, { css, keyframes } from 'styled-components';

export const MainTitle = styled.div`
  font-size: 42px;
  font-weight: 700;
  display: flex;
  align-items: flex-end;
  gap: 10px;
  .dot {
    width: 9px;
    height: 9px;
    border-radius: 50%;
    background-color: var(--main1-color);
  }
`;

export const ProgressBar = styled.div`
  margin-top: 15px;
  width: 100%;
  background: var(--gray-color);
  border-radius: 6px;
`;

interface ProgressProps {
  total: number;
  score: number;
}

export const Progress = styled.div<ProgressProps>`
  padding: 1px;
  border-radius: 30px;
  width: ${(props) => (props.score / props.total) * 100}%;
  background-color: var(--main1-color);
  ${({ score, total }) => css`
    animation: ${progressAnimation(score, total)} 2s;
  `};
`;

export const progressAnimation = (score: number, total: number) => keyframes`
  0% {
    width: 5%;
    background-color: var(--main1-color);
  }
  100% {
    width: ${(score / total) * 100}%;
    background-color: var(--main1-color);
  }
`;

export const Bar = styled.div`
  height: 9px;
  border-radius: 30px;
  background-color: var(--main1-color);
  transition: 0.4s linear;
  transition-property: width, background-color;
`;
