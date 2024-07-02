package com.fivengers.blooming.membership.adapter.out.persistence.repository;

import com.fivengers.blooming.membership.adapter.out.persistence.entity.MembershipApplicationJpaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipApplicationRepository extends
        JpaRepository<MembershipApplicationJpaEntity, Long>, CustomMembershipApplicationRepository {

    Optional<MembershipApplicationJpaEntity> findById(Long applicationId);
}
