package com.fivengers.blooming.project_application.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoryInfo {

    private String introduction;
    private String description;
    private String listImg;
    private String compositionImg;
    private String teaserVideoUrl;
    private Long budget;

    @Builder
    public StoryInfo(String introduction, String description, String listImg, String compositionImg,
            String teaserVideoUrl, Long budget) {
        this.introduction = introduction;
        this.description = description;
        this.listImg = listImg;
        this.compositionImg = compositionImg;
        this.teaserVideoUrl = teaserVideoUrl;
        this.budget = budget;
    }
}
