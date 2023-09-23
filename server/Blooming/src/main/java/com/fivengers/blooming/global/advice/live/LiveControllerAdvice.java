package com.fivengers.blooming.global.advice.live;

import com.fivengers.blooming.global.exception.live.SessionNotFoundException;
import com.fivengers.blooming.global.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class LiveControllerAdvice {

    @ExceptionHandler(SessionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<String> sessionNotFound(SessionNotFoundException exception) {
        log.info("[EXCEPTION] {} : {}",
                exception.getExceptionCode().getErrorCode(),
                exception.getExceptionCode().getMessage());

        return ApiResponse.notFound(exception.getExceptionCode().getMessage());
    }

}
