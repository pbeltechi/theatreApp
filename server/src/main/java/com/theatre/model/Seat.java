package com.theatre.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "row", nullable = false)
    private Integer row;
    @Column(name = "lodge", nullable = false)
    private String lodge;
    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;
    @Column(name = "price", nullable = false)
    private Double price;
//    @ManyToMany(mappedBy = "seats")
//    Set<Reservation> reservations = new HashSet<>();
//    @ManyToMany(mappedBy = "seats")
//    Set<Representation> representations = new HashSet<>();

    public Seat() {

    }



    public Seat(Integer id, Integer row, String lodge, Integer seatNumber, Double price) {
        this.id = id;
        this.row = row;
        this.lodge = lodge;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public Seat(Integer row, String lodge, Integer seatNumber, Double price) {
        this.id = 0;
        this.row = row;
        this.lodge = lodge;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", row=" + row +
                ", lodge='" + lodge + '\'' +
                ", seatNumber=" + seatNumber +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(id, seat.id) &&
                Objects.equals(row, seat.row) &&
                Objects.equals(lodge, seat.lodge) &&
                Objects.equals(seatNumber, seat.seatNumber) &&
                Objects.equals(price, seat.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, row, lodge, seatNumber, price);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public String getLodge() {
        return lodge;
    }

    public void setLodge(String lodge) {
        this.lodge = lodge;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
