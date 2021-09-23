package com.example.mybankapplication.models;

import java.io.Serializable;

public class Choice implements Serializable {
    private String choiceSerlected;

    public Choice(String choiceSerlected) {
        this.choiceSerlected = choiceSerlected;
    }

    public Choice(){}

    public String getChoiceSerlected() {
        return choiceSerlected;
    }

    public void setChoiceSerlected(String choiceSerlected) {
        this.choiceSerlected = choiceSerlected;
    }
    @Override
    public String toString() {
        return choiceSerlected;
    }

}
