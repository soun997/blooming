package com.fivengers.blooming.membership.application.port.in;

import com.fivengers.blooming.membership.domain.Membership;
import java.util.List;

public interface MembershipUseCase {

    List<Membership> searchLatestSeasons();
}
