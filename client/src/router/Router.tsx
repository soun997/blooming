import { BrowserRouter, Route, Routes } from 'react-router-dom';

import ActiveDetail from '@pages/ActiveDetail';
import MainPage from '@pages/MainPage';
import NFTList from '@pages/ListPage/NFTList';
import ConcertList from '@pages/ListPage/ConcertList';
import ActiveList from '@pages/ListPage/ActiveList';
import AddFund from '@pages/AddFund';
import ArtistDetail from '@pages/DetailPage/ArtistDetail';
import MeetingPage from '@pages/MeetingPage/MeetingPage';

export default function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainPage />}></Route>
        <Route path="/nft" element={<NFTList />}></Route>
        <Route path="/concert" element={<ConcertList />}></Route>
        <Route path="/active" element={<ActiveList />}></Route>
        <Route path="/add-fund" element={<AddFund />}></Route>
        <Route path="/active-detail" element={<ActiveDetail />}></Route>
        <Route path="/artist-detail" element={<ArtistDetail />}></Route>
        <Route
          path="/meeting-artist"
          element={<MeetingPage isArtist={true} />}
        ></Route>
        <Route
          path="/meeting"
          element={<MeetingPage isArtist={false} />}
        ></Route>
      </Routes>
    </BrowserRouter>
  );
}
