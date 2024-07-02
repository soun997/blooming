package com.fivengers.blooming.membership.adapter.out.persistence;

import com.fivengers.blooming.global.exception.membership.MembershipApplicationNotFoundException;
import com.fivengers.blooming.membership.adapter.out.persistence.entity.MembershipApplicationJpaEntity;
import com.fivengers.blooming.membership.adapter.out.persistence.mapper.MembershipApplicationMapper;
import com.fivengers.blooming.membership.adapter.out.persistence.repository.MembershipApplicationRepository;
import com.fivengers.blooming.membership.application.port.out.MembershipApplicationPort;
import com.fivengers.blooming.membership.domain.MembershipApplication;
import com.fivengers.blooming.membership.domain.MembershipApplicationState;
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
public class MembershipApplicationPersistenceAdapter implements MembershipApplicationPort {

    private final MembershipApplicationRepository membershipApplicationRepository;
    private final MembershipApplicationMapper mapper;

    @Override
    public Page<MembershipApplication> findByApplicationState(
            Pageable pageable, MembershipApplicationState applicationState) {

        return membershipApplicationRepository.findByApplicationState(pageable, applicationState)
                .map(mapper::toDomain);
    }

    @Override
    @Transactional
    public MembershipApplication save(MembershipApplication membershipApplication) {
        return mapper.toDomain(
                membershipApplicationRepository.save(mapper.toJpaEntity(membershipApplication)));
    }

    @Override
    public Optional<MembershipApplication> findById(Long applicationId) {
        return membershipApplicationRepository.findById(applicationId).map(mapper::toDomain);
    }

    @Override
    public List<MembershipApplication> findByMemberIdAndApplicationState(
            Long memberId, MembershipApplicationState applicationState) {
        return membershipApplicationRepository
                .findByMemberIdAndApplicationState(memberId, applicationState)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public MembershipApplication update(MembershipApplication membershipApplication) {
        MembershipApplicationJpaEntity application =
                membershipApplicationRepository
                        .findById(membershipApplication.getId())
                        .orElseThrow(MembershipApplicationNotFoundException::new);

        application.update(membershipApplication);
        return mapper.toDomain(application);
    }
}
