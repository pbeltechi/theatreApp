package com.theatre.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="representation_id", nullable=false)
    private Representation representation;
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="client_id", nullable=false)
    private Client client;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Seat> seats = new ArrayList<>();

    public Reservation() {
    }

    public Reservation(Integer id, Representation representation, Client client, List<Seat> seat) {
        this.id = id;
        this.representation = representation;
        this.client = client;
        this.seats = seat;
    }

    public Reservation(Representation representation, Client client, List<Seat> seat) {
        this.id = 0;
        this.representation = representation;
        this.client = client;
        this.seats = seat;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", representation=" + representation +
                ", client=" + client +
                ", seats=" + seats +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Representation getRepresentation() {
        return representation;
    }

    public void setRepresentation(Representation representation) {
        this.representation = representation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seat) {
        this.seats = seat;
    }
}
