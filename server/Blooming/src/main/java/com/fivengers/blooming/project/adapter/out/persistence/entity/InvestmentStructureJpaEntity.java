package com.fivengers.blooming.project.adapter.out.persistence.entity;


import com.fivengers.blooming.project.domain.Project;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class InvestmentStructureJpaEntity {

    @Id
    @OneToOne
    @JoinColumn(name = "project_id")
    private ProjectJpaEntity project;

    private Long totalAmount;
    private Long customerTransaction;
    private Integer dividendRatio;

    @Builder
    public InvestmentStructureJpaEntity(Project project,
                                        Long totalAmount,
                                        Long customerTransaction,
                                        Integer dividendRatio) {
        this.project = project;
        this.totalAmount = totalAmount;
        this.customerTransaction = customerTransaction;
        this.dividendRatio = dividendRatio;
    }
}
