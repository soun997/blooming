package com.fivengers.blooming.artist.adapter.out.persistence.repository;

import static com.fivengers.blooming.artist.adapter.out.persistence.entity.QArtistApplicationJpaEntity.artistApplicationJpaEntity;

import com.fivengers.blooming.artist.adapter.out.persistence.entity.ArtistApplicationJpaEntity;
import com.fivengers.blooming.artist.domain.ArtistApplicationState;
import com.fivengers.blooming.global.support.QuerydslRepositorySupport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistApplicationQueryRepository extends QuerydslRepositorySupport {

    public ArtistApplicationQueryRepository() {
        super(ArtistApplicationJpaEntity.class);
    }

    public Page<ArtistApplicationJpaEntity> findByArtistApplicationState(Pageable pageable,
            ArtistApplicationState state) {
        return applyPagination(pageable,
                query ->
                        query.selectFrom(artistApplicationJpaEntity)
                                .leftJoin(artistApplicationJpaEntity.memberJpaEntity)
                                .fetchJoin()
                                .where(artistApplicationJpaEntity.applicationState.eq(state))
                                .offset(pageable.getOffset())
                                .limit(pageable.getPageSize()),
                countQuery -> countQuery.select(artistApplicationJpaEntity.count())
                        .from(artistApplicationJpaEntity)
                        .where(artistApplicationJpaEntity.applicationState.eq(state)));
    }
}
