package com.twu.biblioteca.items;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Year;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTest {

    private Book book;

    private int bookId;
    private String bookTitle;
    private String bookAuthor;
    private Year year;

    @Before
    public void setUp() throws Exception {
        bookId = 1;
        bookTitle = "TestBook1";
        bookAuthor = "TestAuthor1";
        year = Year.of(2001);
        book = new Book(bookId, bookTitle, bookAuthor , year);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetId() throws Exception {
        assertEquals(bookId, book.getId());
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals(bookTitle, book.getTitle());
    }

    @Test
    public void testGetAuthor() throws Exception {
        assertEquals(bookAuthor, book.getAuthor());
    }

    @Test
    public void testGetYear() throws Exception {
        assertEquals(year, book.getYear());
    }

    @Test
    public void testToString() throws Exception {
        String expectedBookDetail = "[ID: " + bookId + "] [TITLE: " + bookTitle + "] [AUTHOR: " + bookAuthor + "] [YEAR: " + year.toString() + "]";
        assertEquals(expectedBookDetail, book.toString());
    }

    @Test
    public void testEquals() throws Exception {
        Book testBook = new Book(bookId, bookTitle, bookAuthor, year);
        assertTrue(book.equals(testBook));
    }
}