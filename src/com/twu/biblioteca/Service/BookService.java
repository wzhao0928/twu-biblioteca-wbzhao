package com.twu.biblioteca.Service;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.BookBuilder;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wbzhao on 15/5/4.
 */
public class BookService {
    public List<Book> getAllAvailableBooks() {
        BookBuilder builder = new BookBuilder();
        List<Book> books = new ArrayList<Book>();
        books.add(builder.setId(1).setTitle("TestBook1").setAuthor("TestAuthor1").setYear(Year.of(2001)).build());
        books.add(builder.setId(2).setTitle("TestBook2").setAuthor("TestAuthor2").setYear(Year.of(2002)).build());
        books.add(builder.setId(3).setTitle("TestBook3").setAuthor("TestAuthor3").setYear(Year.of(2003)).build());
        return books;
    }
}
