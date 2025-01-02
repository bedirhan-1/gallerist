package com.zoden.dto;
import java.util.Date;

public class DtoCustomer extends BaseDto {
    private String firstName;
    private String lastName;
    public String tckn;
    private Date dateOfBirth;
    private DtoAddress dtoAddress;
    private DtoAccount dtoAccount;

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

    public DtoAddress getDtoAddress() {
        return dtoAddress;
    }

    public void setDtoAddress(DtoAddress dtoAddress) {
        this.dtoAddress = dtoAddress;
    }

    public DtoAccount getDtoAccount() {
        return dtoAccount;
    }

    public void setDtoAccount(DtoAccount dtoAccount) {
        this.dtoAccount = dtoAccount;
    }
}
