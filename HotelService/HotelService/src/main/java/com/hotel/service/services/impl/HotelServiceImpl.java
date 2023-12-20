package com.hotel.service.services.impl;

import com.hotel.service.entities.Hotel;
import com.hotel.service.exceptions.ResourceNotFoundException;
import com.hotel.service.respositories.HotelRepository;
import com.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return this.hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return this.hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return this.hotelRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hotel not found on server !! : " + id));
    }

    @Override
    public String deleteHotel(String id){
        this.hotelRepository.deleteById(id);
        return "Hotel deleted !!";
    }
}
