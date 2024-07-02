package com.fivengers.blooming.membership.adapter.out.persistence.repository;

import com.fivengers.blooming.membership.adapter.out.persistence.entity.MembershipApplicationJpaEntity;
import com.fivengers.blooming.membership.domain.MembershipApplicationState;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomMembershipApplicationRepository {

    Page<MembershipApplicationJpaEntity> findByApplicationState(
            Pageable pageable, MembershipApplicationState state);

    Optional<MembershipApplicationJpaEntity> findById(Long applicationId);

    List<MembershipApplicationJpaEntity> findByMemberIdAndApplicationState(
            Long memberId, MembershipApplicationState applicationState);
}
