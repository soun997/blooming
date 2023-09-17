package com.fivengers.blooming.live.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class Live {

    private static String SESSION_PREFIX = "blooming";

    private Long id;
    private Artist artist;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime endedAt;

    public Live(
            Long id,
            Artist artist,
            String title,
            LocalDateTime createdAt,
            LocalDateTime endedAt) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.createdAt = createdAt;
        this.endedAt = endedAt;
    }

    public String getSessionId() {
        return SESSION_PREFIX + id;
    }
}
