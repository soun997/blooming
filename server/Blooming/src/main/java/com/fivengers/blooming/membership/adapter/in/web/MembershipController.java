package com.fivengers.blooming.membership.adapter.in.web;

import com.fivengers.blooming.config.security.oauth2.LoginUser;
import com.fivengers.blooming.global.response.ApiResponse;
import com.fivengers.blooming.membership.adapter.in.web.dto.MembershipDetailsResponse;
import com.fivengers.blooming.membership.adapter.in.web.dto.MembershipListResponse;
import com.fivengers.blooming.membership.application.port.in.MembershipUseCase;
import com.fivengers.blooming.membership.application.port.in.dto.MembershipModifyRequest;
import com.fivengers.blooming.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/memberships")
@RequiredArgsConstructor
public class MembershipController {

    private final MembershipUseCase membershipUseCase;

    @GetMapping
    public ApiResponse<Page<MembershipListResponse>> membershipList(Pageable pageable) {
        Page<Membership> memberships = membershipUseCase.searchLatestSeasons(pageable);
        ;
        return ApiResponse.ok(PageableExecutionUtils.getPage(memberships.stream()
                .map(MembershipListResponse::from)
                .toList(), pageable, memberships::getTotalElements));
    }

    @GetMapping("/ongoing")
    public ApiResponse<Page<MembershipListResponse>> membershipListByOngoing(Pageable pageable) {
        Page<Membership> memberships = membershipUseCase.searchOngoing(pageable);

        ;
        return ApiResponse.ok(PageableExecutionUtils.getPage(memberships.getContent().stream()
                .map(MembershipListResponse::from)
                .toList(), pageable, memberships::getTotalElements));
    }

    @PutMapping("/{membershipId}")
    public ApiResponse<MembershipDetailsResponse> membershipModify(
            @PathVariable Long membershipId,
            @RequestBody @Validated MembershipModifyRequest request,
            @AuthenticationPrincipal LoginUser loginUser) {
        return ApiResponse.ok(MembershipDetailsResponse.from(
                membershipUseCase.modify(request, membershipId, loginUser.getMemberId())));
    }
}
