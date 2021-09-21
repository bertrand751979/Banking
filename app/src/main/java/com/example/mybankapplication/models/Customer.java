package com.example.mybankapplication.models;

import java.io.Serializable;

public class Customer implements Serializable {
    private String customerName;
    private String customerSurname;
    private String customerAccountNumber;

    public Customer(String customerName, String customerSurname, String customerAccountNumber) {
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerAccountNumber = customerAccountNumber;
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


}
