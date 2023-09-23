package com.fivengers.blooming.live.domain;

import static org.assertj.core.api.Assertions.*;

import com.fivengers.blooming.global.exception.live.InvalidSessionIdException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SessionIdTest {

    @DisplayName("유효한 세션 ID에서 Exception이 발생하지 않는다.")
    @ParameterizedTest(name = "{index}) sessionId = {0}")
    @ValueSource(strings = {"blooming1", "blooming2", "blooming100"})
    public void 유효한_세션_ID에서_Exception이_발생하지_않는다(String sessionId) {
        assertThatNoException().isThrownBy(() -> SessionId.validate(sessionId));
    }

    @DisplayName("잘못된 세션 ID에서 InvalidSessionIdException이 발생한다.")
    @ParameterizedTest(name = "{index}) sessionId = {0}")
    @ValueSource(strings = {"", " ", "abc", "blooming", "abcblooming", "bloomingabc", "bloomingasd1", "blooming2sf", "blooming3 "})
    public void 잘못된_세션_ID에서_InvalidSessionIdException이_발생한다(String sessionId) {
        assertThatThrownBy(() -> SessionId.validate(sessionId))
                .isInstanceOf(InvalidSessionIdException.class);
    }

}