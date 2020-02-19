package com.parking.dto;

import java.util.Objects;

import com.parking.enums.ParkingTypes.ParkingTypes;

public class Parking {
    private int id;
    private String name;
    private ParkingTypes type;
    private double pricePerMinute;

    public Parking(int id) {
        this.id = id;
    }

    public Parking(String name, ParkingTypes type, double pricePerMinute) {
        this.name = name;
        this.type = type;
        this.pricePerMinute = pricePerMinute;
    }

    public Parking(int id, String name, ParkingTypes type, double pricePerMinute) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pricePerMinute = pricePerMinute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParkingTypes getType() {
        return type;
    }

    public void setType(ParkingTypes type) {
        this.type = type;
    }

    public double getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(double pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parking)) return false;
        Parking kart = (Parking) o;
        return id == kart.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", pricePerMinute=" + pricePerMinute +
                '}';
    }
}
