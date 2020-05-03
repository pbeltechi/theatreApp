package com.theatre.controller;

import com.theatre.model.Seat;
import com.theatre.service.interfaces.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/seat")
public class SeatController {
    @Autowired
    SeatService seatService;

    @GetMapping("/")
    public List<Seat> seats() {
        return this.seatService.findAll();
    }

}
