package com.zoden.dto;

import jakarta.validation.constraints.NotNull;

public class DtoGalleristIU {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Long address_id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }
}
