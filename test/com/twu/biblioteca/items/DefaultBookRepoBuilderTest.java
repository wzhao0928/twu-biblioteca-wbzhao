package com.twu.biblioteca.items;

import org.junit.Test;

import java.time.Year;

import static org.junit.Assert.assertTrue;

public class DefaultBookRepoBuilderTest {

    @Test
    public void testBuild() throws Exception {
        BookBuilder bookBuilder = new BookBuilder();
        Book[] books = new Book[]{
                bookBuilder.setId(1).setTitle("TestBook1").setAuthor("TestAuthor1").setYear(Year.of(2001)).build(),
                bookBuilder.setId(2).setTitle("TestBook2").setAuthor("TestAuthor2").setYear(Year.of(2002)).build(),
                bookBuilder.setId(3).setTitle("TestBook3").setAuthor("TestAuthor3").setYear(Year.of(2003)).build()
        };
        BookRepository bookRepository = new DefaultBookRepoBuilder().build();
        for (Book book : books) {
            assertTrue(bookRepository.getAllBooks().contains(book));
        }
    }
}