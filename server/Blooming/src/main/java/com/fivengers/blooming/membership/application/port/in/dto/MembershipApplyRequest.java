package com.fivengers.blooming.membership.application.port.in.dto;

import com.fivengers.blooming.artist.domain.Artist;
import com.fivengers.blooming.membership.domain.MembershipApplication;
import com.fivengers.blooming.membership.domain.MembershipApplicationState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record MembershipApplyRequest(@NotBlank String title,
                                     @NotNull String description,
                                     @NotNull LocalDateTime seasonStart,
                                     @NotNull LocalDateTime seasonEnd,
                                     @NotNull LocalDateTime purchaseStart,
                                     @NotNull LocalDateTime purchaseEnd,
                                     @NotNull Long saleCount,
                                     @NotNull Long salePrice,
                                     @NotBlank String imageUrl) {

    public MembershipApplication toDomain(int season, Artist artist) {
        return MembershipApplication.builder()
                .title(title)
                .description(description)
                .season(season)
                .seasonStart(seasonStart)
                .seasonEnd(seasonEnd)
                .purchaseStart(purchaseStart)
                .purchaseEnd(purchaseEnd)
                .saleCount(saleCount)
                .salePrice(salePrice)
                .imageUrl(imageUrl)
                .applicationState(MembershipApplicationState.APPLY)
                .artist(artist)
                .build();
    }
}
