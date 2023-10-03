package com.fivengers.blooming.artist.adapter.in.web.dto;

import com.fivengers.blooming.project.domain.Concert;

public record ArtistConcertResponse(Boolean isExists,
                                    ArtistProjectResponse concert) {

    public static ArtistConcertResponse from(Concert concert) {
        if (concert == null) {
            return new ArtistConcertResponse(false, null);
        }
        return new ArtistConcertResponse(true, ArtistProjectResponse.from(concert));
    }
}
