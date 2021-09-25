package com.example.mybankapplication.models;

import java.io.Serializable;

public class Solde implements Serializable {
    private String soldeCustomerNumber;
    private Double soldeOperation;

    public Solde(String soldeCustomerNumber, Double soldeOperation) {
        this.soldeCustomerNumber = soldeCustomerNumber;
        this.soldeOperation = soldeOperation;
    }

    public Solde(){}

    public String getSoldeCustomerNumber() {
        return soldeCustomerNumber;
    }

    public void setSoldeCustomerNumber(String soldeCustomerNumber) {
        this.soldeCustomerNumber = soldeCustomerNumber;
    }

    public Double getSoldeOperation() {
        return soldeOperation;
    }

    public void setSoldeOperation(Double soldeOperation) {
        this.soldeOperation = soldeOperation;
    }
}
