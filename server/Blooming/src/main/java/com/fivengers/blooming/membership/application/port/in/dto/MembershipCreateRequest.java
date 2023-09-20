package com.fivengers.blooming.membership.application.port.in.dto;

import com.fivengers.blooming.artist.domain.Artist;
import com.fivengers.blooming.membership.domain.Membership;
import com.fivengers.blooming.membership.domain.NftSale;
import com.fivengers.blooming.nft.domain.Nft;
import java.time.LocalDateTime;

public record MembershipCreateRequest(String title,
                                      String description,
                                      Integer season,
                                      LocalDateTime seasonStart,
                                      LocalDateTime seasonEnd,
                                      LocalDateTime purchaseStart,
                                      LocalDateTime purchaseEnd,
                                      String thumbnailUrl,
                                      Long artistId,
                                      Long nftId) {

    public Membership toDomain(Artist artist, Nft nft) {
        return Membership.builder()
                .title(title)
                .description(description)
                .season(season)
                .seasonStart(seasonStart)
                .seasonEnd(seasonEnd)
                .purchaseStart(purchaseStart)
                .purchaseEnd(purchaseEnd)
                .thumbnailUrl(thumbnailUrl)
                .artist(artist)
                .nft(nft)
                .nftSale(NftSale.builder()
                        .totalNftCount(0)
                        .soldNftCount(0)
                        .totalNftAmount(0L)
                        .soldNftAmount(0L)
                        .build())
                .build();
    }
}
