package com.fivengers.blooming.artist.adapter.in.web.dto;

import com.fivengers.blooming.project.domain.Activity;

public record ArtistActivityResponse(Boolean isExists,
                                     ArtistProjectResponse activity) {

    public static ArtistActivityResponse from(Activity activity) {
        if (activity == null) {
            return new ArtistActivityResponse(false, null);
        }
        return new ArtistActivityResponse(true, ArtistProjectResponse.from(activity));
    }
}
