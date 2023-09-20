package com.fivengers.blooming.project.adapter.out.persistence.repository;

import com.fivengers.blooming.project.adapter.out.persistence.entity.ConcertJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConcertSpringDataRepository extends JpaRepository<ConcertJpaEntity, Long> {

    @Query("select c from ConcertJpaEntity c where c.endedAt > current date ")
    Page<ConcertJpaEntity> findAllOngoingProject(Pageable pageable);
}
