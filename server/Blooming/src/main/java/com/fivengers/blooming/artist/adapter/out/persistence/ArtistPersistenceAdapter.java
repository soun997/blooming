package com.fivengers.blooming.artist.adapter.out.persistence;

import com.fivengers.blooming.artist.application.port.out.ArtistPort;
import com.fivengers.blooming.artist.domain.Artist;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArtistPersistenceAdapter implements ArtistPort {

    private final ArtistMapper artistMapper;
    private final ArtistSpringDataRepository artistSpringDataRepository;

    @Override
    public List<Artist> findAll() {
        return artistSpringDataRepository.findAll().stream()
                .map(artistMapper::toDomain)
                .toList();
    }

}
