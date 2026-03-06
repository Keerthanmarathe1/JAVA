package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private int mileage;
    private String rideType;   // CITY / VILLAGE / HIGHWAY
    private int suitableDailyKm;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getMileage() { return mileage; }
    public void setMileage(int mileage) { this.mileage = mileage; }

    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }

    public int getSuitableDailyKm() { return suitableDailyKm; }
    public void setSuitableDailyKm(int suitableDailyKm) { this.suitableDailyKm = suitableDailyKm; }
}