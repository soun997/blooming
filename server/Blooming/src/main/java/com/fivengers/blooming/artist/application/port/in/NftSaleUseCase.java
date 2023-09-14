package com.fivengers.blooming.artist.application.port.in;

import com.fivengers.blooming.artist.domain.NftSale;

public interface NftSaleUseCase {

    NftSale searchByArtistId(Long artistId);
}
