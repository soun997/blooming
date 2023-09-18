package com.fivengers.blooming.project.domain;

import com.fivengers.blooming.artist.domain.Artist;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {

    private Long id;
    private String name;
    private Long fundingAmount;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private Artist artist;
}
