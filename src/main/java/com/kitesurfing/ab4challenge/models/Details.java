package com.kitesurfing.ab4challenge.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Details {
    private String shortDescription;
    private String whenToGo;
    private String[] imageUrls;

    public Details(String shortDescription, String whenToGo, String[] imageUrls) {
        this.shortDescription = shortDescription;
        this.whenToGo = whenToGo;
        this.imageUrls = imageUrls;
    }
}
