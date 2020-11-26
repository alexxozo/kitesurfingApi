package com.kitesurfing.ab4challenge.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@Getter
@Setter
@ToString

public class Temperature {
    private double airTemp;
    private double waterTemp;
    private double averageAirTemp;
    private HashMap<String, Double> seasonal;

    public Temperature(double airTemp, double waterTemp, double averageAirTemp, HashMap<String, Double> seasonal) {
        this.airTemp = airTemp;
        this.waterTemp = waterTemp;
        this.averageAirTemp = averageAirTemp;
        this.seasonal = seasonal;
    }

    public double getAirTemp(){
        return airTemp;
    }
}
