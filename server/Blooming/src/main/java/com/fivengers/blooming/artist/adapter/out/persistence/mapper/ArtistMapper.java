package com.fivengers.blooming.artist.adapter.out.persistence.mapper;

import com.fivengers.blooming.artist.adapter.out.persistence.entity.ArtistJpaEntity;
import com.fivengers.blooming.artist.domain.Artist;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {

    public Artist toDomain(ArtistJpaEntity artistJpaEntity) {
        return Artist.builder()
                .id(artistJpaEntity.getId())
                .stageName(artistJpaEntity.getStageName())
                .agency(artistJpaEntity.getAgency())
                .description(artistJpaEntity.getDescription())
                .createdAt(artistJpaEntity.getCreatedAt())
                .modifiedAt(artistJpaEntity.getModifiedAt())
                .build();
    }

    public ArtistJpaEntity toJpaEntity(Artist artist) {
        return new ArtistJpaEntity(artist.getStageName(), artist.getAgency(),
                artist.getDescription());
    }

}
