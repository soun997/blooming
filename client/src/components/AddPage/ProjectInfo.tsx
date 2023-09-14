import { ACTIVE, CONCERT, FUNDING_CAGEGORY } from '@components/common/constant';
import { MainTitle } from '@style/common';
import { FundAddInfo, ProjectInfoInAdd } from '@type/ProcessInfo';
import { useEffect, useState } from 'react';
import styled from 'styled-components';
import { FormForText } from './FormComponent';
import { validCompanyRegistrationNumber } from '@utils/validation/AddProjectInfoValid';

interface Props {
  data: ProjectInfoInAdd;
  setData: React.Dispatch<React.SetStateAction<FundAddInfo>>;
}

export interface ValidCheck {
  validIdx: number;
  validValue: string;
  isValid: boolean;
}

const updateProjectInfo = (
  prevInfo: FundAddInfo,
  projectInfo: ProjectInfoInAdd,
) => {
  return {
    ...prevInfo,
    projectInfo: projectInfo,
  };
};

const ProjectInfo = ({ data, setData }: Props) => {
  const [categoryIdx, setCategoryIdx] = useState(0);
  const [projectInfo, setProjectInfo] = useState<ProjectInfoInAdd>(data);
  const [validInputCheck, setValidInputCheck] = useState<ValidCheck>({
    validIdx: 0,
    validValue: '',
    isValid: false,
  });

  useEffect(() => {
    if (data) {
      setCategoryIdx(projectInfo.category === CONCERT ? 0 : 1);
    }
  }, []);

  useEffect(() => {
    switch (validInputCheck.validIdx) {
      case 0:
        //사업자 등록 번호
        projectInfo.makerInfo.makerNum = validInputCheck.validValue;
        setData((prevInfo) => updateProjectInfo(prevInfo, projectInfo));
        break;

      default:
        break;
    }
  }, [validInputCheck]);

  const handleCategoryChange = () => {
    setCategoryIdx(Math.abs(1 - categoryIdx));
    categoryIdx === 1
      ? (projectInfo.category = CONCERT)
      : (projectInfo.category = ACTIVE);
    setData((prevInfo) => updateProjectInfo(prevInfo, projectInfo));
  };

  return (
    <div>
      <Title>
        프로젝트 정보 <div className="dot"></div>
      </Title>

      <QuestionFrame>
        <Subtitle>무엇을 위한 펀딩인가요?</Subtitle>
        <Contents>
          <div className="rows">
            <Chip active={categoryIdx === 0} onClick={handleCategoryChange}>
              {FUNDING_CAGEGORY[0]}
            </Chip>
            <Chip active={categoryIdx === 1} onClick={handleCategoryChange}>
              {FUNDING_CAGEGORY[1]}
            </Chip>
          </div>
        </Contents>
      </QuestionFrame>
      <QuestionFrame>
        <Subtitle>사업자 인증이 필요해요!</Subtitle>
        <Contents>
          <FormForText
            title="사업자 등록 번호 (10자리)"
            placeholder="사업자 등록 번호를 입력해주세요"
            validIdx={0}
            setValid={setValidInputCheck}
            errorCheck={validCompanyRegistrationNumber}
          ></FormForText>
          <FormForText
            title="상호 법인명"
            placeholder="상호 또는 법인명을 입력해주세요"
            validIdx={0}
            setValid={setValidInputCheck}
            errorCheck={validCompanyRegistrationNumber}
          ></FormForText>
        </Contents>
      </QuestionFrame>
    </div>
  );
};

const Title = styled(MainTitle)`
  font-size: 25px;
  display: flex;
  margin-bottom: 30px;
`;

const QuestionFrame = styled.div`
  margin-bottom: 60px;
`;

const Subtitle = styled.div`
  font-weight: 700;
  font-size: 18px;
  display: flex;
  align-items: center;
  margin-bottom: 30px;

  span {
    margin-top: 3px;
    margin-left: 5px;
    color: var(--error-color);
    font-size: 18px;
  }
`;
const Contents = styled.div`
  display: flex;
  flex-direction: column;
  gap: 30px;
  margin-top: 20px;

  .rows {
    display: flex;
    align-items: center;
    gap: 20px;
  }
`;

interface styleProps {
  active?: boolean;
}

const Chip = styled.div<styleProps>`
  cursor: pointer;
  width: fit-content;
  height: fit-content;
  padding: 10px 20px;
  background-color: ${(props) =>
    props.active ? 'var(--main1-color)' : 'var(--gray-color)'};
  color: var(--white-color);
  font-size: 14px;
  font-weight: 400;
  border-radius: 6px;

  &:hover {
    background-color: var(--main1-color);
  }
`;

export default ProjectInfo;
