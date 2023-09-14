package com.fivengers.blooming.artist.adapter.out.persistence;

import com.fivengers.blooming.global.audit.BaseTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "artist")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ArtistJpaEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Long id;

    @Column(nullable = false)
    private String stageName;

    @Column
    private String agency;

    @Column(nullable = false)
    private String description;

    public ArtistJpaEntity(String stageName, String agency, String description) {
        this.stageName = stageName;
        this.agency = agency;
        this.description = description;
    }

}
