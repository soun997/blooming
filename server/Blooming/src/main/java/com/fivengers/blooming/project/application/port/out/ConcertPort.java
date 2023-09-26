package com.fivengers.blooming.project.application.port.out;


import com.fivengers.blooming.artist.domain.Artist;
import com.fivengers.blooming.project.domain.Activity;
import com.fivengers.blooming.project.domain.Concert;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConcertPort {

    Page<Concert> findAll(Pageable pageable);
    Page<Concert> findAll(Pageable pageable, List<Concert> exclusions);
    Page<Concert> findAllOngoingProject(Pageable pageable);
    Page<Concert> findAllOngoingProject(Pageable pageable, List<Concert> exclusions);
    List<Concert> findAllFinishedProjectByArtist(Long artistId, Pageable pageable);
    Concert findById(Long id);
    Page<Concert> findAllByLikeKeyword(String keyword, Pageable pageable);
    Page<Concert> findAllByLikeArtist(String artist, Pageable pageable);
}
