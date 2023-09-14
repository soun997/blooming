package com.fivengers.blooming.artist.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.fivengers.blooming.artist.domain.Artist;
import com.fivengers.blooming.artist.domain.NftSale;
import com.fivengers.blooming.fixture.artist.adapter.out.persistence.FakeNftSalePersistenceAdapter;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NftSaleServiceTest {

    NftSaleService nftSaleService;
    FakeNftSalePersistenceAdapter nftSalePersistenceAdapter;
    Artist artist;

    @BeforeEach
    void initObjects() {
        LocalDateTime now = LocalDateTime.now();
        this.artist = Artist.builder()
                .id(1L)
                .stageName("아이유")
                .agency("EDAM 엔터테인먼트")
                .description("아이유입니다.")
                .createdAt(now)
                .modifiedAt(now)
                .build();
        this.nftSalePersistenceAdapter = new FakeNftSalePersistenceAdapter();
        nftSaleService = new NftSaleService(this.nftSalePersistenceAdapter);
    }

    @Test
    @DisplayName("아티스트 ID를 통해 nft 집계를 조회한다.")
    void findNftSaleByArtistId() {
        // given
        LocalDateTime now = LocalDateTime.now();
        NftSale nftSale = NftSale.builder()
                .id(1L)
                .issueCount(1)
                .saleCount(1)
                .issuesAmount(10000L)
                .salesAmount(10000L)
                .createdAt(now)
                .modifiedAt(now)
                .artist(this.artist)
                .build();
        nftSalePersistenceAdapter.save(nftSale);

        NftSale searchedNftSale = nftSaleService.searchByArtistId(artist.getId());

        assertThat(searchedNftSale).isEqualTo(nftSale);
    }
}