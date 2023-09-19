package com.fivengers.blooming.membership.adapter.out.persistence.repository;

import com.fivengers.blooming.membership.adapter.out.persistence.entity.MembershipJpaEntity;
import com.fivengers.blooming.membership.adapter.out.persistence.entity.QMembershipJpaEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.fivengers.blooming.membership.adapter.out.persistence.entity.QMembershipJpaEntity.membershipJpaEntity;
import static com.querydsl.jpa.JPAExpressions.select;

@Repository
public class MembershipQueryRepository {

    private final JPAQueryFactory queryFactory;

    public MembershipQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    List<MembershipJpaEntity> findLatestSeasonsGroupByArtist() {
        QMembershipJpaEntity sub = new QMembershipJpaEntity("sub");

        return queryFactory
                .select(membershipJpaEntity)
                .from(membershipJpaEntity)
                .where(membershipJpaEntity.deleted.eq(false)
                        .and(membershipJpaEntity.artistJpaEntity.in(
                                select(sub.artistJpaEntity)
                                        .from(sub)
                                        .groupBy(sub.artistJpaEntity)
                                        .having(membershipJpaEntity.season.eq(sub.season.max())))))
                .fetch();
    }
}
