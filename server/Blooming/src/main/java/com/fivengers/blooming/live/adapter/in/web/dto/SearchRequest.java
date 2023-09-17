package com.fivengers.blooming.live.adapter.in.web.dto;

import com.fivengers.blooming.live.domain.Live;
import lombok.Builder;

@Builder
public record SearchRequest(String query,
                            int page,
                            int size,
                            String sort) {

}
