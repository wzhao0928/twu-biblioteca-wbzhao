package com.twu.biblioteca.entity;

import java.time.Year;

/**
 * Created by wbzhao on 15-4-12.
 */
public class Book {
    private Long id;
    private String name;
    private String author;
    private Year year;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Year getYear() {
        return year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(Year year) {
        this.year = year;
    }
}
