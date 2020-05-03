package com.theatre.controller;

import com.theatre.model.Representation;
import com.theatre.model.Reservation;
import com.theatre.model.SeatDTO;
import com.theatre.service.RepresentationServiceImpl;
import com.theatre.service.interfaces.RepresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/representation")
public class RepresentationController {

    @Autowired
    RepresentationService representationService;

    @GetMapping("/title")
    public List<Representation> representationsByTitle(@RequestParam(value = "name", defaultValue = "hamlet") String name) {
        return this.representationService.findByTitle(name);
    }

    @GetMapping("/")
    public List<Representation> representations() {
        return this.representationService.findAll();
    }

    @GetMapping("/date")
    public List<Representation> representationsByDate(@RequestParam("date") String stringDate) {
        LocalDate localDate = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return this.representationService.findByDate(localDate);
    }

    @GetMapping("/room")
    public List<SeatDTO> roomConfiguration(@RequestParam("id") Integer representationId) {
        return this.representationService.getRoomConfiguration(representationId);
    }
}
