package com.twu.biblioteca.entity;

import org.junit.Test;

import java.time.Year;

import static org.junit.Assert.*;

/**
 * Created by wbzhao on 15-4-12.
 */
public class BookTests {

    @Test
    public void book_should_be_as_bean() throws Exception {
        Long id = (long)1;
        String name = "Test Book 1";
        String author = "Test Author 1";
        Year year = Year.of(2001);
        Book testBook = new Book(1, "Test Book 1", "Test Author 1", Year.of(2001));
        assertEquals(id, new Long(testBook.getId()));
        assertEquals(name, testBook.getName());
        assertEquals(author, testBook.getAuthor());
        assertEquals(year, testBook.getYear());
    }
}
