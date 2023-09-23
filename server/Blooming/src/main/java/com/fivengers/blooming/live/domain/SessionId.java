package com.fivengers.blooming.live.domain;

import com.fivengers.blooming.global.exception.live.InvalidSessionIdException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class SessionId {
    private static final String PREFIX = "blooming";
    private static final String VALIDATE_REGEX = "^" + PREFIX +"[0-9]+$";

    private String sessionId;

    public static void validate(String sessionId) {
        Pattern pattern = Pattern.compile(VALIDATE_REGEX);
        Matcher matcher = pattern.matcher(sessionId);
        if (!matcher.matches()) {
            throw new InvalidSessionIdException();
        }
    }
}
