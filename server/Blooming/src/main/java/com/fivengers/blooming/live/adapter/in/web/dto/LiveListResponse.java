package com.fivengers.blooming.live.adapter.in.web.dto;

import com.fivengers.blooming.live.domain.Artist;
import com.fivengers.blooming.live.domain.Live;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;

@Builder
public record LiveListResponse(
        Long id,
        Map<String, Object> artist, // id, stageName, profileImageUrl
        String title,
        String sessionId
) {

    public static LiveListResponse from(Live live) {
        return LiveListResponse.builder()
                .id(live.getId())
                .artist(createArtistInfo(live.getArtist()))
                .title(live.getTitle())
                .sessionId(live.getSessionId())
                .build();
    }

    private static Map<String, Object> createArtistInfo(Artist artist) {
        Map<String, Object> artistInfo = new HashMap<>();
        artistInfo.put("id", artist.getId());
        artistInfo.put("stageName", artist.getStageName());
        artistInfo.put("profileImageUrl", artist.getMember().getProfileImageUrl());
        return artistInfo;
    }
}
