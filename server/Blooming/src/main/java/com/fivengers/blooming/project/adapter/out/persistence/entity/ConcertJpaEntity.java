package com.fivengers.blooming.project.adapter.out.persistence.entity;


import com.fivengers.blooming.artist.adapter.out.persistence.entity.ArtistJpaEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "concert_id"))
@Table(name = "concert")
@Getter
public class ConcertJpaEntity extends ProjectJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "concert_id")
    private Long id;

    public ConcertJpaEntity() {
        super();
    }

    @Builder
    public ConcertJpaEntity(Long id,
                            String name,
                            Long fundingAmount,
                            LocalDateTime startedAt,
                            LocalDateTime endedAt,
                            String description,
                            Boolean deleted,
                            LocalDateTime createdAt,
                            LocalDateTime lastUpdated,
                            ArtistJpaEntity artist,
                            Long concert_id) {
        super(id, name, fundingAmount, startedAt, endedAt, description, deleted, createdAt, lastUpdated, artist);
        this.id = concert_id;
    }
}
