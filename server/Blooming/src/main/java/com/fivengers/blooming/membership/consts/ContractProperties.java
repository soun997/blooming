package com.fivengers.blooming.membership.consts;

import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public final class ContractProperties {

    public static final BigInteger GAS_LIMIT = BigInteger.valueOf(50_000_000);
    public static final BigInteger DEPLOY_VALUE = BigInteger.ZERO;
    public static final Long ANTI_BOT_INTERVAL = 10L;
    public static final Long MINT_LIMIT_PER_BLOCK = 1L;
    public static final Long MINT_LIMIT_PER_SALE = 1L;
    public static final Long MINT_START_BLOCK_NUMBER = 0L;
    public static final Long MINT_INDEX_FOR_SALE = 1L;

    public final String metadataUrl;
    public final String keystoreUrl;

    public ContractProperties(
            @Value("${resource.cdn.domain}") String cdnDomain,
            @Value("${resource.cdn.metadata}") String metadataUrl,
            @Value("${resource.cdn.keystore}") String keystoreUrl) {
        this.metadataUrl = cdnDomain + metadataUrl;
        this.keystoreUrl = cdnDomain + keystoreUrl;
    }
}
