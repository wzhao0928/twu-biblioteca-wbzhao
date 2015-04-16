package com.twu.biblioteca.repo;

import com.twu.biblioteca.entity.Item;
import com.twu.biblioteca.entity.Movie;

import java.time.Year;
import java.util.ArrayList;

/**
 * Created by wbzhao on 15/4/16.
 */
public class PreExistingMovieListSize3 extends ItemListService {

    public PreExistingMovieListSize3() {
        items = new ArrayList<Item>();
        items.add(new Movie((long)11, "Test Movie 1", "Test Director 1", Year.of(2001), 1));
        items.add(new Movie((long)12, "Test Movie 2", "Test Director 2", Year.of(2002), 2));
        items.add(new Movie((long)13, "Test Movie 3", "Test Director 3", Year.of(2003), 0));

    }

}
