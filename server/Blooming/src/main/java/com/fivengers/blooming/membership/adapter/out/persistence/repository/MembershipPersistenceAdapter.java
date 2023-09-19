package com.fivengers.blooming.membership.adapter.out.persistence.repository;

import com.fivengers.blooming.membership.adapter.out.persistence.mapper.MembershipMapper;
import com.fivengers.blooming.membership.application.port.out.MembershipPort;
import com.fivengers.blooming.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements MembershipPort {

    private final MembershipQueryRepository membershipQueryRepository;
    private final MembershipMapper membershipMapper;

    @Override
    public List<Membership> findLatestSeasons() {
        return membershipQueryRepository.findLatestSeasonsGroupByArtist().stream()
                .map(membershipMapper::toDomain)
                .toList();
    }
}
