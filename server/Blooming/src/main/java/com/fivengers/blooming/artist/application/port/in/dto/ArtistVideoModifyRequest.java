package com.fivengers.blooming.artist.application.port.in.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ArtistVideoModifyRequest(@NotNull Long id,
                                       @NotBlank String videoUrl) {

}
