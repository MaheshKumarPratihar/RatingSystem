package com.rating.service.services.impl;

import com.rating.service.entities.Rating;
import com.rating.service.exceptions.RatingNotFoundException;
import com.rating.service.repositories.RatingRepository;
import com.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating createRating(Rating rating) {
        return this.ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return this.ratingRepository.findAll();
    }

    @Override
    public Rating getRating(Long id) {
        return this.ratingRepository.findById(id).orElseThrow(() -> new RatingNotFoundException("Rating doesn't exists on the server: " + id));
    }

    @Override
    public String deleteRating(Long id) {
        return null;
    }

    @Override
    public List<Rating> findByUserId(String userId) {
        return this.ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> findByHotelId(String hotelId) {
        return this.ratingRepository.findByHotelId(hotelId);
    }
}
