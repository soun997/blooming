package com.fivengers.blooming.membership.application.port.in.dto;

import com.fivengers.blooming.artist.domain.Artist;
import com.fivengers.blooming.membership.domain.Membership;
import com.fivengers.blooming.membership.domain.NftSale;
import java.time.LocalDateTime;

public record MembershipCreateRequest(String title,
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
                                      Long artistId) {

    public Membership toDomain(Artist artist) {
        return Membership.builder()
                .title(title)
                .symbol(symbol)
                .description(description)
                .season(season)
                .seasonStart(seasonStart)
                .seasonEnd(seasonEnd)
                .purchaseStart(purchaseStart)
                .purchaseEnd(purchaseEnd)
                .saleCount(saleCount)
                .salePrice(salePrice)
                .imageUrl(imageUrl)
                .contractAddress(contractAddress)
                .artist(artist)
                .nftSale(NftSale.builder()
                        .totalNftCount(0L)
                        .soldNftCount(0L)
                        .totalNftAmount(0L)
                        .soldNftAmount(0L)
                        .build())
                .build();
    }
}
