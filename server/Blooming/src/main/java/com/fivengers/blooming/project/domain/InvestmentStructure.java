package com.fivengers.blooming.project.domain;


import lombok.Builder;
import lombok.Getter;

@Getter
public class InvestmentStructure {

    private Project project;

    private Long totalAmount;
    private Long customerTransaction;
    private Integer dividendRatio;

    @Builder
    public InvestmentStructure(Project project,
                               Long totalAmount,
                               Long customerTransaction,
                               Integer dividendRatio) {
        this.project = project;
        this.totalAmount = totalAmount;
        this.customerTransaction = customerTransaction;
        this.dividendRatio = dividendRatio;
    }
}
