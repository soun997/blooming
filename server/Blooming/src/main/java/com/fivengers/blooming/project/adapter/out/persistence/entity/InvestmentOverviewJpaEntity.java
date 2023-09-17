package com.fivengers.blooming.project.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "investment_overview")
@Getter
public class InvestmentOverviewJpaEntity {

    @Id
    @OneToOne
    @JoinColumn(name = "project_id")
    private ProjectJpaEntity project;

    private String publisher;
    private String type;
    private String redemptionType;
    private String financingPurpose;
    private Long pricePerAccount;
    private Long minimumPrice;
    private Long minimumFundingAmount;
    private Long maximumFundingAmount;
    private LocalDateTime fundingStartedAt;
    private LocalDateTime fundingEndedAt;
    private LocalDateTime investmentPublishedAt;
    private LocalDateTime investmentMaturedAt;

    @Builder
    public InvestmentOverviewJpaEntity(ProjectJpaEntity project,
                                       String publisher,
                                       String type,
                                       String redemptionType,
                                       String financingPurpose,
                                       Long pricePerAccount,
                                       Long minimumPrice,
                                       Long minimumFundingAmount,
                                       Long maximumFundingAmount,
                                       LocalDateTime fundingStartedAt,
                                       LocalDateTime fundingEndedAt,
                                       LocalDateTime investmentPublishedAt,
                                       LocalDateTime investmentMaturedAt) {
        this.project = project;
        this.publisher = publisher;
        this.type = type;
        this.redemptionType = redemptionType;
        this.financingPurpose = financingPurpose;
        this.pricePerAccount = pricePerAccount;
        this.minimumPrice = minimumPrice;
        this.minimumFundingAmount = minimumFundingAmount;
        this.maximumFundingAmount = maximumFundingAmount;
        this.fundingStartedAt = fundingStartedAt;
        this.fundingEndedAt = fundingEndedAt;
        this.investmentPublishedAt = investmentPublishedAt;
        this.investmentMaturedAt = investmentMaturedAt;
    }
}
