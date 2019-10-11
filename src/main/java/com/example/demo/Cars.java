package com.example.demo;

import javax.persistence.*;

@Entity
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carsID;

    private String make;
    private String year;
    private String color;

    @ManyToOne()
    private Category category;

    public Cars() {
    }


    public long getCarsID() {
        return carsID;
    }

    public void setCarsID(long carsID) {
        this.carsID = carsID;
    }




    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
