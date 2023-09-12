import { BrowserRouter, Route, Routes } from 'react-router-dom';
import MainPage from '@pages/MainPage';
import ArtistList from '@pages/ListPage/ArtistList';

export default function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainPage />}></Route>
        <Route path="/artist" element={<ArtistList />}></Route>
      </Routes>
    </BrowserRouter>
  );
}
