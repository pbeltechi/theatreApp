package com.theatre.service.interfaces;

import com.theatre.model.Seat;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SeatService {
    public List<Seat> findAll();
}
