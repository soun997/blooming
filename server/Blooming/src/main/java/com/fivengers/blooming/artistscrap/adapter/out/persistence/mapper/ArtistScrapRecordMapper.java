package com.fivengers.blooming.artistscrap.adapter.out.persistence.mapper;

import com.fivengers.blooming.artistscrap.adapter.out.persistence.entity.ArtistScrapRecordJpaEntity;
import com.fivengers.blooming.artistscrap.domain.ArtistScrapRecord;
import org.springframework.stereotype.Component;

@Component
public class ArtistScrapRecordMapper {

    public ArtistScrapRecord toDomain(ArtistScrapRecordJpaEntity artistScrapRecordJpaEntity) {
        return ArtistScrapRecord.builder()
                .id(artistScrapRecordJpaEntity.getId())
                .scrapCount(artistScrapRecordJpaEntity.getScrapCount())
                .startDateOnWeek(artistScrapRecordJpaEntity.getStartDateOnWeek())
                .endDateOnWeek(artistScrapRecordJpaEntity.getEndDateOnWeek())
                .createdAt(artistScrapRecordJpaEntity.getCreatedAt())
                .modifiedAt(artistScrapRecordJpaEntity.getModifiedAt())
                .build();
    }

    public ArtistScrapRecordJpaEntity toJpaEntity(ArtistScrapRecord artistScrapRecord) {
        return ArtistScrapRecordJpaEntity.builder()
                .id(artistScrapRecord.getId())
                .scrapCount(artistScrapRecord.getScrapCount())
                .startDateOnWeek(artistScrapRecord.getStartDateOnWeek())
                .endDateOnWeek(artistScrapRecord.getEndDateOnWeek())
                .deleted(false)
                .build();
    }
}
