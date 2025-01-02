package com.zoden.model;

import com.zoden.enums.CurrencyType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Table(name = "account")
@Entity
public class Account extends BaseEntity {

    @Column(unique = true, nullable = false, name = "account_no")
    private String accountNo;

    @Column(unique = true, nullable = false, name = "iban")
    private String iban;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency_type")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    public Account(String accountNo, String iban, BigDecimal amount, CurrencyType currencyType) {
        this.accountNo = accountNo;
        this.iban = iban;
        this.amount = amount;
        this.currencyType = currencyType;
    }

    public Account() {}

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }
}
