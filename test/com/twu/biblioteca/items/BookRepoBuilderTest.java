package com.twu.biblioteca.items;

import org.junit.Test;

import java.time.Year;

import static org.junit.Assert.assertTrue;

/**
 * Created by wbzhao on 15/5/4.
 */
public class BookRepoBuilderTest {

    @Test
    public void test_book_repo_builder_should_build_the_book_repo_with_given_books() throws Exception {
        BookRepoBuilder bookRepoBuilder = new BookRepoBuilder();
        BookBuilder bookBuilder = new BookBuilder();
        Book[] books = new Book[]{
                bookBuilder.setId(1).setTitle("TestBook1").setAuthor("TestAuthor1").setYear(Year.of(2001)).build(),
                bookBuilder.setId(2).setTitle("TestBook2").setAuthor("TestAuthor2").setYear(Year.of(2002)).build(),
                bookBuilder.setId(3).setTitle("TestBook3").setAuthor("TestAuthor3").setYear(Year.of(2003)).build()
        };
        for (Book book : books) {
            bookRepoBuilder.addBook(book);
        }
        BookRepository bookRepository = bookRepoBuilder.build();
        for (Book book : books) {
            assertTrue(bookRepository.getAllBooks().contains(book));
        }
    }
}
