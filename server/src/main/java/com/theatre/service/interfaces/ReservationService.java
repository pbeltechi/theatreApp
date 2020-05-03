package com.theatre.service.interfaces;

import com.theatre.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReservationService {

    List<Reservation> findByRepresentationId(Integer id);

    void save(Reservation reservation);
}
