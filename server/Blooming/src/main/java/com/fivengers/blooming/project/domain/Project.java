package com.fivengers.blooming.project.domain;

import com.fivengers.blooming.artist.domain.Artist;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED) // 상속 관계가 아닌 외부에서 호출할 수 없음
public class Project {

    private Long id;
    private String name;
    private Long fundingAmount;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private String description;
    private Boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;

    private Artist artist;
}
