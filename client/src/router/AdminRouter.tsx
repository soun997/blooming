import React from 'react';
import { Navigate, Outlet } from 'react-router-dom';
import * as useAuth from '@hooks/useAuth';
import { ACCESS_KEY } from '@components/common/constant';

export default function AdminRoute() {
  // admin 인증
  const isAdmin = useAuth.getCookie(ACCESS_KEY);
  //console.log(isLogin);
  if (isAdmin) {
    // 인증이 반드시 필요한 페이지
    return <Outlet />;
  }
  alert('접근 권한이 없습니다');
  // 관리자 아닌 유저가 이동할 곳
  return <Navigate replace to="/" />;
}
