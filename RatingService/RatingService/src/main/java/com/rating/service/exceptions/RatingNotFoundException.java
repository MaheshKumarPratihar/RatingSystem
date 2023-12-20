package com.rating.service.exceptions;

public class RatingNotFoundException extends RuntimeException{
    public RatingNotFoundException() {
        super("Rating doesn't exists on the server !!");
    }

    public RatingNotFoundException(String message) {
        super(message);
    }
}
