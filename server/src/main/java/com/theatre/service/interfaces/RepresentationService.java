package com.theatre.service.interfaces;

import com.theatre.model.Representation;
import com.theatre.model.Seat;
import com.theatre.model.SeatDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface RepresentationService {

    List<Representation> findAll();

    List<Representation> findByTitle(String title);

    List<Representation> findByDate(LocalDate localDate);

    List<SeatDTO> getRoomConfiguration(Integer representationId);

    void save(Representation representation) throws Exception;

    void update(Representation representation) throws Exception;

    void delete(Integer id) throws Exception;
}
