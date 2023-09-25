package com.fivengers.blooming.artist.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ArtistVideo {

    private Long id;
    private String videoUrl;
    private Artist artist;

    @Builder
    public ArtistVideo(Long id, String videoUrl, Artist artist) {
        this.id = id;
        this.videoUrl = videoUrl;
        this.artist = artist;
    }
}
