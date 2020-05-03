package com.theatre.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Entity
@Table(name = "representation")
public class Representation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "time", nullable = false)
    private LocalTime time;
    @Column(name = "location", nullable = false)
    private String location;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Seat> seats = new ArrayList<>();
//    @OneToMany(mappedBy = "representation")
//    private Set<Reservation> reservations = new HashSet<>();
//    @ManyToMany
//    private Set<Client> clients = new HashSet<>();


    public Representation() {
    }

    public LocalDate getDate() {
        return date;
    }


    public Representation(Integer id, String title, LocalDate date, LocalTime time, String location, List<Seat> seats) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.seats = seats;
    }

    public Representation(String title, LocalDate date, LocalTime time, String location, List<Seat> seats) {
        this.id = 0;
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Representation that = (Representation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(date, that.date) &&
                Objects.equals(time, that.time) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date, time, location);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Representation{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", seats=" + seats +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
