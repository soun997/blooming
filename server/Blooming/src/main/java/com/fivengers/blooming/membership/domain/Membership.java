package com.fivengers.blooming.membership.domain;

import com.fivengers.blooming.artist.domain.Artist;
import com.fivengers.blooming.nft.domain.Nft;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Membership {

    private Long id;
    private String description;
    private Integer season;
    private LocalDateTime seasonStart;
    private LocalDateTime seasonEnd;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Nft nft;
    private Artist artist;

    @Builder
    public Membership(Long id,
            String description,
            Integer season,
            LocalDateTime seasonStart,
            LocalDateTime seasonEnd,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt,
            Nft nft,
            Artist artist) {
        this.id = id;
        this.description = description;
        this.season = season;
        this.seasonStart = seasonStart;
        this.seasonEnd = seasonEnd;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.nft = nft;
        this.artist = artist;
    }
}
