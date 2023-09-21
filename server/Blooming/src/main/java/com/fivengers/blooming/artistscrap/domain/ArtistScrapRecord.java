package com.fivengers.blooming.artistscrap.domain;

import com.fivengers.blooming.artist.domain.Artist;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ArtistScrapRecord {

    private Long id;
    private Integer scrapCount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime startDateOnWeek;
    private LocalDateTime endDateOnWeek;
    private Artist artist;

    @Builder
    public ArtistScrapRecord(Long id,
                             Integer scrapCount,
                             LocalDateTime createdAt,
                             LocalDateTime modifiedAt,
                             LocalDateTime startDateOnWeek,
                             LocalDateTime endDateOnWeek,
                             Artist artist) {
        this.id = id;
        this.scrapCount = scrapCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.startDateOnWeek = startDateOnWeek;
        this.endDateOnWeek = endDateOnWeek;
        this.artist = artist;
    }
}
