package com.fivengers.blooming.live.adapter.in.web;

import lombok.Getter;

@Getter
public enum OpenviduWebhook {
    PARTICIPANT_JOINED("participantJoined"),
    PARTICIPANT_LEFT("participantLeft");

    private final String event;

    OpenviduWebhook(String event) {
        this.event = event;
    }
}
