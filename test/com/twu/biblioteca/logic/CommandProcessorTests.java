package com.twu.biblioteca.logic;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.repo.ItemListService;
import com.twu.biblioteca.repo.PreExistingBookListSize5;
import com.twu.biblioteca.repo.PreExistingMovieListSize3;
import com.twu.biblioteca.repo.UserListService;
import com.twu.biblioteca.ui.Console;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wbzhao on 15-4-12.
 */
public class CommandProcessorTests {

    @Test
    public void test_command_processor_should_response_LIST_BOOKS() throws Exception {
        String expectedPrint = "=== BOOK LIST ===\r\n" +
                "[ID: 1] [NAME: Test Book 1] [AUTHOR: Test Author 1] [YEAR: 2001]\r\n" +
                "[ID: 2] [NAME: Test Book 2] [AUTHOR: Test Author 2] [YEAR: 2002]\r\n" +
                "[ID: 3] [NAME: Test Book 3] [AUTHOR: Test Author 3] [YEAR: 2003]\r\n" +
                "[ID: 4] [NAME: Test Book 4] [AUTHOR: Test Author 4] [YEAR: 2004]\r\n" +
                "[ID: 5] [NAME: Test Book 5] [AUTHOR: Test Author 5] [YEAR: 2005]\r\n" +
                "=================";
        Console console = new Console();
        console.setupEnv(new OptionExecutor(new PreExistingBookListSize5(), new PreExistingMovieListSize3(), console, new UserListService()));
        assertEquals(expectedPrint, console.response(Option.LIST_BOOKS));
    }

    @Test
    public void test_command_processor_should_response_LIST_MOVIES() throws Exception {
        String expectedPrint = "=== MOVIE LIST ===\r\n" +
                "[ID: 11] [NAME: Test Movie 1] [DIRECTOR: Test Director 1] [YEAR: 2001] [RATING: 1]\r\n" +
                "[ID: 12] [NAME: Test Movie 2] [DIRECTOR: Test Director 2] [YEAR: 2002] [RATING: 2]\r\n" +
                "[ID: 13] [NAME: Test Movie 3] [DIRECTOR: Test Director 3] [YEAR: 2003] [RATING: Not Rated]\r\n" +
                "=================";
        Console console = new Console();
        console.setupEnv(new OptionExecutor(new PreExistingBookListSize5(), new PreExistingMovieListSize3(), console, new UserListService()));
        assertEquals(expectedPrint, console.response(Option.LIST_MOVIES));
    }

    @Test
    public void test_quit_should_return_empty_string() throws Exception {
        Console console = new Console();
        console.setupEnv(new OptionExecutor(new PreExistingBookListSize5(), new PreExistingMovieListSize3(), console, new UserListService()));
        assertEquals("", console.response(Option.QUIT));

    }

    @Test
    public void test_invalid_input_should_be_warned() throws Exception {
        Console console = new Console();
        console.setupEnv(new OptionExecutor(new PreExistingBookListSize5(), new PreExistingMovieListSize3(), console, new UserListService()));
        assertEquals("Select a valid option!", console.response(Option.INVALID));
    }

    /*=========================== checkout and return book ============================*/
    @Test
    public void test_checked_out_book_should_not_in_the_list() throws Exception {
        ItemListService bookListService = new PreExistingBookListSize5();
        Console console = new Console();
        console.setupEnv(new OptionExecutor(bookListService, new PreExistingMovieListSize3(), console, new UserListService()));
        Book book = (Book)bookListService.getItems().get(0);
        console.getSession().setLoggedInUserLibNumber("123-4567");
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        assertEquals("Thank you! Enjoy the book!", console.response(Option.CHECKOUT_BOOK));
        String expectedPrint = "=== BOOK LIST ===\r\n" +
                "[ID: 2] [NAME: Test Book 2] [AUTHOR: Test Author 2] [YEAR: 2002]\r\n" +
                "[ID: 3] [NAME: Test Book 3] [AUTHOR: Test Author 3] [YEAR: 2003]\r\n" +
                "[ID: 4] [NAME: Test Book 4] [AUTHOR: Test Author 4] [YEAR: 2004]\r\n" +
                "[ID: 5] [NAME: Test Book 5] [AUTHOR: Test Author 5] [YEAR: 2005]\r\n" +
                "=================";
        assertEquals(expectedPrint, console.response(Option.LIST_BOOKS));
        assertEquals("123-4567", book.getHolderLibNumber());
        System.setIn(System.in);
    }

    @Test
    public void test_checkout_not_existing_book_should_get_error_msg() throws Exception {
        Console console = new Console();
        console.setupEnv(new OptionExecutor(new PreExistingBookListSize5(), new PreExistingMovieListSize3(), console, new UserListService()));
        console.getSession().setLoggedInUserLibNumber("123-4567");
        System.setIn(new ByteArrayInputStream("6".getBytes()));
        assertEquals("That book is not available.", console.response(Option.CHECKOUT_BOOK));
    }

    @Test
    public void test_returned_book_should_show_in_list() throws Exception {
        ItemListService bookListService = new PreExistingBookListSize5();
        Console console = new Console();
        console.setupEnv(new OptionExecutor(bookListService, new PreExistingMovieListSize3(), console, new UserListService()));
        Book book = (Book)bookListService.getItems().get(0);
        console.getSession().setLoggedInUserLibNumber("123-4567");
        String expectedPrint = "=== BOOK LIST ===\r\n" +
                "[ID: 1] [NAME: Test Book 1] [AUTHOR: Test Author 1] [YEAR: 2001]\r\n" +
                "[ID: 2] [NAME: Test Book 2] [AUTHOR: Test Author 2] [YEAR: 2002]\r\n" +
                "[ID: 3] [NAME: Test Book 3] [AUTHOR: Test Author 3] [YEAR: 2003]\r\n" +
                "[ID: 4] [NAME: Test Book 4] [AUTHOR: Test Author 4] [YEAR: 2004]\r\n" +
                "[ID: 5] [NAME: Test Book 5] [AUTHOR: Test Author 5] [YEAR: 2005]\r\n" +
                "=================";
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        console.response(Option.CHECKOUT_BOOK);
        assertEquals("123-4567", book.getHolderLibNumber());
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        assertEquals("Thank you for returning the book.", console.response(Option.RETURN_BOOK));
        assertEquals(expectedPrint, console.response(Option.LIST_BOOKS));
        assertEquals("", book.getHolderLibNumber());
        System.setIn(System.in);
    }

    @Test
    public void test_return_not_existing_book_should_get_error_msg() throws Exception {
        Console console = new Console();
        console.setupEnv(new OptionExecutor(new PreExistingBookListSize5(), new PreExistingMovieListSize3(), console, new UserListService()));
        console.getSession().setLoggedInUserLibNumber("123-4567");
        System.setIn(new ByteArrayInputStream("6".getBytes()));
        assertEquals("That is not a valid book to return.", console.response(Option.RETURN_BOOK));
    }

    /*=========================== checkout and return movie ============================*/
    @Test
    public void test_checked_out_movie_should_not_in_the_list() throws Exception {
        System.setIn(new ByteArrayInputStream("11".getBytes()));
        ItemListService movieListService = new PreExistingMovieListSize3();
        Console console = new Console();
        console.setupEnv(new OptionExecutor(new PreExistingBookListSize5(), movieListService, console, new UserListService()));
        console.getSession().setLoggedInUserLibNumber("123-4567");
        Movie movie = (Movie)movieListService.getItems().get(0);
        assertEquals("Thank you! Enjoy the movie!", console.response(Option.CHECKOUT_MOVIE));
        String expectedPrint = "=== MOVIE LIST ===\r\n" +
                "[ID: 12] [NAME: Test Movie 2] [DIRECTOR: Test Director 2] [YEAR: 2002] [RATING: 2]\r\n" +
                "[ID: 13] [NAME: Test Movie 3] [DIRECTOR: Test Director 3] [YEAR: 2003] [RATING: Not Rated]\r\n" +
                "=================";
        assertEquals(expectedPrint, console.response(Option.LIST_MOVIES));
        assertFalse(movieListService.getItems().contains(new Movie(11, "Test Movie 1", "Test Director 1", Year.of(2001), 1)));
        assertEquals("123-4567", movie.getHolderLibNumber());
        System.setIn(System.in);
    }

    @Test
    public void test_checkout_not_existing_movie_should_get_error_msg() throws Exception {
        Console console = new Console();
        console.setupEnv(new OptionExecutor(new PreExistingBookListSize5(), new PreExistingMovieListSize3(), console, new UserListService()));
        console.getSession().setLoggedInUserLibNumber("123-4567");
        System.setIn(new ByteArrayInputStream("14".getBytes()));
        assertEquals("That movie is not available.", console.response(Option.CHECKOUT_MOVIE));
    }

    @Test
    public void test_returned_movie_should_show_in_list() throws Exception {
        ItemListService movieListService = new PreExistingMovieListSize3();
        Console console = new Console();
        console.setupEnv(new OptionExecutor(new PreExistingBookListSize5(), movieListService, console, new UserListService()));
        Movie movie = (Movie)movieListService.getItems().get(0);
        console.getSession().setLoggedInUserLibNumber("123-4567");
        String expectedPrint = "=== MOVIE LIST ===\r\n" +
                "[ID: 11] [NAME: Test Movie 1] [DIRECTOR: Test Director 1] [YEAR: 2001] [RATING: 1]\r\n" +
                "[ID: 12] [NAME: Test Movie 2] [DIRECTOR: Test Director 2] [YEAR: 2002] [RATING: 2]\r\n" +
                "[ID: 13] [NAME: Test Movie 3] [DIRECTOR: Test Director 3] [YEAR: 2003] [RATING: Not Rated]\r\n" +
                "=================";
        System.setIn(new ByteArrayInputStream("11".getBytes()));
        console.response(Option.CHECKOUT_MOVIE);
        assertEquals("123-4567", movie.getHolderLibNumber());
        System.setIn(new ByteArrayInputStream("11".getBytes()));
        assertEquals("Thank you for returning the movie.", console.response(Option.RETURN_MOVIE));
        assertEquals(expectedPrint, console.response(Option.LIST_MOVIES));
        assertEquals("", movie.getHolderLibNumber());
        System.setIn(System.in);
    }

    @Test
    public void test_return_not_existing_movie_should_get_error_msg() throws Exception {
        Console console = new Console();
        console.setupEnv(new OptionExecutor(new PreExistingBookListSize5(), new PreExistingMovieListSize3(), console, new UserListService()));
        console.getSession().setLoggedInUserLibNumber("123-4567");
        System.setIn(new ByteArrayInputStream("14".getBytes()));
        assertEquals("That is not a valid movie to return.", console.response(Option.RETURN_MOVIE));
    }

    /*========================= user log in/out ============================*/

    @Test
    public void test_logged_in_user_should_get_proper_option_list() throws Exception {
        Console console = new Console();
        OptionExecutor executor = new OptionExecutor(new PreExistingBookListSize5(), new PreExistingMovieListSize3(), console, new UserListService());
        console.setupEnv(executor);

        String[] onlyBeforeLoginOpts = new String[]{"Log in"};
        String[] commonOpts = new String[]{"List Books", "List Movies", "Quit", null};
        String[] onlyLoggedInOpts = new String[] {"Check-out Book", "Return Book", "Check-out Movie", "Return Movie", "Log out"};

        List<String> stringOptionList = new ArrayList<String>();

        for (Option opt : console.listOptions()) {
            stringOptionList.add(opt.toString());
        }
        for (String opt : commonOpts) {
            assertTrue(stringOptionList.contains(opt));
        }
        for (String opt : onlyBeforeLoginOpts) {
            assertTrue(stringOptionList.contains(opt));
        }
        for (String opt : onlyLoggedInOpts) {
            assertFalse(stringOptionList.contains(opt));
        }

        stringOptionList.clear();
//        console.response(Option.LOG_IN);
//        console.getSession().setLoggedInUserLibNumber("123-4567");

        assertEquals("You have logged in with your Library number: 123-4567", executor.doLogIn(new String[]{"123-4567", "123456"}));
        for (Option opt : console.listOptions()) {
            stringOptionList.add(opt.toString());
        }
        for (String opt : commonOpts) {
            assertTrue(stringOptionList.contains(opt));
        }
        for (String opt: onlyLoggedInOpts) {
            assertTrue(stringOptionList.contains(opt));
        }
        for (String opt : onlyBeforeLoginOpts) {
            assertFalse(stringOptionList.contains(opt));
        }

        stringOptionList.clear();
        console.response(Option.LOG_OUT);
//        console.getSession().setLoggedInUserLibNumber("");

        for (Option opt : console.listOptions()) {
            stringOptionList.add(opt.toString());
        }
        for (String opt : commonOpts) {
            assertTrue(stringOptionList.contains(opt));
        }
        for (String opt : onlyBeforeLoginOpts) {
            assertTrue(stringOptionList.contains(opt));
        }
        for (String opt : onlyLoggedInOpts) {
            assertFalse(stringOptionList.contains(opt));
        }
    }

}
