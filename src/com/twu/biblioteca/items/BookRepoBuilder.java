package com.twu.biblioteca.items;

import java.util.ArrayList;

/**
 * Created by wbzhao on 15/5/4.
 */
public class BookRepoBuilder {

    private ArrayList<Book> bookList;

    public BookRepoBuilder() {
        bookList = new ArrayList<Book>();
    }

    public BookRepoBuilder addBook(Book book) {
        bookList.add(book);
        return this;
    }

    public BookRepository build() {
        return new BookRepository(bookList);
    }
}
