package com.fivengers.blooming.membership.application.port.out;

import com.fivengers.blooming.membership.domain.Membership;
import java.util.List;

public interface MembershipPort {

    List<Membership> findLatestSeasons();
}
