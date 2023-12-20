package com.hotel.service.services;

import com.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    // create
    Hotel createHotel(Hotel hotel);

    // getAll
    List<Hotel> getAllHotel();

    // getSingle
    Hotel getHotelById(String id);

    // delete Hotel
    String deleteHotel(String id);
}
