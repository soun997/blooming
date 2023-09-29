package com.fivengers.blooming.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fivengers.blooming.global.exception.ExceptionCode;
import com.fivengers.blooming.global.response.ApiResponse;
import com.fivengers.blooming.global.response.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

@RequiredArgsConstructor
public class DefaultAccessDeniedHandler extends AccessDeniedHandlerImpl {

    public static final String NOT_FOUND_SERVLET_MSG = "해당 접근은 유효하지 않습니다.";

    private final HttpRequestEndpointChecker endpointChecker;
    private final ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {

        if (!endpointChecker.existsEndpoint(request)) {
            responseException(response, ExceptionCode.UNREGISTERED_EXCEPTION, NOT_FOUND_SERVLET_MSG);
            return;
        }

        super.handle(request, response, accessDeniedException);
    }

    private void responseException(HttpServletResponse response, ExceptionCode exceptionCode,
            String message) throws IOException {
        response.setStatus(exceptionCode.getHttpStatus().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        PrintWriter writer = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        writer.write(objectMapper.writeValueAsString(
                ApiResponse.status(exceptionCode.getHttpStatus())
                        .body(new ErrorResponse(exceptionCode.getErrorCode(), message))));
        writer.flush();
    }
}
