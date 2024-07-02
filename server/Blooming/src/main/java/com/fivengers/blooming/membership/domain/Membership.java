package com.fivengers.blooming.membership.domain;

import com.fivengers.blooming.artist.domain.Artist;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Membership {

    private final Long id;
    private String title;
    private String symbol;
    private String description;
    private Integer season;
    private LocalDateTime seasonStart;
    private LocalDateTime seasonEnd;
    private LocalDateTime purchaseStart;
    private LocalDateTime purchaseEnd;
    private Long saleCount;
    private Long salePrice;
    private String imageUrl;
    private String contractAddress;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Artist artist;
    private NftSale nftSale;

    @Builder
    public Membership(Long id,
            String title,
            String symbol,
            String description,
            Integer season,
            LocalDateTime seasonStart,
            LocalDateTime seasonEnd,
            LocalDateTime purchaseStart,
            LocalDateTime purchaseEnd,
            Long saleCount,
            Long salePrice,
            String imageUrl,
            String contractAddress,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt,
            Artist artist,
            NftSale nftSale) {
        this.id = id;
        this.title = title;
        this.symbol = symbol;
        this.description = description;
        this.season = season;
        this.seasonStart = seasonStart;
        this.seasonEnd = seasonEnd;
        this.purchaseStart = purchaseStart;
        this.purchaseEnd = purchaseEnd;
        this.saleCount = saleCount;
        this.salePrice = salePrice;
        this.imageUrl = imageUrl;
        this.contractAddress = contractAddress;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.artist = artist;
        this.nftSale = nftSale;
    }

    public void update(String title,
            String description,
            LocalDateTime seasonStart,
            LocalDateTime seasonEnd,
            LocalDateTime purchaseStart,
            LocalDateTime purchaseEnd,
            String thumbnailUrl) {
        this.title = title;
        this.description = description;
        this.seasonStart = seasonStart;
        this.seasonEnd = seasonEnd;
        this.purchaseStart = purchaseStart;
        this.purchaseEnd = purchaseEnd;
        this.imageUrl = thumbnailUrl;
    }

    public boolean isOwner(Long memberId) {
        return this.artist.getMember().getId().equals(memberId);
    }
}
