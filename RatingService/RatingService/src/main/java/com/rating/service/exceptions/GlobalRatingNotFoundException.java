package com.rating.service.exceptions;

import org.hibernate.type.descriptor.java.ObjectJavaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalRatingNotFoundException {

    @ExceptionHandler(RatingNotFoundException.class)
    public ResponseEntity<Map<String, Object>> exceptionHandler(RatingNotFoundException ratingNotFoundException){
        Map<String, Object> response = new HashMap<>();
        response.put("message", ratingNotFoundException.getMessage());
        response.put("success", false);
        response.put("status", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
