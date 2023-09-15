package com.fivengers.blooming.membership.application;

import com.fivengers.blooming.membership.application.port.in.NftSaleUseCase;
import com.fivengers.blooming.membership.application.port.out.NftSalePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NftSaleService implements NftSaleUseCase {

    private final NftSalePort nftSalePort;

}
