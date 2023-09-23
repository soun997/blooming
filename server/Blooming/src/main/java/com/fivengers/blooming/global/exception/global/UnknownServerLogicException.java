package com.fivengers.blooming.global.exception.global;

// 서버 내부의 알수 없는 로직 에러
public class UnknownServerLogicException extends RuntimeException {

    public UnknownServerLogicException() {
        super("알 수 없는 로직 에러가 발생하였습니다.");
    }

    public UnknownServerLogicException(String errorMessage) {
        super(errorMessage);
    }

}
