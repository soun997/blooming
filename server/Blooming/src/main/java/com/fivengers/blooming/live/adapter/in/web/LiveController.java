package com.fivengers.blooming.live.adapter.in.web;

import com.fivengers.blooming.global.response.ApiResponse;
import com.fivengers.blooming.live.adapter.in.web.dto.LiveListResponse;
import com.fivengers.blooming.live.adapter.in.web.dto.SearchRequest;
import com.fivengers.blooming.live.application.port.in.LiveSearchUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/live")
@RequiredArgsConstructor
public class LiveController {

    private final LiveSearchUseCase liveSearchUseCase;

    @GetMapping("/search/keyword")
    public ApiResponse<List<LiveListResponse>> LiveListByKeyword(@RequestParam String query, Pageable pageable) {
        // TODO : searchRequest Validation
        List<LiveListResponse> liveResponseList = liveSearchUseCase.searchByKeyword(query, pageable)
                .stream().map(LiveListResponse::from)
                .toList();
        return new ApiResponse<>(HttpStatus.OK.value(), liveResponseList);
    }
}
