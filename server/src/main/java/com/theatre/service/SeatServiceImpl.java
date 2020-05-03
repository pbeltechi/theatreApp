package com.theatre.service;

import com.theatre.model.Seat;
import com.theatre.repository.SeatRepository;
import com.theatre.service.interfaces.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    SeatRepository seatRepository;

    @Override
    public List<Seat> findAll() {
        return this.seatRepository.findAll();
    }
}
