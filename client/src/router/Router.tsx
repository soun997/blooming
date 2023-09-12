import { BrowserRouter, Route, Routes } from 'react-router-dom';
import MainPage from '../pages/MainPage';
import ArtistPage from '../pages/ListPage/ArtistPage';

export default function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<MainPage />}></Route>
        <Route path="/artist" element={<ArtistPage />}></Route>
      </Routes>
    </BrowserRouter>
  );
}
