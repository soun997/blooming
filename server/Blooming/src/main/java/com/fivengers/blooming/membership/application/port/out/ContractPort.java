package com.fivengers.blooming.membership.application.port.out;

import com.klaytn.caver.contract.Contract;
import java.math.BigDecimal;

public interface ContractPort {

    Contract deployContract(String title, String symbol);

    void setBaseUri(Contract contract, String baseUri);

    void reveal(Contract contract);

    void setupSale(
            Contract contract,
            Long newAntiBotInterval,   // 봇 독점 방지 (minting interval)
            Long newMintLimitPerBlock,  // 한 번의 트랜잭션에서 최대로 민팅할 수 있는 양
            Long newMintLimitPerSale,   // 한 계정당 가질 수 있는 NFT 개수 제한
            Long newMintStartBlockNumber,   // 민팅을 시작할 수 있는 블록 높이
            Long newMintIndexForSale,   // 발행할 NFT 토큰 번호의 시작 index
            Long newMaxSaleAmount,
            BigDecimal newMintPrice);

    void setPublicMintEnabled(Contract contract);

    void publicMint(Contract contract, Long requestedCount);

    void transferFrom(Contract contract, String from, String to, Long tokenId);
}
