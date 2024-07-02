package com.fivengers.blooming.membership.application.port.in;

import com.fivengers.blooming.membership.application.port.in.dto.MembershipApplyRequest;
import com.fivengers.blooming.membership.domain.MembershipApplication;
import com.fivengers.blooming.membership.domain.MembershipApplicationState;
import java.util.List;

public interface MembershipApplicationUseCase {

    MembershipApplication add(MembershipApplyRequest request, Long memberId);

    List<MembershipApplication> searchAllByMemberIdAndApplicationState(
            Long memberId, MembershipApplicationState applicationState);
}
