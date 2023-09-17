package com.fivengers.blooming.project.domain;

import lombok.Getter;

@Getter
public class InvestmentGoods {

    private Project project;

    private String name;
    private String category;
    private String artistName;
    private String agency;

    public InvestmentGoods(Project project,
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
