package com.fivengers.blooming.project_application.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SettlementInfo {

    private String representative;
    private String email;
    private String accountNumber;
    private String bankbookImg;

    @Builder
    public SettlementInfo(String representative, String email, String accountNumber, String bankbookImg) {
        this.representative = representative;
        this.email = email;
        this.accountNumber = accountNumber;
        this.bankbookImg = bankbookImg;
    }
}
