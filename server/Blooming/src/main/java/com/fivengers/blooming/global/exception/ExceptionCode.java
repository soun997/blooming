package com.fivengers.blooming.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionCode {
    NFT_SALE_NOT_FOUND(HttpStatus.NOT_FOUND, "ERR_NFT_SALE_001", "NFT 판매 집계를 찾을 수 없습니다."),

    NFT_NOT_FOUND(HttpStatus.NOT_FOUND, "ERR_NFT_001", "NFT를 찾을 수 없습니다"),

    ARTIST_NOT_FOUND(HttpStatus.NOT_FOUND, "ERR_ARTIST_001", "아티스트를 찾을 수 없습니다."),

    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "ERR_MEMBER_001", "멤버를 찾을 수 없습니다."),

    ARTIST_SCRAP_NOT_FOUND(HttpStatus.NOT_FOUND, "ERR_ARTIST_SCRAP_001", "아티스트 관심을 찾을 수 없습니다."),

    ARTIST_SCRAP_RECORD_NOT_FOUND(HttpStatus.NOT_FOUND, "ERR_ARTIST_SCRAP_RECORD_001",
            "아티스트 관심 기록을 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;
}
