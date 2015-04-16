package com.twu.biblioteca.logic;

import com.twu.biblioteca.repo.PreExistingBookListSize5;
import com.twu.biblioteca.repo.PreExistingMovieListSize3;
import com.twu.biblioteca.ui.Console;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5(), new PreExistingMovieListSize3());
        Console console = new Console(processor);
        assertEquals(expectedPrint, processor.response(Option.LIST_BOOKS));
    }

    @Test
    public void test_command_processor_should_response_LIST_MOVIES() throws Exception {
        String expectedPrint = "=== MOVIE LIST ===\r\n" +
                "[ID: 11] [NAME: Test Movie 1] [DIRECTOR: Test Director 1] [YEAR: 2001] [RATING: 1]\r\n" +
                "[ID: 12] [NAME: Test Movie 2] [DIRECTOR: Test Director 2] [YEAR: 2002] [RATING: 2]\r\n" +
                "[ID: 13] [NAME: Test Movie 3] [DIRECTOR: Test Director 3] [YEAR: 2003] [RATING: Not Rated]\r\n" +
                "=================";
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5(), new PreExistingMovieListSize3());
        Console console = new Console(processor);
        assertEquals(expectedPrint, processor.response(Option.LIST_MOVIES));
    }

    @Test
    public void test_quit_should_return_empty_string() throws Exception {
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5(), new PreExistingMovieListSize3());
        Console console = new Console(processor);
        assertEquals("", processor.response(Option.QUIT));

    }

    @Test
    public void test_invalid_input_should_be_warned() throws Exception {
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5(), new PreExistingMovieListSize3());
        Console console = new Console(processor);
        assertEquals("Select a valid option!", processor.response(Option.INVALID));
    }

    @Test
    public void test_checked_out_book_should_not_in_the_list() throws Exception {
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5(),new PreExistingMovieListSize3());
        Console console = new Console(processor);
        console.setIsLoggedIn(true);
        assertEquals("Thank you! Enjoy the book!", processor.response(Option.CHECKOUT_BOOK));
        String expectedPrint = "=== BOOK LIST ===\r\n" +
                "[ID: 2] [NAME: Test Book 2] [AUTHOR: Test Author 2] [YEAR: 2002]\r\n" +
                "[ID: 3] [NAME: Test Book 3] [AUTHOR: Test Author 3] [YEAR: 2003]\r\n" +
                "[ID: 4] [NAME: Test Book 4] [AUTHOR: Test Author 4] [YEAR: 2004]\r\n" +
                "[ID: 5] [NAME: Test Book 5] [AUTHOR: Test Author 5] [YEAR: 2005]\r\n" +
                "=================";
        assertEquals(expectedPrint, processor.response(Option.LIST_BOOKS));
        System.setIn(System.in);
    }

    @Test
    public void test_checkout_not_existing_book_should_get_error_msg() throws Exception {
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5(), new PreExistingMovieListSize3());
        Console console = new Console(processor);
        console.setIsLoggedIn(true);
        System.setIn(new ByteArrayInputStream("6".getBytes()));
        assertEquals("That book is not available.", processor.response(Option.CHECKOUT_BOOK));
    }

    @Test
    public void test_returned_book_should_show_in_list() throws Exception {
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5(), new PreExistingMovieListSize3());
        Console console = new Console(processor);
        console.setIsLoggedIn(true);
        String expectedPrint = "=== BOOK LIST ===\r\n" +
                "[ID: 1] [NAME: Test Book 1] [AUTHOR: Test Author 1] [YEAR: 2001]\r\n" +
                "[ID: 2] [NAME: Test Book 2] [AUTHOR: Test Author 2] [YEAR: 2002]\r\n" +
                "[ID: 3] [NAME: Test Book 3] [AUTHOR: Test Author 3] [YEAR: 2003]\r\n" +
                "[ID: 4] [NAME: Test Book 4] [AUTHOR: Test Author 4] [YEAR: 2004]\r\n" +
                "[ID: 5] [NAME: Test Book 5] [AUTHOR: Test Author 5] [YEAR: 2005]\r\n" +
                "=================";
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        processor.response(Option.CHECKOUT_BOOK);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        assertEquals("Thank you for returning the book.", processor.response(Option.RETURN_BOOK));
        assertEquals(expectedPrint, processor.response(Option.LIST_BOOKS));
        System.setIn(System.in);
    }

    @Test
    public void test_return_not_existing_book_should_get_error_msg() throws Exception {
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5(), new PreExistingMovieListSize3());
        Console console = new Console(processor);
        console.setIsLoggedIn(true);
        System.setIn(new ByteArrayInputStream("6".getBytes()));
        assertEquals("That is not a valid book to return.", processor.response(Option.RETURN_BOOK));
    }

    /*=======================================================*/
    @Test
    public void test_checked_out_movie_should_not_in_the_list() throws Exception {
        System.setIn(new ByteArrayInputStream("11".getBytes()));
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5(),new PreExistingMovieListSize3());
        Console console = new Console(processor);
        console.setIsLoggedIn(true);
        assertEquals("Thank you! Enjoy the movie!", processor.response(Option.CHECKOUT_MOVIE));
        String expectedPrint = "=== MOVIE LIST ===\r\n" +
                "[ID: 12] [NAME: Test Movie 2] [DIRECTOR: Test Director 2] [YEAR: 2002] [RATING: 2]\r\n" +
                "[ID: 13] [NAME: Test Movie 3] [DIRECTOR: Test Director 3] [YEAR: 2003] [RATING: Not Rated]\r\n" +
                "=================";
        assertEquals(expectedPrint, processor.response(Option.LIST_MOVIES));
        System.setIn(System.in);
    }

    @Test
    public void test_checkout_not_existing_movie_should_get_error_msg() throws Exception {
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5(), new PreExistingMovieListSize3());
        Console console = new Console(processor);
        console.setIsLoggedIn(true);
        System.setIn(new ByteArrayInputStream("14".getBytes()));
        assertEquals("That movie is not available.", processor.response(Option.CHECKOUT_MOVIE));
    }

    @Test
    public void test_returned_movie_should_show_in_list() throws Exception {
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5(), new PreExistingMovieListSize3());
        Console console = new Console(processor);
        console.setIsLoggedIn(true);
        String expectedPrint = "=== MOVIE LIST ===\r\n" +
                "[ID: 11] [NAME: Test Movie 1] [DIRECTOR: Test Director 1] [YEAR: 2001] [RATING: 1]\r\n" +
                "[ID: 12] [NAME: Test Movie 2] [DIRECTOR: Test Director 2] [YEAR: 2002] [RATING: 2]\r\n" +
                "[ID: 13] [NAME: Test Movie 3] [DIRECTOR: Test Director 3] [YEAR: 2003] [RATING: Not Rated]\r\n" +
                "=================";
        System.setIn(new ByteArrayInputStream("11".getBytes()));
        processor.response(Option.CHECKOUT_MOVIE);
        System.setIn(new ByteArrayInputStream("11".getBytes()));
        assertEquals("Thank you for returning the movie.", processor.response(Option.RETURN_MOVIE));
        assertEquals(expectedPrint, processor.response(Option.LIST_MOVIES));
        System.setIn(System.in);
    }

    @Test
    public void test_return_not_existing_movie_should_get_error_msg() throws Exception {
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5(), new PreExistingMovieListSize3());
        Console console = new Console(processor);
        console.setIsLoggedIn(true);
        System.setIn(new ByteArrayInputStream("14".getBytes()));
        assertEquals("That is not a valid movie to return.", processor.response(Option.RETURN_MOVIE));
    }

    /*=====================================================*/

    @Test
    public void test_logged_in_user_should_get_proper_option_list() throws Exception {
        CommandProcessor processor = new CommandProcessor(new PreExistingBookListSize5(), new PreExistingMovieListSize3());
        Console console = new Console(processor);

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
        console.getProcessor().response(Option.LOG_IN);
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
        console.getProcessor().response(Option.LOG_OUT);
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
