package com.fivengers.blooming.admin.adapter.in.web;

import com.fivengers.blooming.admin.application.port.in.AdminMembershipApplicationUseCase;
import com.fivengers.blooming.global.response.ApiResponse;
import com.fivengers.blooming.membership.adapter.in.web.dto.MembershipApplicationDetailsResponse;
import com.fivengers.blooming.admin.adapter.in.web.dto.MembershipApplicationListResponse;
import com.fivengers.blooming.membership.domain.MembershipApplication;
import com.fivengers.blooming.membership.domain.MembershipApplicationState;
import com.fivengers.blooming.project.adapter.in.web.dto.ArtistResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/membership-applications")
@RequiredArgsConstructor
public class AdminMembershipApplicationController {

    private final AdminMembershipApplicationUseCase adminMembershipApplicationUseCase;

    @GetMapping
    public ApiResponse<Page<MembershipApplicationListResponse>> membershipApplicationList(
            @RequestParam(required = false) MembershipApplicationState state, Pageable pageable) {

        return ApiResponse.ok(
                adminMembershipApplicationUseCase
                        .searchAll(pageable, state)
                        .map(application ->
                                MembershipApplicationListResponse.from(
                                        application,
                                        ArtistResponse.from(application.getArtist()))));
    }

    @PutMapping("{applicationId}/modify-state")
    public ApiResponse<MembershipApplicationDetailsResponse> membershipApplicationStateModify(
            @PathVariable Long applicationId,
            @RequestParam MembershipApplicationState applicationState) {

        MembershipApplication membershipApplication =
                adminMembershipApplicationUseCase.modifyStateById(applicationState, applicationId);

        return ApiResponse.ok(
                MembershipApplicationDetailsResponse.from(
                        membershipApplication,
                        ArtistResponse.from(membershipApplication.getArtist())));
    }

}
