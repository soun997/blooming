package com.fivengers.blooming.artistscrap.adapter.out.persistence.repository;

import com.fivengers.blooming.artistscrap.adapter.out.persistence.entity.ArtistScrapJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistScrapSpringDataRepository extends JpaRepository<ArtistScrapJpaEntity, Long> {

    void deleteByMemberJpaEntityIdAndArtistJpaEntityId(Long memberJpaEntityId, Long artistJpaEntityId);
}
