import { ArtistRequestInfo } from './ArtistRequest';

export interface MembershipAdmit {
  id: number;
  title: string;
  seasonStart: string;
  seasonEnd: string;
  purchaseStart: string;
  purchaseEnd: string;
  thumbnailUrl: string;
  applicationState: string;
  createdAt: string;
  modifiedAt: string;
  artist: ArtistRequestInfo;
}
