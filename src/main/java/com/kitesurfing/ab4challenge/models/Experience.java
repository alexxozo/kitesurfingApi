package com.kitesurfing.ab4challenge.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashMap;

@Getter
@Setter
@ToString

public class Experience {
    private double comment;
    private Date date;

    public Experience(double comment, Date date) {
        this.comment = comment;
        this.date = date;
    }
}
