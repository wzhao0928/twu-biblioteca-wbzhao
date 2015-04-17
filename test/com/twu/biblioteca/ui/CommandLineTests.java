package com.twu.biblioteca.ui;

import com.twu.biblioteca.logic.Option;
import com.twu.biblioteca.logic.OptionExecutor;
import com.twu.biblioteca.repo.PreExistingBookListSize5;
import com.twu.biblioteca.repo.PreExistingMovieListSize3;
import com.twu.biblioteca.repo.UserListService;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by wbzhao on 15-4-12.
 */
public class CommandLineTests {
    @Test
    public void test_command_line_should_return_option_according_to_input() throws Exception {
        Console console = new Console();
        console.setupEnv(new OptionExecutor(new PreExistingBookListSize5(), new PreExistingMovieListSize3(), console, new UserListService()));
        console.getSession().setLoggedInUserLibNumber("");
        System.setIn(new ByteArrayInputStream("List Books".getBytes()));
        assertEquals(Option.LIST_BOOKS, console.readCommand());
        System.setIn(new ByteArrayInputStream("Quit".getBytes()));
        assertEquals(Option.QUIT, console.readCommand());
        System.setIn(new ByteArrayInputStream("List Movies".getBytes()));
        assertEquals(Option.LIST_MOVIES, console.readCommand());
        System.setIn(new ByteArrayInputStream("Log in".getBytes()));
        assertEquals(Option.LOG_IN, console.readCommand());
        console.getSession().setLoggedInUserLibNumber("123-4567");
        System.setIn(new ByteArrayInputStream("Check-out Book".getBytes()));
        assertEquals(Option.CHECKOUT_BOOK, console.readCommand());
        System.setIn(new ByteArrayInputStream("Return Book".getBytes()));
        assertEquals(Option.RETURN_BOOK, console.readCommand());
        System.setIn(new ByteArrayInputStream("Check-out Movie".getBytes()));
        assertEquals(Option.CHECKOUT_MOVIE, console.readCommand());
        System.setIn(new ByteArrayInputStream("Return Movie".getBytes()));
        assertEquals(Option.RETURN_MOVIE, console.readCommand());
        System.setIn(new ByteArrayInputStream("Log out".getBytes()));
        assertEquals(Option.LOG_OUT, console.readCommand());

        System.setIn(System.in);
    }
}
