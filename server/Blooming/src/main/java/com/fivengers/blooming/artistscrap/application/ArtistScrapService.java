package com.fivengers.blooming.artistscrap.application;

import com.fivengers.blooming.artist.application.port.out.ArtistPort;
import com.fivengers.blooming.artistscrap.application.port.in.ArtistScrapUseCase;
import com.fivengers.blooming.artistscrap.application.port.in.dto.ArtistScrapRequest;
import com.fivengers.blooming.artistscrap.application.port.out.ArtistScrapPort;
import com.fivengers.blooming.artistscrap.domain.ArtistScrap;
import com.fivengers.blooming.member.application.port.out.MemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistScrapService implements ArtistScrapUseCase {

    private final ArtistScrapPort artistScrapPort;
    private final MemberPort memberPort;
    private final ArtistPort artistPort;

    @Override
    public void scrap(ArtistScrapRequest request, Long artistId) {
        artistScrapPort.saveScrap(new ArtistScrap(null,
                memberPort.findById(request.memberId()),
                artistPort.findById(artistId)));
    }

    @Override
    public void unScrap(ArtistScrapRequest request, Long artistId) {
        artistScrapPort.deleteScrap(request.memberId(), artistId);
    }
}
