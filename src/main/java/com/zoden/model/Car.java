package com.zoden.model;

import com.zoden.enums.CarStatusType;
import com.zoden.enums.CurrencyType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Table(name = "car")
@Entity
public class Car extends BaseEntity {

    @Column(unique = true, nullable = false, name = "plate")
    private String plate;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "year")
    private Integer year;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "currency_type")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    @Column(name = "damage_price")
    private BigDecimal damagePrice;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CarStatusType status;

    public Car(String plate, String model, String brand, Integer year, BigDecimal price, CurrencyType currencyType, BigDecimal damagePrice, CarStatusType status) {
        this.plate = plate;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.currencyType = currencyType;
        this.damagePrice = damagePrice;
        this.status = status;
    }

    public Car() {}

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getDamagePrice() {
        return damagePrice;
    }

    public void setDamagePrice(BigDecimal damagePrice) {
        this.damagePrice = damagePrice;
    }

    public CarStatusType getStatus() {
        return status;
    }

    public void setStatus(CarStatusType status) {
        this.status = status;
    }
}
