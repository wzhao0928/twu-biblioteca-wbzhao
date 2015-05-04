package com.twu.biblioteca.items;

import java.time.Year;

/**
 * Created by wbzhao on 15/5/2.
 */
public class BookBuilder {

    private int id;
    private String title;
    private String author;
    private Year year;

    public BookBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setYear(Year year) {
        this.year = year;
        return this;
    }

    public Book build() {
        return new Book(id, title, author, year);
    }
}
