package com.fivengers.blooming.fixture.project.adapter.out.persistence;

import com.fivengers.blooming.project.application.port.out.ConcertPort;
import com.fivengers.blooming.project.domain.Concert;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeConcertPersistenceAdapter implements ConcertPort {

    private final Map<Long, Concert> store = new HashMap<>();
    private Long autoIncrementId = 1L;

    public Concert save(Concert concert) {
        if (isPersistenceObject(concert)) {
            store.put(concert.getId(), concert);
            return concert;
        }
        return persist(concert);
    }

    private static boolean isPersistenceObject(Concert concert) {
        return concert.getId() != null;
    }

    private Concert persist(Concert concert) {
        LocalDateTime now = LocalDateTime.now();
        Concert persistedConcert = Concert.builder()
                .id(autoIncrementId)
                .name(concert.getName())
                .fundingAmount(concert.getFundingAmount())
                .startedAt(concert.getStartedAt())
                .endedAt(concert.getEndedAt())
                .description(concert.getDescription())
                .createdAt(now)
                .modifiedAt(now)
                .artist(concert.getArtist())
                .build();
        store.put(autoIncrementId, persistedConcert);
        autoIncrementId++;
        return persistedConcert;
    }

    @Override
    public List<Concert> findAll() {
        return store.values().stream().toList();
    }
}
