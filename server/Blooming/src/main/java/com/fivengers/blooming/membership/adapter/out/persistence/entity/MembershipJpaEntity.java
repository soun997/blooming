package com.fivengers.blooming.membership.adapter.out.persistence.entity;

import com.fivengers.blooming.artist.adapter.out.persistence.entity.ArtistJpaEntity;
import com.fivengers.blooming.global.audit.BaseTime;
import com.fivengers.blooming.nft.adapter.out.persistence.entity.NftJpaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membership")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MembershipJpaEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer season;

    @Column(nullable = false)
    private LocalDateTime seasonStart;

    @Column(nullable = false)
    private LocalDateTime seasonEnd;

    @Column(nullable = false)
    private LocalDateTime purchaseDeadline;

    @Column(nullable = false)
    private Integer saleCount;

    @Column(nullable = false)
    private Boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nft_id")
    private NftJpaEntity nft;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private ArtistJpaEntity artistJpaEntity;

    @Builder
    public MembershipJpaEntity(
            Long id,
            String description,
            Integer season,
            LocalDateTime seasonStart,
            LocalDateTime seasonEnd,
            LocalDateTime purchaseDeadline,
            Integer saleCount,
            Boolean deleted,
            NftJpaEntity nft,
            ArtistJpaEntity artistJpaEntity) {
        this.id = id;
        this.description = description;
        this.season = season;
        this.seasonStart = seasonStart;
        this.seasonEnd = seasonEnd;
        this.purchaseDeadline = purchaseDeadline;
        this.saleCount = saleCount;
        this.deleted = deleted;
        this.nft = nft;
        this.artistJpaEntity = artistJpaEntity;
    }
}
