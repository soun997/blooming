package com.fivengers.blooming.membership.adapter.out.persistence.repository;

import com.fivengers.blooming.membership.adapter.out.persistence.entity.MembershipJpaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MembershipSpringDataRepository extends JpaRepository<MembershipJpaEntity, Long> {

    @Query(value = "select m1 "
            + "from MembershipJpaEntity m1,"
            + " (select max(m.season) as latest_season, m.artist "
            + "from MembershipJpaEntity m "
            + "group by m.artist) m2 "
            + "where m1.artist = m2.artist and m1.season = m2.latest_season", nativeQuery = true)
    List<MembershipJpaEntity> findLatestSeasonsGroupByArtist();
}
