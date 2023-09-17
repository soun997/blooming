package com.fivengers.blooming.project.adapter.out.persistence.entity;

import com.fivengers.blooming.project.domain.Project;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "investment_goods")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InvestmentGoodsJpaEntity {

    @Id
    @OneToOne
    @JoinColumn(name = "project_id")
    private ProjectJpaEntity project;

    private String name;
    private String category;
    private String artistName;
    private String agency;

    public InvestmentGoodsJpaEntity(Project project,
                                    String name,
                                    String category,
                                    String artistName,
                                    String agency) {
        this.project = project;
        this.name = name;
        this.category = category;
        this.artistName = artistName;
        this.agency = agency;
    }
}
