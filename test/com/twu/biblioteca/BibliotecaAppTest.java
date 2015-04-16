package com.twu.biblioteca;


import com.twu.biblioteca.logic.CommandProcessor;
import com.twu.biblioteca.repo.ItemListService;
import com.twu.biblioteca.repo.PreExistingBookListSize5;
import com.twu.biblioteca.repo.PreExistingMovieListSize3;
import com.twu.biblioteca.ui.CommandLine;
import com.twu.biblioteca.ui.MainMenu;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void test_biblioteca_should_say_byebye_and_quit_on_QUIT() throws Exception {
        System.setIn(new ByteArrayInputStream("Quit".getBytes()));
        ItemListService bookListService = new PreExistingBookListSize5();
        ItemListService movieListService = new PreExistingMovieListSize3();
        Console console = new Console(new MainMenu(), new CommandLine(), new CommandProcessor(bookListService, movieListService));
        assertEquals("Bye Bye!", console.run());
        System.setIn(System.in);

    }

}
