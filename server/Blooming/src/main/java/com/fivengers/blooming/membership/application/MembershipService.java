package com.fivengers.blooming.membership.application;

import com.fivengers.blooming.membership.application.port.in.MembershipUseCase;
import com.fivengers.blooming.membership.application.port.out.MembershipPort;
import com.fivengers.blooming.membership.domain.Membership;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipService implements MembershipUseCase {

    private final MembershipPort membershipPort;

    @Override
    public List<Membership> searchLatestSeasons() {
        return membershipPort.findLatestSeasons();
    }
}
