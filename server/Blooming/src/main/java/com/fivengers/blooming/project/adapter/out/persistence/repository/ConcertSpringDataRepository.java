package com.fivengers.blooming.project.adapter.out.persistence.repository;

import com.fivengers.blooming.project.adapter.out.persistence.entity.ConcertJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertSpringDataRepository extends JpaRepository<ConcertJpaEntity, Long> {
}
