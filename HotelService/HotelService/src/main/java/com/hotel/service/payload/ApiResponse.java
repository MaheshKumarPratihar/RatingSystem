package com.hotel.service.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;

}
