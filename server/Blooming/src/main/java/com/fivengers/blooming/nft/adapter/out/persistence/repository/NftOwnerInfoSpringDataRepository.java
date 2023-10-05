package com.fivengers.blooming.nft.adapter.out.persistence.repository;

import com.fivengers.blooming.nft.adapter.out.persistence.entity.NftOwnerInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NftOwnerInfoSpringDataRepository extends JpaRepository<NftOwnerInfoEntity, Long> {

}
