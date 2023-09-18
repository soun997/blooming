package com.fivengers.blooming.project.application;


import static org.assertj.core.api.Assertions.*;

import com.fivengers.blooming.artist.domain.Artist;
import com.fivengers.blooming.project.application.service.ConcertSevice;
import com.fivengers.blooming.project.domain.Concert;
import com.fivengers.blooming.project.domain.Project;
import com.fivengers.blooming.project.fixture.project.adapter.out.persistence.FakeConcertPersistenceAdapter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ConcertServiceTest {

    FakeConcertPersistenceAdapter concertPersistenceAdapter;
    ConcertSevice concertSevice;

    @BeforeEach
    void beforeEach() {
        this.concertPersistenceAdapter = new FakeConcertPersistenceAdapter();
        this.concertSevice = new ConcertSevice(concertPersistenceAdapter);
    }

    @Test
    @DisplayName("전체 콘서트 펀딩 프로젝트 목록을 조회한다.")
    void searchAllConcert() {
        // given
        LocalDateTime now = LocalDateTime.now();
        List<Concert> examples = new ArrayList<>();
        LongStream.range(0, 2).forEach(idx -> {
            Concert concert = Concert.builder()
                    .id(idx)
                    .name("아이유 데뷔 20주년 콘서트")
                    .startedAt(now)
                    .endedAt(now)
                    .description("아이유 데뷔 20주년을 기념하는 콘서트")
                    .createdAt(now)
                    .modifiedAt(now)
                    .artist(new Artist())
                    .build();
            concertPersistenceAdapter.save(concert);
            examples.add(concert);
        });

        // when
        List<Concert> concerts = concertSevice.searchAll();

        //then
        assertThat(concerts).hasSize(2);
        examples.forEach(ex -> {
            assertThat(concerts).contains(ex);
        });
    }
}
