package com.theatre.controller;

import com.theatre.model.Admin;
import com.theatre.model.Representation;
import com.theatre.model.Reservation;
import com.theatre.model.SeatDTO;
import com.theatre.service.RepresentationServiceImpl;
import com.theatre.service.interfaces.AdminService;
import com.theatre.service.interfaces.RepresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/")
    public ResponseEntity<?> login(@RequestBody Admin admin) {
        System.out.println("-- Login request from " + admin);
        Optional<Admin> found = adminService.login(admin.getUsername(),admin.getPassword());
        if(found.isEmpty()){
            return new ResponseEntity<>("Entity not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(found.get(),HttpStatus.OK);
    }
}
