package com.fivengers.blooming.artist.adapter.out.persistence.mapper;

import com.fivengers.blooming.artist.adapter.out.persistence.entity.NftSaleJpaEntity;
import com.fivengers.blooming.artist.domain.NftSale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NftSaleMapper {

    private final ArtistMapper artistMapper;

    public NftSale toDomain(NftSaleJpaEntity nftSaleJpaEntity) {
        return NftSale.builder()
                .id(nftSaleJpaEntity.getId())
                .issueCount(nftSaleJpaEntity.getIssueCount())
                .saleCount(nftSaleJpaEntity.getSaleCount())
                .issuesAmount(nftSaleJpaEntity.getIssuesAmount())
                .salesAmount(nftSaleJpaEntity.getSalesAmount())
                .artist(artistMapper.toDomain(nftSaleJpaEntity.getArtist()))
                .build();
    }

    public NftSaleJpaEntity toEntity(NftSale nftSale) {
        return NftSaleJpaEntity.builder()
                .issueCount(nftSale.getIssueCount())
                .saleCount(nftSale.getSaleCount())
                .issuesAmount(nftSale.getIssuesAmount())
                .salesAmount(nftSale.getSalesAmount())
                .deleted(false)
                .artist(artistMapper.toJpaEntity(nftSale.getArtist()))
                .build();
    }

}
