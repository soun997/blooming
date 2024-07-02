package com.fivengers.blooming.membership.adapter.out.persistence.repository;

import com.fivengers.blooming.membership.adapter.out.persistence.entity.MembershipRecordJpaEntity;
import java.util.List;

public interface CustomMembershipRecordRepository {

    List<MembershipRecordJpaEntity> findByMembershipIdOrderByStartDateDesc(
            Long memberId, Long limit);
}
