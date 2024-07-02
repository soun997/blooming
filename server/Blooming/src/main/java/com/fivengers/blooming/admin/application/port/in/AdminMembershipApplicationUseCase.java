package com.fivengers.blooming.admin.application.port.in;

import com.fivengers.blooming.membership.domain.MembershipApplication;
import com.fivengers.blooming.membership.domain.MembershipApplicationState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminMembershipApplicationUseCase {

    Page<MembershipApplication> searchAll(
            Pageable pageable, MembershipApplicationState applicationState);

    MembershipApplication modifyStateById(
            MembershipApplicationState applicationState, Long applicationId);
}
