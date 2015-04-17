package com.twu.biblioteca.repo;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Item;
import com.twu.biblioteca.entity.Movie;
import org.junit.Test;

import java.time.Year;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wbzhao on 15-4-12.
 */
public class ItemListTests {

    @Test
    public void pre_existing_books_should_be_get() throws Exception {
        ItemListService preExistingBookListSize5 = new PreExistingBookListSize5();
        List<Item> preExisting5Books = preExistingBookListSize5.getItems();
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

    @Test
    public void test_pre_existing_movies_should_be_get() throws Exception {
        ItemListService preExistingMovieListSize3 = new PreExistingMovieListSize3();
        List<Item> preExisting3Movies = preExistingMovieListSize3.getItems();
        Movie testMovie1 = new Movie(11, "Test Movie 1", "Test Director 1", Year.of(2001), 1);
        Movie testMovie2 = new Movie(12, "Test Movie 2", "Test Director 2", Year.of(2002), 2);
        Movie testMovie3 = new Movie(13, "Test Movie 3", "Test Director 3", Year.of(2003), 0);
        Movie testMovie4 = new Movie(14, "Test Movie 4", "Test Director 4", Year.of(2004), 4);

        assertFalse(preExisting3Movies.isEmpty());
        assertEquals(3, preExisting3Movies.size());
        assertTrue(preExisting3Movies.contains(testMovie1));
        assertTrue(preExisting3Movies.contains(testMovie2));
        assertTrue(preExisting3Movies.contains(testMovie3));
        assertFalse(preExisting3Movies.contains(testMovie4));

    }
}
