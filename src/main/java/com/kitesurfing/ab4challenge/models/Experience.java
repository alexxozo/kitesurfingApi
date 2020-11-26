package com.kitesurfing.ab4challenge.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString

@Document(collection = "experiences")
public class Experience {
    private String comment;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOne_word() {
        return one_word;
    }

    public void setOne_word(String one_word) {
        this.one_word = one_word;
    }

    private String author;
    private String one_word;
    private int rating;
    private String[] imageUrls;
    private Date date;
    private String spot_id;

    public Experience(String comment, String author, String one_word, int rating, String[] imageUrls, Date date, String spot_id) {
        this.comment = comment;
        this.author = author;
        this.one_word = one_word;
        this.rating = rating;
        this.imageUrls = imageUrls;
        this.date = date;
        this.spot_id = spot_id;
    }

    public String getSpot_id() {
        return spot_id;
    }

    public void setSpot_id(String spot_id) {
        this.spot_id = spot_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
