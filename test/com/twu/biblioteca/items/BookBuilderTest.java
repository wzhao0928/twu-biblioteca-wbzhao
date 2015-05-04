package com.twu.biblioteca.items;

import org.junit.Before;
import org.junit.Test;

import java.time.Year;

import static org.junit.Assert.assertEquals;

public class BookBuilderTest {

    private BookBuilder builder;

    @Before
    public void setUp() throws Exception {
        builder = new BookBuilder();
    }

    @Test
    public void test_book_builder_should_build_correct_book() throws Exception {
        int id = 1;
        String title = "TestBook1";
        String author = "TestAuthor1";
        Year year = Year.of(2001);
        Book expectedBook = new Book(id, title, author, year);
        Book product = builder.setId(id).setTitle(title).setAuthor(author).setYear(year).build();
        assertEquals(expectedBook.getId(), product.getId());
        assertEquals(expectedBook.getTitle(), product.getTitle());
        assertEquals(expectedBook.getAuthor(), product.getAuthor());
        assertEquals(expectedBook.getYear(), product.getYear());

    }
}