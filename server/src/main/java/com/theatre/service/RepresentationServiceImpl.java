package com.theatre.service;

import com.theatre.model.Representation;
import com.theatre.model.Reservation;
import com.theatre.model.Seat;
import com.theatre.model.SeatDTO;
import com.theatre.repository.ClientRepository;
import com.theatre.repository.RepresentationRepository;
import com.theatre.repository.ReservationRepository;
import com.theatre.repository.SeatRepository;
import com.theatre.service.interfaces.RepresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RepresentationServiceImpl implements RepresentationService {

    @Autowired
    RepresentationRepository representationRepository;
    @Autowired
    SeatRepository seatRepository;
//    @Autowired
//    ClientRepository clientRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public List<Representation> findAll() {
        return this.representationRepository.findAll();
    }

    @Override
    public List<Representation> findByTitle(String title) {
        return this.representationRepository.findByTitle(title);
    }

    @Override
    public List<Representation> findByDate(LocalDate localDate) {
        return this.representationRepository.findByDate(localDate);
    }

    @Override
    public List<SeatDTO> getRoomConfiguration(Integer representationId) {
        Optional<Representation> representation = this.representationRepository.findById(representationId);
        if (!representation.isPresent()) {
            return new ArrayList<>();
        }
        List<SeatDTO> seatsDTO = new ArrayList<>();
        List<Reservation> reservations = reservationRepository.findByRepresentationId(representationId);
        for (Seat seat1 : representation.get().getSeats()) {
            Boolean reserved = false;
            for (Reservation reservation: reservations) {
                for (Seat seat2:reservation.getSeats()) {
                    if (seat1 == seat2){
                        reserved = true;
                        break;
                    }
                }
            }
            SeatDTO seatDTO = new SeatDTO(seat1.getId(),seat1.getRow(),
                    seat1.getLodge(),seat1.getSeatNumber(),seat1.getPrice(),reserved);
            seatsDTO.add(seatDTO);
        }
        return seatsDTO;
    }

    @Override
    public void save(Representation representation) throws Exception {
        Optional<Representation> found = this.representationRepository.findById(representation.getId());
        if(found.isPresent()){
            throw new Exception("entity already exists");
        }
        List<Seat> seats = this.seatRepository.findAll();
        representation.setSeats(seats);
        this.representationRepository.save(representation);
    }

    @Override
    public void update(Representation representation) throws Exception {
        Optional<Representation> found = this.representationRepository.findById(representation.getId());
        if(found.isEmpty()){
            throw new Exception("entity does not exist");
        }
        List<Seat> seats = this.seatRepository.findAll();
        representation.setSeats(seats);
        this.representationRepository.save(representation);
    }

    @Override
    public void delete(Integer id) throws Exception {
        Optional<Representation> found = this.representationRepository.findById(id);
        if(found.isEmpty()){
            throw new Exception("entity does not exist");
        }
        this.representationRepository.deleteById(id);
    }

}
