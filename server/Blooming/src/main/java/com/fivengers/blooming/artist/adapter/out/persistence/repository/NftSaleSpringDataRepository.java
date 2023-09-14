package com.fivengers.blooming.artist.adapter.out.persistence.repository;

import com.fivengers.blooming.artist.adapter.out.persistence.entity.NftSaleJpaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NftSaleSpringDataRepository extends JpaRepository<NftSaleJpaEntity, Long> {

    Optional<NftSaleJpaEntity> findByArtistId(Long artistId);

}
