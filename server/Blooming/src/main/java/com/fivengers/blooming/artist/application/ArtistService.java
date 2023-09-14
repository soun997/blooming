package com.fivengers.blooming.artist.application;

import com.fivengers.blooming.artist.adapter.out.persistence.ArtistPersistenceAdapter;
import com.fivengers.blooming.artist.application.port.in.ArtistUseCase;
import com.fivengers.blooming.artist.domain.Artist;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistService implements ArtistUseCase {

    private final ArtistPersistenceAdapter artistPersistenceAdapter;

    @Override
    public List<Artist> searchAll() {
        return artistPersistenceAdapter.findAll();
    }
}
