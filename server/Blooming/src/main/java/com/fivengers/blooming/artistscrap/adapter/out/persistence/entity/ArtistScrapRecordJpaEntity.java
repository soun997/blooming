package com.fivengers.blooming.artistscrap.adapter.out.persistence.entity;

import com.fivengers.blooming.global.audit.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "artist_scrap_record")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArtistScrapRecordJpaEntity extends BaseTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_scrap_record_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Integer scrapCount;

    @Column(nullable = false)
    private LocalDateTime startDateOnWeek;

    @Column(nullable = false)
    private LocalDateTime endDateOnWeek;

    @Column(nullable = false)
    private Boolean deleted;

    @Builder
    public ArtistScrapRecordJpaEntity(Long id,
                                      Integer scrapCount,
                                      LocalDateTime startDateOnWeek,
                                      LocalDateTime endDateOnWeek,
                                      Boolean deleted) {
        this.id = id;
        this.scrapCount = scrapCount;
        this.startDateOnWeek = startDateOnWeek;
        this.endDateOnWeek = endDateOnWeek;
        this.deleted = deleted;
    }
}
