package com.theatre.service;

import com.theatre.model.Client;
import com.theatre.model.Reservation;
import com.theatre.repository.ClientRepository;
import com.theatre.repository.ReservationRepository;
import com.theatre.service.interfaces.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Reservation> findByRepresentationId(Integer id) {
        return this.reservationRepository.findByRepresentationId(id);
    }

    @Override
    public void save(Reservation reservation) {
        Optional<Client> client = clientRepository.findByFirstNameAndLastName(reservation.getClient().getFirstName(),
                reservation.getClient().getLastName());
        client.ifPresent(reservation::setClient);
        if(client.isEmpty()){
            Client clientSaved = this.clientRepository.save(reservation.getClient());
            reservation.setClient(clientSaved);
        }
        this.reservationRepository.save(reservation);
    }
}
