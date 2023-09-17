package com.fivengers.blooming.project.domain;

import com.fivengers.blooming.artist.domain.Artist;
import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
public class Concert extends Project {

    @Builder
    public Concert(Long id,
                   String name,
                   Long fundingAmount,
                   LocalDateTime startedAt,
                   LocalDateTime endedAt,
                   String description,
                   Boolean deleted,
                   LocalDateTime createdAt,
                   LocalDateTime lastUpdated,
                   Artist artist) {
        super(id, name, fundingAmount, startedAt, endedAt, description, deleted, createdAt, lastUpdated, artist);
    }
}
