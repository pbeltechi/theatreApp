package com.theatre.model;

import javax.persistence.Column;
import java.util.Objects;

public class SeatDTO {
    private Integer id;
    private Integer row;
    private String lodge;
    private Integer seatNumber;
    private Double price;
    private Boolean reserved;

    public SeatDTO(Integer id, Integer row, String lodge, Integer seatNumber, Double price, Boolean reserved) {
        this.id = id;
        this.row = row;
        this.lodge = lodge;
        this.seatNumber = seatNumber;
        this.price = price;
        this.reserved = reserved;
    }



    @Override
    public String toString() {
        return "SeatDTO{" +
                "id=" + id +
                ", row=" + row +
                ", lodge='" + lodge + '\'' +
                ", seatNumber=" + seatNumber +
                ", price=" + price +
                ", reserved=" + reserved +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatDTO seatDTO = (SeatDTO) o;
        return Objects.equals(id, seatDTO.id) &&
                Objects.equals(row, seatDTO.row) &&
                Objects.equals(lodge, seatDTO.lodge) &&
                Objects.equals(seatNumber, seatDTO.seatNumber) &&
                Objects.equals(price, seatDTO.price) &&
                Objects.equals(reserved, seatDTO.reserved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, row, lodge, seatNumber, price, reserved);
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

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }
}
