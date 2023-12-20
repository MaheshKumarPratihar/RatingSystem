package com.rating.service.services;

import com.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {

    // create
    Rating createRating(Rating rating);

    // get All
    List<Rating> getAllRatings();

    // get Single
    Rating getRating(Long id);

    // delete
    String deleteRating(Long id);

    // find by userId
    List<Rating> findByUserId(String userId);

    // find by hotelId
    List<Rating> findByHotelId(String hotelId);
}
