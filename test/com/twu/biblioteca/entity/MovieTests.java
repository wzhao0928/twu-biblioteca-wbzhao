package com.twu.biblioteca.entity;

import org.junit.Test;

import java.time.Year;

import static org.junit.Assert.assertEquals;

/**
 * Created by wbzhao on 15-4-16.
 */
public class MovieTests {
    @Test
    public void test_movie_entity_should_work_properly() throws Exception {
        Long id = (long)1;
        String name = "Test Movie 1";
        String director = "Test Director 1";
        Year year = Year.of(2001);
        int rating = 1;
        Movie testMovie = new Movie(1, "Test Movie 1", "Test Director 1", Year.of(2001), 1);
        assertEquals(id, new Long(testMovie.getId()));
        assertEquals(name, testMovie.getName());
        assertEquals(director, testMovie.getDirector());
        assertEquals(year, testMovie.getYear());
        assertEquals(rating, testMovie.getRating());
    }


}
