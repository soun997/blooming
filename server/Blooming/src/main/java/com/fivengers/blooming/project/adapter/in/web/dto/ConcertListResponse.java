package com.fivengers.blooming.project.adapter.in.web.dto;

import com.fivengers.blooming.project.domain.Concert;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record ConcertListResponse(Long id,
                                  String name,
                                  Long fundingAmount,
                                  Long targetAmount,
                                  LocalDateTime startedAt,
                                  LocalDateTime endedAt,
                                  String imageUrl) {

    public static ConcertListResponse from(Concert concert) {
        return ConcertListResponse.builder()
                .id(concert.getId())
                .name(concert.getName())
                .fundingAmount(concert.getFundingAmount())
                .targetAmount(concert.getTargetAmount())
                .startedAt(concert.getStartedAt())
                .endedAt(concert.getEndedAt())
                .build();
    }
}
