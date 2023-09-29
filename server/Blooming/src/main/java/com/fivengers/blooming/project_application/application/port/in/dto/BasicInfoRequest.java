package com.fivengers.blooming.project_application.application.port.in.dto;

import com.fivengers.blooming.project_application.domain.BasicInfo;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Builder;

@Builder
public record BasicInfoRequest(@NotBlank String thumbnail,
                               @NotBlank @FutureOrPresent String startDate,
                               @NotBlank @Future String endDate,
                               @NotBlank @Size(max = 30) String title) {

    public BasicInfo toDomain() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return BasicInfo.builder()
                .title(title)
                .thumbnail(thumbnail)
                .startDate(LocalDateTime.parse(startDate, formatter))
                .endDate(LocalDateTime.parse(endDate, formatter))
                .build();
    }
}
