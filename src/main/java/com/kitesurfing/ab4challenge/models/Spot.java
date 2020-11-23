package com.kitesurfing.ab4challenge.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "kitesurfing")
public class Spot {
    @Id
    private String _id;
    private String name;
    private String country;
    private String locationCatalonianCoast;
    private String shortDescription;
    private int mainWindKts;
    private String mainWindDir;
    private String[] airTemp;
    private String prefWind;
    private String windProbability;
    private String averageAirTemp;
    private String[] waterTemp;
    private String waveHeightMeter;
    private String waveDirection;
    private String cleanWater;
    private String whenToGo;
    private String[] imageUrls;
    private double longitude;
    private double latitude;

    public Spot() {}

    public Spot(String _id, String name, String country, String locationCatalonianCoast, String shortDescription, int mainWindKts, String mainWindDir, String[] airTemp, String prefWind, String windProbability, String averageAirTemp, String[] waterTemp, String waveHeightMeter, String waveDirection, String cleanWater, String whenToGo, String[] imageUrls, double longitude, double latitude) {
        this._id = _id;
        this.name = name;
        this.country = country;
        this.locationCatalonianCoast = locationCatalonianCoast;
        this.shortDescription = shortDescription;
        this.mainWindKts = mainWindKts;
        this.mainWindDir = mainWindDir;
        this.airTemp = airTemp;
        this.prefWind = prefWind;
        this.windProbability = windProbability;
        this.averageAirTemp = averageAirTemp;
        this.waterTemp = waterTemp;
        this.waveHeightMeter = waveHeightMeter;
        this.waveDirection = waveDirection;
        this.cleanWater = cleanWater;
        this.whenToGo = whenToGo;
        this.imageUrls = imageUrls;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
