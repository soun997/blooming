package com.fivengers.blooming.membership.adapter.out.persistence;

import com.fivengers.blooming.global.exception.membership.MembershipNotFoundException;
import com.fivengers.blooming.membership.adapter.out.persistence.entity.MembershipJpaEntity;
import com.fivengers.blooming.membership.adapter.out.persistence.mapper.MembershipMapper;
import com.fivengers.blooming.membership.adapter.out.persistence.repository.MembershipRepository;
import com.fivengers.blooming.membership.application.port.out.MembershipPort;
import com.fivengers.blooming.membership.domain.Membership;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements MembershipPort {

    private final MembershipRepository membershipRepository;
    private final MembershipMapper membershipMapper;

    @Override
    @Transactional
    public Membership save(Membership membership) {
        return membershipMapper.toDomain(
                membershipRepository.save(membershipMapper.toJpaEntity(membership)));
    }

    @Override
    public Page<Membership> findLatestSeasons(Pageable pageable) {

        return membershipRepository.findLatestSeasonsGroupByArtist(pageable)
                .map(membershipMapper::toDomain);
    }

    @Override
    public Page<Membership> findByBetweenSeasonStartAndSeasonEnd(
            Pageable pageable, LocalDateTime now) {

        return  membershipRepository.findByBetweenSeasonStartAndSeasonEnd(pageable, now)
                .map(membershipMapper::toDomain);
    }

    @Override
    public Optional<Membership> findByArtistIdAndBetweenSeasonStartAndSeasonEnd(
            Long artistId, LocalDateTime now) {
        return membershipRepository.findByArtistIdAndBetweenSeasonStartAndSeasonEnd(artistId, now)
                .map(membershipMapper::toDomain);
    }

    @Override
    public Optional<Membership> findById(Long membershipId) {
        return membershipRepository.findById(membershipId)
                .map(membershipMapper::toDomain);
    }

    @Override
    public List<Membership> findByTopNSalesCount(long n) {
        return membershipRepository.findTopNSaleCount(n).stream()
                .map(membershipMapper::toDomain)
                .toList();
    }

    @Override
    public Page<Membership> findByArtistNameContains(Pageable pageable, String query) {

        return membershipRepository.findByArtistNameLikeQuery(pageable, query)
                .map(membershipMapper::toDomain);
    }

    @Override
    public Membership update(Membership membership) {
        MembershipJpaEntity membershipJpaEntity =
                membershipRepository.findById(membership.getId())
                        .orElseThrow(MembershipNotFoundException::new);
        membershipJpaEntity.update(membership);
        return membershipMapper.toDomain(membershipJpaEntity);
    }

    @Override
    public int findLatestSeasonByArtistId(Long artistId) {
        return membershipRepository.findLatestSeasonByArtistId(artistId);
    }
}
