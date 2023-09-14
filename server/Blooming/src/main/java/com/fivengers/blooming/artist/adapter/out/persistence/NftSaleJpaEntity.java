package com.fivengers.blooming.artist.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nft_sale")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NftSaleJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer issueCount;

    @Column(nullable = false)
    private Integer saleCount;

    @Column(nullable = false)
    private Long issuesAmount;

    @Column(nullable = false)
    private Long salesAmount;

    @Column(nullable = false)
    private Boolean deleted;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private ArtistJpaEntity artist;

    @Builder
    public NftSaleJpaEntity(Integer issueCount, Integer saleCount, Long issuesAmount,
            Long salesAmount,
            Boolean deleted, ArtistJpaEntity artist) {
        this.issueCount = issueCount;
        this.saleCount = saleCount;
        this.issuesAmount = issuesAmount;
        this.salesAmount = salesAmount;
        this.deleted = deleted;
        this.artist = artist;
    }
}
