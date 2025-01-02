package com.zoden.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Table(
        name = "sold_car",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"gallerist_id", "car_id", "customer_id"},
                name = "uc_gallerist_car_customer"
        )})
@Entity
public class SoldCar extends BaseEntity {

    @ManyToOne
    private Gallerist gallerist;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;

}
