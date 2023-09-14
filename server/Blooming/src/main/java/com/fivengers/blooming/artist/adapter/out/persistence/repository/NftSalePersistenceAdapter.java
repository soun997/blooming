package com.fivengers.blooming.artist.adapter.out.persistence.repository;

import com.fivengers.blooming.artist.adapter.out.persistence.mapper.NftSaleMapper;
import com.fivengers.blooming.artist.application.port.out.NftSalePort;
import com.fivengers.blooming.artist.domain.NftSale;
import com.fivengers.blooming.global.exception.nftsale.NftSaleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NftSalePersistenceAdapter implements NftSalePort {

    private final NftSaleSpringDataRepository nftSaleSpringDataRepository;
    private final NftSaleMapper nftSaleMapper;

    @Override
    public NftSale findByArtistId(Long artistId) {
        return nftSaleMapper.toDomain(nftSaleSpringDataRepository
                .findByArtistId(artistId)
                .orElseThrow(NftSaleNotFoundException::new));
    }
}
