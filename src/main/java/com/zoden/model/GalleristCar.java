package com.zoden.model;

import jakarta.persistence.*;

@Table(
        name = "gallerist_car",
        uniqueConstraints = {@UniqueConstraint(
                        columnNames = {"gallerist_id", "car_id"},
                        name = "uc_gallerist_car"
        )})
@Entity
public class GalleristCar extends BaseEntity {

    @ManyToOne
    private Gallerist gallerist;

    @ManyToOne
    private Car car;

    public GalleristCar(Gallerist gallerist, Car car) {
        this.gallerist = gallerist;
        this.car = car;
    }

    public GalleristCar() {
    }

    public Gallerist getGallerist() {
        return gallerist;
    }

    public void setGallerist(Gallerist gallerist) {
        this.gallerist = gallerist;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
