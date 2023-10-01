package com.fivengers.blooming.project_application.application.port.in.dto;

import com.fivengers.blooming.project_application.domain.ProjectApplication;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ProjectApplicationRequest(@NotNull @Valid ProjectInfoRequest projectInfo,
                                        @NotNull @Valid BasicInfoRequest basicInfo,
                                        @NotNull @Valid StoryInfoRequest storyInfo,
                                        @NotNull @Valid PolicyInfoRequest policyInfo,
                                        @NotNull @Valid SettlementInfoRequest settlementInfo) {

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
