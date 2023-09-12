import styled from 'styled-components';
import { ArtistInfo } from '@type/Artist';
import { FirstBox, SecondBox } from './RankBox';

interface Props {
  nowBest: ArtistInfo[];
}

const dummyData: Props = {
  nowBest: [
    {
      name: '아이유 (IU)',
      desc: `대한민국의 가수이자 배우이다. 배우로 활동할 때도 예명을
                사용한다. '아이유(IU)'라는 예명은 'I'와 'You'를 합친 합성어로
                '너와 내가 음악으로 하나가 된다'라는 의미이다.`,
      profile_img: 'src/assets/images/iu-profile.jpg',
      startDate: '2023-09-01',
      endDate: '2023-10-12',
      nowNft: 124,
      totalNft: 300,
    },
    {
      name: '아이유 (IU)',
      desc: `대한민국의 가수이자 배우이다. 배우로 활동할 때도 예명을
                사용한다. '아이유(IU)'라는 예명은 'I'와 'You'를 합친 합성어로
                '너와 내가 음악으로 하나가 된다'라는 의미이다.`,
      profile_img: 'src/assets/images/ive.jpg',
      startDate: '2023-09-01',
      endDate: '2023-10-12',
      nowNft: 224,
      totalNft: 300,
    },
    {
      name: '아이유 (IU)',
      desc: `대한민국의 가수이자 배우이다. 배우로 활동할 때도 예명을
                사용한다. '아이유(IU)'라는 예명은 'I'와 'You'를 합친 합성어로
                '너와 내가 음악으로 하나가 된다'라는 의미이다.`,
      profile_img: 'src/assets/images/newjeans.jpg',
      startDate: '2023-09-01',
      endDate: '2023-10-12',
      nowNft: 124,
      totalNft: 200,
    },
  ],
};

const TopRankList = () => {
  return (
    <RankBox>
      <Subtitle>NOW BEST 🏆</Subtitle>
      <BoxFrame>
        <LeftFrame>
          <FirstBox data={dummyData.nowBest[0]} />
        </LeftFrame>
        <RightFrame>
          <SecondBox data={dummyData.nowBest[1]} />
          <SecondBox data={dummyData.nowBest[2]} />
        </RightFrame>
      </BoxFrame>
    </RankBox>
  );
};

const RankBox = styled.div`
  margin-top: 80px;
`;

const Subtitle = styled.div`
  font-size: 25px;
  font-weight: 700;
`;

const BoxFrame = styled.div`
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  margin-top: 40px;
`;

const LeftFrame = styled.div`
  display: flex;
  flex-direction: column;
  width: 48%;
`;

const RightFrame = styled.div`
  width: 50%;
  display: flex;
  flex-direction: column;
  gap: 20px;
`;

export default TopRankList;
