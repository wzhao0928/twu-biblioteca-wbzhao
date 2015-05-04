package com.twu.biblioteca.items;

import java.time.Year;

/**
 * Created by wbzhao on 15/5/4.
 */
public class DefaultBookRepoBuilder extends BookRepoBuilder {

    public DefaultBookRepoBuilder() {
        super();
        BookBuilder bookBuilder = new BookBuilder();
        Book[] books = new Book[]{
                bookBuilder.setId(1).setTitle("TestBook1").setAuthor("TestAuthor1").setYear(Year.of(2001)).build(),
                bookBuilder.setId(2).setTitle("TestBook2").setAuthor("TestAuthor2").setYear(Year.of(2002)).build(),
                bookBuilder.setId(3).setTitle("TestBook3").setAuthor("TestAuthor3").setYear(Year.of(2003)).build()
        };
        for (Book book : books) {
            this.addBook(book);
        }
    }
}
