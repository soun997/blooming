package com.fivengers.blooming.artist.application;

import com.fivengers.blooming.artist.application.port.in.NftSaleUseCase;
import com.fivengers.blooming.artist.application.port.out.NftSalePort;
import com.fivengers.blooming.artist.domain.NftSale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NftSaleService implements NftSaleUseCase {

    private final NftSalePort nftSalePort;

    @Override
    public NftSale searchByArtistId(Long artistId) {
        return nftSalePort.findByArtistId(artistId);
    }
}
