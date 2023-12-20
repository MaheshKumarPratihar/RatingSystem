package com.hotel.service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import java.util.Arrays;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @GetMapping
    public ResponseEntity<List<String>> getStaffs(){
        List<String> staffs = Arrays.asList("Mahesh", "Sonu", "Ankit", "Anu", "Manisha", "Khushi");
        return ResponseEntity.status(HttpStatus.FOUND).body(staffs);
    }
}
