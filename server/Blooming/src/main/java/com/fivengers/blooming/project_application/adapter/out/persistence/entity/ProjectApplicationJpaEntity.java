package com.fivengers.blooming.project_application.adapter.out.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project_application")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectApplicationJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_application_id")
    private Long id;

    @Embedded
    private ProjectInfoInJpaEntity projectInfo;
    @Embedded
    private BasicInfoInJpaEntity basicInfo;
    @Embedded
    private StoryInfoInJpaEntity storyInfo;
    @Embedded
    private SettlementInfoInJpaEntity settlementInfo;
    @Embedded
    private PolicyInfoJpaEntity policyInfo;

    @Builder
    public ProjectApplicationJpaEntity(Long id, ProjectInfoInJpaEntity projectInfo,
            BasicInfoInJpaEntity basicInfo, StoryInfoInJpaEntity storyInfo,
            SettlementInfoInJpaEntity settlementInfo, PolicyInfoJpaEntity policyInfo) {
        this.id = id;
        this.projectInfo = projectInfo;
        this.basicInfo = basicInfo;
        this.storyInfo = storyInfo;
        this.settlementInfo = settlementInfo;
        this.policyInfo = policyInfo;
    }
}
