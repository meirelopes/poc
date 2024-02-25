package com.meire.poc.util;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Data
public class Information {
    private String requestId;

    public String getRequestId() {

        return this.requestId = String.valueOf(UUID.randomUUID());

    }
}
