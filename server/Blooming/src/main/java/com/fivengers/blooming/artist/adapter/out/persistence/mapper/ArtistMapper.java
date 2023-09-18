package com.fivengers.blooming.artist.adapter.out.persistence.mapper;


import com.fivengers.blooming.artist.adapter.out.persistence.entity.ArtistJpaEntity;
import com.fivengers.blooming.artist.domain.Artist;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {

    public Artist toDomain(ArtistJpaEntity artistJpaEntity) {
        return new Artist();
    }

    public ArtistJpaEntity toJpaEntity(Artist artist) {
        return new ArtistJpaEntity();
    }
}
