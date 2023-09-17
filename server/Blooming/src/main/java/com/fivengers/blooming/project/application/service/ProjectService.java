package com.fivengers.blooming.project.application.service;

import com.fivengers.blooming.project.application.port.in.ConcertUseCase;
import com.fivengers.blooming.project.application.port.out.ConcertPort;
import com.fivengers.blooming.project.domain.Concert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService implements ConcertUseCase {

    private final ConcertPort concertPort;

    @Override
    public List<Concert> searchAll() {
        return concertPort.findAll();
    }
}
