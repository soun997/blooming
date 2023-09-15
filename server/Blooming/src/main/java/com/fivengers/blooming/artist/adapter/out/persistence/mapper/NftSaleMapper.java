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
                .totalNftCount(nftSaleJpaEntity.getTotalNftCount())
                .soldNftCount(nftSaleJpaEntity.getSoldNftCount())
                .totalNftAmount(nftSaleJpaEntity.getTotalNftAmount())
                .soldNftAmount(nftSaleJpaEntity.getSoldNftAmount())
                .build();
    }

    public NftSaleJpaEntity toEntity(NftSale nftSale) {
        return NftSaleJpaEntity.builder()
                .totalNftCount(nftSale.getTotalNftCount())
                .soldNftCount(nftSale.getSoldNftCount())
                .totalNftAmount(nftSale.getTotalNftAmount())
                .soldNftAmount(nftSale.getSoldNftAmount())
                .deleted(false)
                .build();
    }

}
