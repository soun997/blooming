package com.fivengers.blooming.live.adapter.out.persistence.repository;

import com.fivengers.blooming.live.adapter.out.persistence.mapper.LiveMapper;
import com.fivengers.blooming.live.application.port.out.LivePort;

import com.fivengers.blooming.live.domain.Live;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LivePersistenceAdapter implements LivePort {

    private final LiveMapper liveMapper;
    private final LiveQueryRepository liveQueryRepository;

    @Override
    public List<Live> findByKeyword(String keyword, Pageable pageable) {
        return liveQueryRepository.findActiveLiveByTitleKeyword(keyword, pageable)
                .stream().map(liveMapper::toDomain)
                .toList();
    }

    @Override
    public List<Live> findByArtistStageName(String keyword, Pageable pageable) {
        return liveQueryRepository.findActiveLiveByArtist(keyword, pageable)
                .stream().map(liveMapper::toDomain)
                .toList();
    }
}
