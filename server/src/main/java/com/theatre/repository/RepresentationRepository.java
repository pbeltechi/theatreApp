package com.theatre.repository;

import com.theatre.model.Representation;
import com.theatre.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RepresentationRepository extends JpaRepository<Representation, Integer> {
    List<Representation> findByTitle(String title);

    List<Representation> findByDate(LocalDate date);
}
