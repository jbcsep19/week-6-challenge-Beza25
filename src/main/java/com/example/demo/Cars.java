package com.example.demo;

import javax.persistence.*;

@Entity
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carsID;

    private String model;
    private int year;
    private String color;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cars cars;

    public Cars() {
    }


    public long getCarsID() {
        return carsID;
    }

    public void setCarsID(long carsID) {
        this.carsID = carsID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }
}
