package com.fivengers.blooming.artist.adapter.out.persistence;

import com.fivengers.blooming.artist.domain.Artist;
import com.fivengers.blooming.artist.domain.NftSale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NftSaleMapper {

    private final ArtistMapper artistMapper;

    NftSale toDomain(NftSaleJpaEntity nftSaleJpaEntity) {
        return NftSale.builder()
                .id(nftSaleJpaEntity.getId())
                .issueCount(nftSaleJpaEntity.getIssueCount())
                .saleCount(nftSaleJpaEntity.getSaleCount())
                .issuesAmount(nftSaleJpaEntity.getIssuesAmount())
                .salesAmount(nftSaleJpaEntity.getSalesAmount())
                .deleted(nftSaleJpaEntity.getDeleted())
                .artist(artistMapper.toDomain(nftSaleJpaEntity.getArtist()))
                .build();
    }

    NftSaleJpaEntity toEntity(NftSale nftSale) {
        return NftSaleJpaEntity.builder()
                .issueCount(nftSale.getIssueCount())
                .saleCount(nftSale.getSaleCount())
                .issuesAmount(nftSale.getIssuesAmount())
                .salesAmount(nftSale.getSalesAmount())
                .deleted(nftSale.getDeleted())
                .artist(artistMapper.toJpaEntity(nftSale.getArtist()))
                .build();
    }

}
