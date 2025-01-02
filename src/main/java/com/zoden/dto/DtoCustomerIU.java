package com.zoden.dto;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class DtoCustomerIU {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    public String tckn;
    @NotNull
    private Date dateOfBirth;
    @NotNull
    private Long addres_id;
    @NotNull
    private Long account_id;

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

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getAddres_id() {
        return addres_id;
    }

    public void setAddres_id(Long addres_id) {
        this.addres_id = addres_id;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }
}
