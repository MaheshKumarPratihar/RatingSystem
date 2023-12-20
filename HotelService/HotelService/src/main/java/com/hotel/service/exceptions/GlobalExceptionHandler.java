package com.hotel.service.exceptions;

import com.hotel.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
//        ApiResponse apiResponse = ApiResponse.builder()
//                .message(resourceNotFoundException.getMessage())
//                .success(true)
//                .status(HttpStatus.NOT_FOUND)
//                .build();
//
//        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        Map<String, Object> map = new HashMap<>();
        map.put("message", resourceNotFoundException.getMessage());
        map.put("success", true);
        map.put("status",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

}
