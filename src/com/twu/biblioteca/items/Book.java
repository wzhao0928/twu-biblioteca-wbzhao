package com.twu.biblioteca.items;

import java.time.Year;

/**
 * Created by wbzhao on 15/5/2.
 */
public class Book {
    private final int id;
    private final String title;
    private final String author;
    private final Year year;

    public Book(int id, String title, String author, Year year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Year getYear() {
        return year;
    }

    @Override
    public String toString() {
        return  "[ID: " + getId() + "] " +
                "[TITLE: " + getTitle() + "] " +
                "[AUTHOR: " + getAuthor() + "] " +
                "[YEAR: " + getYear().toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book that = (Book)obj;
            return  this.getId() == that.getId() &&
                    this.getTitle().equals(that.getTitle()) &&
                    this.getAuthor().equals(that.getAuthor()) &&
                    this.getYear().equals(that.getYear());
        }
        return false;
    }
}
