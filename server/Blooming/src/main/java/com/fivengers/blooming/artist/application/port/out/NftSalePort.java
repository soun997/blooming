package com.fivengers.blooming.artist.application.port.out;

import com.fivengers.blooming.artist.domain.NftSale;

public interface NftSalePort {

    NftSale findByArtistId(Long artistId);
}
