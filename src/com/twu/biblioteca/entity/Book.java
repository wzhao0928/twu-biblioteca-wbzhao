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

    public Book(long id, String name, String author, Year year) {
        setId(id);
        setName(name);
        setAuthor(author);
        setYear(year);
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

    private void setId(Long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    private void setYear(Year year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book that = (Book)obj;
            if (that.getId() == id)
                return true;
            return false;
        }
        return false;
    }
}
