package com.twu.biblioteca.entity;

import java.time.Year;

/**
 * Created by wbzhao on 15-4-16.
 */
public class Movie extends Item {
    private int rating;

    public Movie(long id, String name, String director, Year year, int rating) {
        super(id, name, director, year);
        setRating(rating);
    }

    public String getDirector() {
        return this.getCreator();
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
