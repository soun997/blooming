package com.fivengers.blooming.artistscrap.application.port.out;

import com.fivengers.blooming.artistscrap.domain.ArtistScrapRecord;
import java.time.LocalDateTime;
import java.util.Optional;

public interface ArtistScrapRecordPort {

    ArtistScrapRecord save(ArtistScrapRecord artistScrapRecord);
    Optional<ArtistScrapRecord> findByStartDateAndEndData(LocalDateTime startDate,
                                                          LocalDateTime endDate);

    void update(ArtistScrapRecord artistScrapRecord);
}
