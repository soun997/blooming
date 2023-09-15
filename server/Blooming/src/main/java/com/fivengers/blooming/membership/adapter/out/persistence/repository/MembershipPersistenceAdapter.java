package com.fivengers.blooming.membership.adapter.out.persistence.repository;

import com.fivengers.blooming.membership.adapter.out.persistence.mapper.MembershipMapper;
import com.fivengers.blooming.membership.application.port.out.MembershipPort;
import com.fivengers.blooming.membership.domain.Membership;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements MembershipPort {

    private final MembershipSpringDataRepository membershipSpringDataRepository;
    private final MembershipMapper membershipMapper;

    @Override
    public List<Membership> findLatestSeasons() {
        return membershipSpringDataRepository.findLatestSeasonsGroupByArtist().stream()
                .map(membershipMapper::toDomain)
                .toList();
    }
}
