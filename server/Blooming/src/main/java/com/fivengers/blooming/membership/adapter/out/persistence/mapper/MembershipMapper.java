package com.fivengers.blooming.membership.adapter.out.persistence.mapper;

import com.fivengers.blooming.artist.adapter.out.persistence.mapper.ArtistMapper;
import com.fivengers.blooming.membership.adapter.out.persistence.entity.MembershipJpaEntity;
import com.fivengers.blooming.membership.domain.Membership;
import com.fivengers.blooming.nft.adapter.out.persistence.mapper.NftMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MembershipMapper {

    private final ArtistMapper artistMapper;
    private final NftMapper nftMapper;

    public Membership toDomain(MembershipJpaEntity membershipJpaEntity) {
        return Membership.builder()
                .id(membershipJpaEntity.getId())
                .title(membershipJpaEntity.getTitle())
                .description(membershipJpaEntity.getDescription())
                .season(membershipJpaEntity.getSeason())
                .seasonStart(membershipJpaEntity.getSeasonStart())
                .seasonEnd(membershipJpaEntity.getSeasonEnd())
                .purchaseStart(membershipJpaEntity.getPurchaseStart())
                .purchaseEnd(membershipJpaEntity.getPurchaseEnd())
                .thumbnailUrl(membershipJpaEntity.getThumbnailUrl())
                .createdAt(membershipJpaEntity.getCreatedAt())
                .modifiedAt(membershipJpaEntity.getModifiedAt())
                .nft(nftMapper.toDomain(membershipJpaEntity.getNft()))
                .artist(artistMapper.toDomain(membershipJpaEntity.getArtistJpaEntity()))
                .build();
    }

    public MembershipJpaEntity toJpaEntity(Membership membership) {
        return MembershipJpaEntity.builder()
                .id(membership.getId())
                .title(membership.getTitle())
                .description(membership.getDescription())
                .season(membership.getSeason())
                .seasonStart(membership.getSeasonStart())
                .seasonEnd(membership.getSeasonEnd())
                .purchaseStart(membership.getPurchaseStart())
                .purchaseEnd(membership.getPurchaseEnd())
                .thumbnailUrl(membership.getThumbnailUrl())
                .deleted(false)
                .nft(nftMapper.toJpaEntity(membership.getNft()))
                .artistJpaEntity(artistMapper.toJpaEntity(membership.getArtist()))
                .build();
    }
}
