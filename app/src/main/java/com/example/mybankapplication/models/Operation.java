package com.example.mybankapplication.models;

import java.io.Serializable;

public class Operation implements Serializable {
    private String date;
    private Double amount;
    private int operationAccountNumber;
    private String choiceOperation;

    public Operation(String date, Double amount, int operationAccountNumber, String choiceOperation) {
        this.date = date;
        this.amount = amount;
        this.operationAccountNumber = operationAccountNumber;
        this.choiceOperation = choiceOperation;
    }

    public Operation(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getOperationAccountNumber() {
        return operationAccountNumber;
    }

    public void setOperationAccountNumber(int operationAccountNumber) {
        this.operationAccountNumber = operationAccountNumber;
    }

    public String getChoiceOperation() {
        return choiceOperation;
    }

    public void setChoiceOperation(String choiceOperation) {
        this.choiceOperation = choiceOperation;
    }
}
