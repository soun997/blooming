package com.fivengers.blooming.membership.adapter.out.persistence.repository;

import com.fivengers.blooming.membership.adapter.out.persistence.entity.MembershipJpaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository
        extends JpaRepository<MembershipJpaEntity, Long>, CustomMembershipRepository {

    Optional<MembershipJpaEntity> findById(Long membershipId);
}
