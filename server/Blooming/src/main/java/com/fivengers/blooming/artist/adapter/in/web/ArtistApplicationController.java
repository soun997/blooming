package com.fivengers.blooming.artist.adapter.in.web;

import com.fivengers.blooming.artist.adapter.in.web.dto.ArtistApplicationDetailsResponse;
import com.fivengers.blooming.artist.adapter.in.web.dto.ArtistApplicationListResponse;
import com.fivengers.blooming.artist.application.port.in.ArtistApplicationUseCase;
import com.fivengers.blooming.artist.application.port.in.dto.ArtistApplyRequest;
import com.fivengers.blooming.artist.domain.ArtistApplication;
import com.fivengers.blooming.artist.domain.ArtistApplicationState;
import com.fivengers.blooming.config.security.oauth2.LoginUser;
import com.fivengers.blooming.global.response.ApiResponse;
import com.fivengers.blooming.member.adapter.in.web.dto.MemberResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/artist-applications")
@RequiredArgsConstructor
public class ArtistApplicationController {

    private final ArtistApplicationUseCase artistApplicationUseCase;

    @GetMapping
    public ApiResponse<Page<ArtistApplicationListResponse>> artistApplicationList(Pageable pageable,
            @RequestParam ArtistApplicationState state) {
        Page<ArtistApplication> artistApplications = artistApplicationUseCase.searchByArtistApplicationState(
                pageable, state);

        List<ArtistApplicationListResponse> responses = artistApplications.getContent().stream()
                .map(application -> ArtistApplicationListResponse.from(application,
                        MemberResponse.from(application.getMember())))
                .toList();

        return ApiResponse.ok(
                new PageImpl<>(responses, pageable, artistApplications.getTotalElements()));
    }

    @PostMapping
    public ApiResponse<ArtistApplicationDetailsResponse> artistApplicationCreate(
            @RequestBody @Validated ArtistApplyRequest request,
            @AuthenticationPrincipal LoginUser loginUser) {
        ArtistApplication artistApplication =
                artistApplicationUseCase.add(request, loginUser.getMemberId());

        return ApiResponse.ok(ArtistApplicationDetailsResponse.from(artistApplication,
                MemberResponse.from(artistApplication.getMember())));
    }
}
