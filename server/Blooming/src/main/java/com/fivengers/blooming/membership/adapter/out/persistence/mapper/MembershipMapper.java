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
                .description(membershipJpaEntity.getDescription())
                .season(membershipJpaEntity.getSeason())
                .seasonStart(membershipJpaEntity.getSeasonStart())
                .seasonEnd(membershipJpaEntity.getSeasonEnd())
                .createdAt(membershipJpaEntity.getCreatedAt())
                .modifiedAt(membershipJpaEntity.getModifiedAt())
                .nft(nftMapper.toDomain(membershipJpaEntity.getNft()))
                .artist(artistMapper.toDomain(membershipJpaEntity.getArtist()))
                .build();
    }

    public MembershipJpaEntity toJpaEntity(Membership membership) {
        return MembershipJpaEntity.builder()
                .id(membership.getId())
                .description(membership.getDescription())
                .season(membership.getSeason())
                .seasonStart(membership.getSeasonStart())
                .seasonEnd(membership.getSeasonEnd())
                .deleted(false)
                .nft(nftMapper.toJpaEntity(membership.getNft()))
                .artist(artistMapper.toJpaEntity(membership.getArtist()))
                .build();
    }

}
