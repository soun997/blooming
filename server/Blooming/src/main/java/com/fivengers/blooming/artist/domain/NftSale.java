package com.fivengers.blooming.artist.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class NftSale {

    private Long id;
    private Integer issueCount;
    private Integer saleCount;
    private Long issuesAmount;
    private Long salesAmount;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Boolean deleted;
    private Artist artist;

    @Builder
    public NftSale(Long id,
            Integer issueCount,
            Integer saleCount,
            Long issuesAmount,
            Long salesAmount,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt,
            Boolean deleted,
            Artist artist) {
        this.id = id;
        this.issueCount = issueCount;
        this.saleCount = saleCount;
        this.issuesAmount = issuesAmount;
        this.salesAmount = salesAmount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deleted = deleted;
        this.artist = artist;
    }
}
