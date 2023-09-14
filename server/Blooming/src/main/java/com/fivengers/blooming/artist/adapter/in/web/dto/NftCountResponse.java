package com.fivengers.blooming.artist.adapter.in.web.dto;

import com.fivengers.blooming.artist.domain.NftSale;

public record NftCountResponse(Integer issueCount,
                               Integer saleCount) {

    public static NftCountResponse from(NftSale nftSale) {
        return new NftCountResponse(nftSale.getIssueCount(), nftSale.getSaleCount());
    }

}
