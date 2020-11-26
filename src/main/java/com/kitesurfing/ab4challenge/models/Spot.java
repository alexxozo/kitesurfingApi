package com.kitesurfing.ab4challenge.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

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
//    private Temperature temperature;
//    private WindSpeed windSpeed;
//    private WindDirection windDirection;
//    private Location location;

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
//        this.windDirection = windDirection;
//        this.windSpeed = windSpeed;
//        this.location = location;
//        this.temperature = temperature;
    }

    public String getTemperature() {
        return averageAirTemp;
    }

    public String getWindDirection() {
        return mainWindDir;
    }

    public double getWindSpeed() {
        return mainWindKts;
    }

    public String getLocation() {
        return locationCatalonianCoast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spot spot = (Spot) o;
        return _id.equals(spot._id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(_id);
    }

    //, Location location, Temperature temperature, WindDirection windDirection, WindSpeed windSpeed
//    public class Location {
//        public String location;
//        public Location(String location) {
//            this.location = locationCatalonianCoast;
//        }
//
//        public String getLocation() {
//            return location;
//        }
//    }
//
//    public class Temperature {
//        public String temperature;
//
//        public Temperature(String temperature) {
//            this.temperature = averageAirTemp;
//        }
//
//        public String getTemperature() {
//            return temperature;
//        }
//    }
//
//    public class WindDirection {
//        public String windDirection;
//
//        public WindDirection(String windDirection) {
//            this.windDirection = mainWindDir;
//        }
//
//        public String getWindDirection() {
//            return windDirection;
//        }
//    }
//
//    public class WindSpeed {
//
//        public double windSpeed;
//
//        public WindSpeed(double windSpeed) {
//            this.windSpeed = mainWindKts;
//        }
//
//        public double getWindSpeed() {
//            return windSpeed;
//        }
//    }

}
