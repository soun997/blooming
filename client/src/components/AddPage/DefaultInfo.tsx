import { MainTitle } from '@style/common';
import { DefaultInfoInAdd, FundAddInfo } from '@type/ProcessInfo';
import { useEffect, useState } from 'react';
import styled from 'styled-components';
import { FormForText, FormForUpload } from './FormComponent';
import { validFundingTitleCheck } from '@utils/validation/AddDefaultInfoValid';

interface Props {
  data: DefaultInfoInAdd;
  setData: React.Dispatch<React.SetStateAction<FundAddInfo>>;
}

export interface ValidCheck {
  validIdx: number;
  validValue: string;
  isValid: boolean;
}

const updatedefaultInfo = (
  prevInfo: FundAddInfo,
  defaultInfo: DefaultInfoInAdd,
) => {
  return {
    ...prevInfo,
    defaultInfo: defaultInfo,
  };
};

const DefaultInfo = ({ data, setData }: Props) => {
  const [defaultInfo, setDefaultInfo] = useState<DefaultInfoInAdd>(data);
  const [validInputCheck, setValidInputCheck] = useState<ValidCheck>({
    validIdx: 0,
    validValue: '',
    isValid: false,
  });

  useEffect(() => {
    if (validInputCheck.isValid) {
      switch (validInputCheck.validIdx) {
        case 0:
          // 대표 이미지 등록
          defaultInfo.image = validInputCheck.validValue;
          setData((prevInfo) => updatedefaultInfo(prevInfo, defaultInfo));
          break;
        case 1:
          // 프로젝트 타이틀
          defaultInfo.title = validInputCheck.validValue;
          setData((prevInfo) => updatedefaultInfo(prevInfo, defaultInfo));
          break;
        case 2:
          // 프로젝트 시작일, 종료일
          const startDate = validInputCheck.validValue.split(',')[0];
          const endDate = validInputCheck.validValue.split(',')[1];
          defaultInfo.startDate = startDate;
          defaultInfo.endDate = endDate;
          setData((prevInfo) => updatedefaultInfo(prevInfo, defaultInfo));
          break;
        default:
          break;
      }
    }
  }, [validInputCheck]);

  return (
    <div>
      <Title>
        기본 정보 <div className="dot"></div>
      </Title>

      <QuestionFrame>
        <Subtitle>펀딩 대표 이미지를 등록해주세요!</Subtitle>
        <Contents>
          <FormForUpload
            title="대표 이미지는 상단에 노출됩니다"
            subInfo={[
              'JPG, JPEG, PNG, PDF / 10MB 이하 파일 1개만 업로드 가능해요.',
            ]}
            setValid={setValidInputCheck}
            validIdx={0}
          />
        </Contents>
      </QuestionFrame>
      <QuestionFrame>
        <Subtitle>펀딩 타이틀을 입력해주세요!</Subtitle>
        <Contents>
          <FormForText
            title="최대 30글자만 가능합니다"
            placeholder="펀딩 타이틀을 입력해주세요."
            validIdx={1}
            setValid={setValidInputCheck}
            errorCheck={validFundingTitleCheck}
            initKeyword={defaultInfo.title}
          />
        </Contents>
      </QuestionFrame>
      <QuestionFrame>
        <Subtitle>펀딩 시작일과 종료일을 알려주세요</Subtitle>
        <Contents>
          <FormForText
            title="최대 30글자만 가능합니다"
            placeholder="펀딩 타이틀을 입력해주세요."
            validIdx={1}
            setValid={setValidInputCheck}
            errorCheck={validFundingTitleCheck}
            initKeyword={defaultInfo.title}
          />
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

export default DefaultInfo;
