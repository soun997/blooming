package com.fivengers.blooming.live.domain;

// TODO : merge 전 임시 클래스 --> 이후 삭제 예정

import lombok.Getter;

@Getter
public class Member {

    private String profileImageUrl;

    public Member(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
