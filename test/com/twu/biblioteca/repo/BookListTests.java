package com.twu.biblioteca.repo;

import com.twu.biblioteca.entity.Book;
import org.junit.Before;
import org.junit.Test;

import java.time.Year;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wbzhao on 15-4-12.
 */
public class BookListTests {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void pre_existing_books_should_be_get() throws Exception {
        BookListService preExistingBookListSize5 = new PreExistingBookListSize5();
        List<Book> preExisting5Books = preExistingBookListSize5.getBooks();
        Book testBook1 = new Book(1, "Test Book 1", "Test Author 1", Year.of(2001));
        Book testBook2 = new Book(2, "Test Book 2", "Test Author 2", Year.of(2002));
        Book testBook3 = new Book(3, "Test Book 3", "Test Author 3", Year.of(2003));
        Book testBook4 = new Book(4, "Test Book 4", "Test Author 4", Year.of(2004));
        Book testBook5 = new Book(5, "Test Book 5", "Test Author 5", Year.of(2005));
        Book testBook6 = new Book(6, "Test Book 6", "Test Author 6", Year.of(2006));

        assertFalse(preExisting5Books.isEmpty());
        assertEquals(5, preExisting5Books.size());
        assertTrue(preExisting5Books.contains(testBook1));
        assertTrue(preExisting5Books.contains(testBook2));
        assertTrue(preExisting5Books.contains(testBook3));
        assertTrue(preExisting5Books.contains(testBook4));
        assertTrue(preExisting5Books.contains(testBook5));
        assertFalse(preExisting5Books.contains(testBook6));
    }

}
