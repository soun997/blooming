package com.fivengers.blooming.artistscrap.adapter.out.persistence.repository;

import com.fivengers.blooming.artistscrap.adapter.out.persistence.entity.ArtistScrapRecordJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistScrapRecordSpringDataRepository
        extends JpaRepository<ArtistScrapRecordJpaEntity, Long> {

}
