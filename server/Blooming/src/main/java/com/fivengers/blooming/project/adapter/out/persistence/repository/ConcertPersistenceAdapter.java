package com.fivengers.blooming.project.adapter.out.persistence.repository;


import com.fivengers.blooming.project.adapter.out.persistence.mapper.ConcertMapper;
import com.fivengers.blooming.project.application.port.out.ConcertPort;
import com.fivengers.blooming.project.domain.Concert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ConcertPersistenceAdapter implements ConcertPort {

    private final ConcertMapper concertMapper;
    private final ConcertSpringDataRepository concertSpringDataRepository;

    @Override
    public List<Concert> findAll() {
        return concertSpringDataRepository.findAll().stream()
                .map(concertMapper::toDomain)
                .toList();
    }
}
