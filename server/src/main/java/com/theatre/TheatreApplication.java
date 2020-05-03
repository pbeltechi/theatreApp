package com.theatre;

import com.theatre.model.Client;
import com.theatre.model.Representation;
import com.theatre.model.Reservation;
import com.theatre.model.Seat;
import com.theatre.repository.ClientRepository;
import com.theatre.repository.RepresentationRepository;
import com.theatre.repository.ReservationRepository;
import com.theatre.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class TheatreApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheatreApplication.class, args);
    }

}



/***
 * add representations and seats
 * */
/*

        ApplicationContext context = SpringApplication.run(TheatreApplication.class, args);

        RepresentationRepository representationRepository = context.getBean(RepresentationRepository.class);
        SeatRepository seatRepository = context.getBean(SeatRepository.class);

        Seat seat1 = new Seat(1, "l2", 1, 21.0);
        Seat seat2 = new Seat(1, "l2", 2, 21.0);
        Seat seat3 = new Seat(1, "l2", 3, 21.0);
        Seat seat4 = new Seat(1, "l2", 4, 21.0);
        Seat seat5 = new Seat(2, "l2", 1, 20.0);
        seat1 = seatRepository.save(seat1);
        seat2 = seatRepository.save(seat2);
        seat3 = seatRepository.save(seat3);
        seat4 = seatRepository.save(seat4);
        seat5 = seatRepository.save(seat5);
        List<Seat> seats = new ArrayList<>();
        seats.add(seat1);
        seats.add(seat2);
        seats.add(seat3);
        seats.add(seat4);
        seats.add(seat5);
        Representation representation = new Representation("Twelve Angry Men",
                LocalDate.of(2020, 5, 20),LocalTime.of(19,0),
                "Cluj-Napoca, Str. Avram Iancu nr. 50", seats);

        Representation representation2 = new Representation("Hamlet",
                LocalDate.of(2020, 6, 20),LocalTime.of(19,0),
                "Cluj-Napoca, Str. Avram Iancu nr. 50", seats);

        Representation representation3 = new Representation("The Idiot",
                LocalDate.of(2020, 5, 12),LocalTime.of(19,0),
                "Cluj-Napoca, Str. Avram Iancu nr. 50", seats);

        Representation representation4 = new Representation("Crime and Punishment",
                LocalDate.of(2020, 5, 19),LocalTime.of(19,0),
                "Cluj-Napoca, Str. Avram Iancu nr. 50", seats);

        Representation representation5 = new Representation("Woyzeck",
                LocalDate.of(2020, 5, 13),LocalTime.of(19,0),
                "Cluj-Napoca, Str. Avram Iancu nr. 50", seats);

        Representation representation6 = new Representation("Death of a Salesman",
                LocalDate.of(2020, 6, 14),LocalTime.of(19,0),
                "Cluj-Napoca, Str. Avram Iancu nr. 50", seats);
        representation = representationRepository.save(representation);
        representation2 = representationRepository.save(representation2);
        representation3 = representationRepository.save(representation3);
        representation4 = representationRepository.save(representation4);
        representation5 = representationRepository.save(representation5);
        representation6 = representationRepository.save(representation6);
*/

/**
 * Add clients and reservations
 * */

/*
ApplicationContext context = SpringApplication.run(TheatreApplication.class, args);
        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        ReservationRepository reservationRepository = context.getBean(ReservationRepository.class);
        Client client = new Client("Paul","Beltechi");
        Client client2 = new Client("Silviu","Anton");
//        clientRepository.save(client);
//        clientRepository.save(client2);
        client = clientRepository.findById(1).get();

        RepresentationRepository representationRepository = context.getBean(RepresentationRepository.class);
        Representation representation = representationRepository.findById(1).get();
        List<Seat> all = representation.getSeats();
        List<Seat> seats = new ArrayList<>();
        seats.add(representation.getSeats().get(0));
        seats.add(representation.getSeats().get(1));
        Reservation reservation = new Reservation(representation,client,seats);
//        reservationRepository.save(reservation);

*/