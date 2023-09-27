import { NFTProcessApplication } from '@type/ApplicationList';
import React from 'react';

interface Props {
  data: NFTProcessApplication[];
}

const MembershipList = ({ data }: Props) => {
  return (
    <div>
      {/* //!status 에 따른 탭 구분 */}
      {data.map((nft) => (
        <div>{nft.membershipId}</div>
      ))}
    </div>
  );
};

export default MembershipList;
