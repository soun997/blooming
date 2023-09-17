package com.fivengers.blooming.project.application.port.in;

import com.fivengers.blooming.project.domain.Concert;

import java.util.List;

public interface ConcertUseCase {

    List<Concert> searchAll();
}
