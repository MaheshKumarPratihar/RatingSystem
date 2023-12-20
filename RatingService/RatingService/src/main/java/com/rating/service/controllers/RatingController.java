package com.rating.service.controllers;

import com.rating.service.entities.Rating;
import com.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;
    // create
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.ratingService.createRating(rating));
    }

    // getAll
    @GetMapping
    public ResponseEntity< List<Rating>> getAllRatings(){
      return ResponseEntity.ok(this.ratingService.getAllRatings());
    }

    // getAllRatingBy userId
    @GetMapping("/users/{userId}")
    public ResponseEntity< List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(this.ratingService.findByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity< List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(this.ratingService.findByHotelId(hotelId));
    }

    // getSingleRating
    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRating(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(this.ratingService.getRating(id));
    }

    // delete
    @DeleteMapping // http://localhost:8083/ratings?id=1
    public ResponseEntity<String> deleteRating(@RequestParam Long id){
        return ResponseEntity.ok(this.ratingService.deleteRating(id));
    }
}
