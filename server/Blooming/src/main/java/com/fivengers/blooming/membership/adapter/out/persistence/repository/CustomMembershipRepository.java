package com.fivengers.blooming.membership.adapter.out.persistence.repository;

import com.fivengers.blooming.membership.adapter.out.persistence.entity.MembershipJpaEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomMembershipRepository {

    Optional<MembershipJpaEntity> findById(Long membershipId);

    Page<MembershipJpaEntity> findLatestSeasonsGroupByArtist(Pageable pageable);

    List<MembershipJpaEntity> findTopNSaleCount(long n);

    Page<MembershipJpaEntity> findByArtistNameLikeQuery(Pageable pageable, String searchQuery);

    Page<MembershipJpaEntity> findByBetweenSeasonStartAndSeasonEnd(
            Pageable pageable, LocalDateTime now);

    Optional<MembershipJpaEntity> findByArtistIdAndBetweenSeasonStartAndSeasonEnd(
            Long artistId, LocalDateTime now);

    int findLatestSeasonByArtistId(Long artistId);
}
