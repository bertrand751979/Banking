package com.example.mybankapplication.models;

import java.io.Serializable;

public class Customer implements Serializable {
    private String customerName;
    private String customerSurname;
    private String customerAccountNumber;
    private Double customerAmount;

    public Customer(String customerName, String customerSurname, String customerAccountNumber, Double customerAmount) {
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerAccountNumber = customerAccountNumber;
        this.customerAmount = customerAmount;
    }

    public Customer(){}

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public void setCustomerAccountNumber(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }

    public Double getCustomerAmount() {
        return customerAmount;
    }

    public void setCustomerAmount(Double customerAmount) {
        this.customerAmount = customerAmount;
    }
}
