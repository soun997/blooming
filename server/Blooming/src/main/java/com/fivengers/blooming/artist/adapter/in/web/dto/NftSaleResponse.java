package com.fivengers.blooming.artist.adapter.in.web.dto;

import com.fivengers.blooming.artist.domain.NftSale;
import lombok.Builder;

@Builder
public record NftSaleResponse(Integer totalNftCount,
                              Integer soldNftCount,
                              Long totalNftAmount,
                              Long soldNftAmount) {

    public static NftSaleResponse from(NftSale nftSale) {
        return NftSaleResponse.builder()
                .totalNftCount(nftSale.getTotalNftCount())
                .soldNftCount(nftSale.getSoldNftCount())
                .totalNftAmount(nftSale.getTotalNftAmount())
                .soldNftAmount(nftSale.getSoldNftAmount())
                .build();
    }

}
