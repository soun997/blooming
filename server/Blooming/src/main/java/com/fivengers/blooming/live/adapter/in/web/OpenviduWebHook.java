package com.fivengers.blooming.live.adapter.in.web;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum OpenviduWebHook {
    PARTICIPANT_JOINED("participantJoined"),
    PARTICIPANT_LEFT("participantLeft");

    private final String event;

    public static OpenviduWebHook from(String event) {
        return Arrays.stream(OpenviduWebHook.values())
                .filter((webhook) -> webhook.getEvent().equals(event))
                .findAny()
                .orElseThrow();
    }

    OpenviduWebHook(String event) {
        this.event = event;
    }
}
