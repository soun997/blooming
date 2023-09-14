package com.fivengers.blooming.artist.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NftSale {

    private Long id;
    private Integer issueCount;
    private Integer saleCount;
    private Long issuesAmount;
    private Long salesAmount;
    private Boolean deleted;
    private Artist artist;

    @Builder
    public NftSale(Long id,
            Integer issueCount,
            Integer saleCount,
            Long issuesAmount,
            Long salesAmount,
            Boolean deleted,
            Artist artist) {
        this.id = id;
        this.issueCount = issueCount;
        this.saleCount = saleCount;
        this.issuesAmount = issuesAmount;
        this.salesAmount = salesAmount;
        this.deleted = deleted;
        this.artist = artist;
    }
}
