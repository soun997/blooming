package com.fivengers.blooming.membership.domain;

import com.fivengers.blooming.artist.domain.Artist;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MembershipApplication {
    private final Long id;
    private String title;
    private String description;
    private Integer season;
    private LocalDateTime seasonStart;
    private LocalDateTime seasonEnd;
    private LocalDateTime purchaseStart;
    private LocalDateTime purchaseEnd;
    private Long saleCount;
    private Long salePrice;
    private String imageUrl;
    private MembershipApplicationState applicationState;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Artist artist;

    @Builder
    public MembershipApplication(
            Long id,
            String title,
            String description,
            Integer season,
            LocalDateTime seasonStart,
            LocalDateTime seasonEnd,
            LocalDateTime purchaseStart,
            LocalDateTime purchaseEnd,
            Long saleCount,
            Long salePrice,
            String imageUrl,
            MembershipApplicationState applicationState,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt,
            Artist artist) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.season = season;
        this.seasonStart = seasonStart;
        this.seasonEnd = seasonEnd;
        this.purchaseStart = purchaseStart;
        this.purchaseEnd = purchaseEnd;
        this.saleCount = saleCount;
        this.salePrice = salePrice;
        this.imageUrl = imageUrl;
        this.applicationState = applicationState;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.artist = artist;
    }

    public void changeState(MembershipApplicationState applicationState) {
        this.applicationState = applicationState;
    }
}
