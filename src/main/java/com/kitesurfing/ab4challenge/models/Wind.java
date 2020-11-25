package com.kitesurfing.ab4challenge.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@Getter
@Setter
@ToString

public class Wind {
    private double averageSpeed;
    private String direction;
    private double gusts;


    public Wind(double averageSpeed, String direction, double gusts) {
        this.averageSpeed = averageSpeed;
        this.direction = direction;
        this.gusts = gusts;
    }

    public String getDirection() {
        return direction;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }
}
