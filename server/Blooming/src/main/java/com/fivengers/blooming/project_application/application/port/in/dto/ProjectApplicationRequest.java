package com.fivengers.blooming.project_application.application.port.in.dto;

import com.fivengers.blooming.project_application.domain.ProjectApplication;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ProjectApplicationRequest(@NotNull ProjectInfoRequest projectInfo,
                                        @NotNull BasicInfoRequest basicInfo,
                                        @NotNull StoryInfoRequest storyInfo,
                                        @NotNull PolicyInfoRequest policyInfo,
                                        @NotNull SettlementInfoRequest settlementInfo) {

    public ProjectApplication toDomain() {

        return ProjectApplication.builder()
                .projectInfo(projectInfo.toDomain())
                .basicInfo(basicInfo.toDomain())
                .storyInfo(storyInfo.toDomain())
                .policyInfo(policyInfo.toDomain())
                .settlementInfo(settlementInfo.toDomain())
                .build();
    }
}
