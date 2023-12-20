package com.hotel.service.controllers;

import com.hotel.service.entities.Hotel;
import com.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody  Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.hotelService.createHotel(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(this.hotelService.getHotelById(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return ResponseEntity.ok(this.hotelService.getAllHotel());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteHotel(@RequestParam String id){
        return ResponseEntity.ok(this.hotelService.deleteHotel(id));
    }

}
