package com.fivengers.blooming.artist.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistSpringDataRepository extends JpaRepository<ArtistJpaEntity, Long> {

}
