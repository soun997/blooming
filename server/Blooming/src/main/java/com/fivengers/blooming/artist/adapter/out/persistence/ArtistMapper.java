package com.fivengers.blooming.artist.adapter.out.persistence;

import com.fivengers.blooming.artist.domain.Artist;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {

    Artist toDomain(ArtistJpaEntity artistJpaEntity) {
        return Artist.builder()
                .id(artistJpaEntity.getId())
                .stageName(artistJpaEntity.getStageName())
                .agency(artistJpaEntity.getAgency())
                .description(artistJpaEntity.getDescription())
                .createdAt(artistJpaEntity.getCreatedAt())
                .modifiedAt(artistJpaEntity.getModifiedAt())
                .build();
    }

    ArtistJpaEntity toJpaEntity(Artist artist) {
        return new ArtistJpaEntity(artist.getStageName(), artist.getAgency(),
                artist.getDescription());
    }

}
