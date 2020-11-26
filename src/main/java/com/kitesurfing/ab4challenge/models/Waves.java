package com.kitesurfing.ab4challenge.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;

@Getter
@Setter
@ToString

public class Waves {
    private double height;
    private String direction;
    private double cleanWater;

    public Waves(double height, String direction, double cleanWater) {
        this.height = height;
        this.direction = direction;
        this.cleanWater = cleanWater;
    }

    public String getDirection() {
        return direction;
    }
}