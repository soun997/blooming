package com.fivengers.blooming.artist.adapter.out.persistence.entity;

import com.fivengers.blooming.global.audit.BaseTime;
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
public class NftSaleJpaEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer totalNftCount;

    @Column(nullable = false)
    private Integer soldNftCount;

    @Column(nullable = false)
    private Long totalNftAmount;

    @Column(nullable = false)
    private Long soldNftAmount;

    @Column(nullable = false)
    private Boolean deleted;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private ArtistJpaEntity artist;

    @Builder
    public NftSaleJpaEntity(Integer totalNftCount, Integer soldNftCount, Long totalNftAmount,
            Long soldNftAmount,
            Boolean deleted, ArtistJpaEntity artist) {
        this.totalNftCount = totalNftCount;
        this.soldNftCount = soldNftCount;
        this.totalNftAmount = totalNftAmount;
        this.soldNftAmount = soldNftAmount;
        this.deleted = deleted;
        this.artist = artist;
    }
}
