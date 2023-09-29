package com.fivengers.blooming.project_application.adapter.out.persistence.entity;


import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoryInfoInJpaEntity {

    private String introduction;
    private String description;
    private String listImg;
    private String compositionImg;
    private String teaserVideoUrl;
    private Long budget;

    @Builder
    public StoryInfoInJpaEntity(String introduction, String description, String listImg,
            String compositionImg, String teaserVideoUrl, Long budget) {
        this.introduction = introduction;
        this.description = description;
        this.listImg = listImg;
        this.compositionImg = compositionImg;
        this.teaserVideoUrl = teaserVideoUrl;
        this.budget = budget;
    }
}
