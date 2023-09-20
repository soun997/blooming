import { BrowserRouter, Route, Routes } from 'react-router-dom';

import ActiveDetail from '@pages/ActiveDetail';
import MainPage from '@pages/MainPage';
import NFTList from '@pages/ListPage/NFTList';
import ConcertList from '@pages/ListPage/ConcertList';
import ActiveList from '@pages/ListPage/ActiveList';
import AddFund from '@pages/AddFund';

export default function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainPage />}></Route>
        <Route path="/activedetail" element={<ActiveDetail />}></Route>
        <Route path="/nft" element={<NFTList />}></Route>
        <Route path="/concert" element={<ConcertList />}></Route>
        <Route path="/active" element={<ActiveList />}></Route>
        <Route path="/add-fund" element={<AddFund />}></Route>
      </Routes>
    </BrowserRouter>
  );
}
