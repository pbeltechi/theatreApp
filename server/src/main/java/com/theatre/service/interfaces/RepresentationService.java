package com.theatre.service.interfaces;

import com.theatre.model.Representation;
import com.theatre.model.Seat;
import com.theatre.model.SeatDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface RepresentationService {

    public List<Representation> findAll();


    public List<Representation> findByTitle(String title);

    public List<Representation> findByDate(LocalDate localDate);

    public List<SeatDTO> getRoomConfiguration(Integer representationId);
}
