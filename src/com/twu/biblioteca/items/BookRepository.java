package com.twu.biblioteca.items;

import java.util.List;

/**
 * Created by wbzhao on 15/5/4.
 */
public class BookRepository {

    private final List<Book> books;

    public BookRepository(List<Book> books) {
        this.books = books;
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
