package com.user.service.services.impl;

import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.external.services.HotelService;
import com.user.service.repositories.UserRepository;
import com.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private HotelService hotelService;

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        // generate unique id;
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        // get User from db using userRepository
        User user = this.userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User with given id not found on server !!: " + userId)
                );
        // fetch rating of the above user from RATING SERVICE
        // http://localhost:8083/ratings/users/64ab56e4-5d2b-4f2f-9883-ca63c566410e

        Rating[] ratingsOfUser = this.restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("{}", (Object) ratingsOfUser);

        assert ratingsOfUser != null;
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().peek(rating -> {
            // api call to hotel service to get the hotel
            // http://localhost:8082/hotels/073326d0-7f5d-47dc-818e-829a0c948ba7
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();
//            Hotel hotel = hotelService.getHotel(rating.getHotelId());

//            com.hotel.service.entities.Hotel h = hotelService.getHotel(rating.getHotelId());
            logger.info("response status code: {}", forEntity.getStatusCode());
            // set the hotel to rating
            rating.setHotel(hotel);
            // return the rating
        }).toList();
        user.setRatings(ratingList);

        return this.userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User with given id not found on server !!: " + userId)
                );
    }

    @Override
    public String deleteUser(String userId) {
        this.userRepository.deleteById(userId);
        return "User deleted !!";
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
