package com.kitesurfing.ab4challenge.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Details {
    private double longitude;
    private double latitude;
    private String whenToGo;

    public Details() {

    }

    public Details(double longitude, double latitude, String whenToGo) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.whenToGo = whenToGo;
    }
}
