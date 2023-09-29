package com.fivengers.blooming.project_application.application.port.in.dto;

import com.fivengers.blooming.payment.domain.ProjectType;
import com.fivengers.blooming.project_application.domain.ProjectInfo;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProjectInfoRequest(@NotBlank String category,
                                 @NotNull MakerInfoRequest makerInfo,
                                 @NotNull
                                 @Size(min = 500_000, max = 100_000_000)
                                 Long targetAmount) {

    public ProjectInfo toDomain() {
        return new ProjectInfo(
                ProjectType.from(category),
                makerInfo.toDomain(),
                targetAmount);
    }
}
