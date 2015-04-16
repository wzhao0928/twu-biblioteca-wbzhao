package com.twu.biblioteca.entity;

import java.time.Year;

/**
 * Created by wbzhao on 15-4-12.
 */
public class Book extends Item {

    public Book(long id, String name, String author, Year year) {
        super(id, name, author, year);
    }

    public String getAuthor() {
        return this.getCreator();
    }
}
