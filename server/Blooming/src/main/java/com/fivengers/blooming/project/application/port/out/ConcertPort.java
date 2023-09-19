package com.fivengers.blooming.project.application.port.out;


import com.fivengers.blooming.project.domain.Concert;

import java.util.List;

public interface ConcertPort {

    List<Concert> findAll();
    List<Concert> findAllOngoingProject();
}
