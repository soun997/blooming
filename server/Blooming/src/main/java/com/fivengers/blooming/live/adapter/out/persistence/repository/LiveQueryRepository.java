package com.fivengers.blooming.live.adapter.out.persistence.repository;

import com.fivengers.blooming.artist.adapter.out.persistence.entity.QArtistJpaEntity;
import com.fivengers.blooming.live.adapter.out.persistence.entity.LiveJpaEntity;
import com.fivengers.blooming.live.adapter.out.persistence.entity.QLiveJpaEntity;
import com.fivengers.blooming.member.adapter.out.persistence.entity.QMemberJpaEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class LiveQueryRepository {

    private final JPAQueryFactory queryFactory;
    private QMemberJpaEntity member = QMemberJpaEntity.memberJpaEntity;
    private QArtistJpaEntity artist = QArtistJpaEntity.artistJpaEntity;
    private QLiveJpaEntity live = QLiveJpaEntity.liveJpaEntity;

    public LiveQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    List<LiveJpaEntity> findActiveLiveByTitleKeyword(String keyword, Pageable pageable) {
        return queryFactory.selectFrom(live)
                .leftJoin(live.artistJpaEntity, artist)
                .fetchJoin()
                .leftJoin(artist.memberJpaEntity, member)
                .fetchJoin()
                .where(member.deleted.isFalse()
                        .and(artist.deleted.isFalse())
                        .and(live.title.contains(keyword)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    List<LiveJpaEntity> findActiveLiveByArtist(String keyword, Pageable pageable) {
        return queryFactory.selectFrom(live)
                .leftJoin(live.artistJpaEntity, artist)
                .fetchJoin()
                .leftJoin(artist.memberJpaEntity, member)
                .fetchJoin()
                .where(member.deleted.isFalse()
                        .and(artist.deleted.isFalse())
                        .and(artist.stageName.contains(keyword)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}
