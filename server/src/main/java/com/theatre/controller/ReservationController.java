package com.theatre.controller;

import com.theatre.model.Representation;
import com.theatre.model.Reservation;
import com.theatre.service.interfaces.RepresentationService;
import com.theatre.service.interfaces.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping("/representation")
    public List<Reservation> reservationsByRepresentationId(@RequestParam("id") Integer id) {
        return this.reservationService.findByRepresentationId(id);
    }
    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    void save(@RequestBody Reservation reservation) {
        this.reservationService.save(reservation);
    }
}
