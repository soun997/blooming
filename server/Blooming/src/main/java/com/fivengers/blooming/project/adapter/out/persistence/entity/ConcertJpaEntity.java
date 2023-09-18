package com.fivengers.blooming.project.adapter.out.persistence.entity;


import com.fivengers.blooming.artist.adapter.out.persistence.entity.ArtistJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "concert")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertJpaEntity extends ProjectJpaEntity {

    @Builder
    public ConcertJpaEntity(Long id,
            String name,
            Long fundingAmount,
            LocalDateTime startedAt,
            LocalDateTime endedAt,
            String description,
            Boolean deleted,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt,
            ArtistJpaEntity artist) {
        super(id, name, fundingAmount, startedAt, endedAt, description, deleted, createdAt,
                modifiedAt, artist);
    }
}
