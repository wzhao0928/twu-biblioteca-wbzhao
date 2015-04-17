package com.twu.biblioteca.logic;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Item;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.repo.ItemListService;
import com.twu.biblioteca.repo.UserListService;
import com.twu.biblioteca.ui.Console;

import java.util.Scanner;

/**
 * Created by wbzhao on 15/4/17.
 */
public class OptionExecutor {

    private ItemListService bookListService;
    private ItemListService movieListService;
    private UserListService userListService;
    private static Console console;

    public OptionExecutor(ItemListService bookListService, ItemListService movieListService, Console consl, UserListService userListService) {
        this.bookListService = bookListService;
        this.movieListService = movieListService;
        this.userListService = userListService;
        console = consl;
    }

    public Console getConsole() {
        return console;
    }

    public String doListItems(Class clazz) {
        String toPrint = "=== " + clazz.getSimpleName().toUpperCase() + " LIST ===\r\n";
        if (clazz.equals(Book.class)) {
            for (Item item : bookListService.getItems()) {
                toPrint += makeBookDetailLine((Book)item);
            }
        }
        if (clazz.equals(Movie.class)) {
            for (Item item : movieListService.getItems()) {
                toPrint += makeMovieDetailLine((Movie) item);
            }
        }
        toPrint += "=================";
        return toPrint;
    }

    public String doCheckOut(Class clazz) {
        long checkoutItemId = readItemId(clazz);
        if (clazz.equals(Book.class)) {
            return bookListService.checkOutItemById(checkoutItemId, console.getSession().getLoggedInUserLibNumber()) ?
                    "Thank you! Enjoy the book!" : "That book is not available.";
        }
        if (clazz.equals(Movie.class)) {
            return movieListService.checkOutItemById(checkoutItemId, console.getSession().getLoggedInUserLibNumber()) ?
                    "Thank you! Enjoy the movie!" : "That movie is not available.";
        }
        return "";
    }

    public String doReturn(Class clazz) {
        long returnItemId = readItemId(clazz);
        if (clazz.equals(Book.class)) {
            return bookListService.returnItemById(returnItemId, console.getSession().getLoggedInUserLibNumber()) ?
                    "Thank you for returning the book." : "That is not a valid book to return.";
        }
        if (clazz.equals(Movie.class)) {
            return movieListService.returnItemById(returnItemId, console.getSession().getLoggedInUserLibNumber()) ?
                    "Thank you for returning the movie." : "That is not a valid movie to return.";
        }
        return null;
    }

    private long readItemId(Class clazz) {
        System.out.print("\tPlease input the ID of the " + clazz.getSimpleName() + ": ");
        return Long.parseLong(new Scanner(System.in).next());
    }

    private String makeBookDetailLine(Book book) {
        return "[ID: " + book.getId() + "] " +
                "[NAME: " + book.getName() + "] " +
                "[AUTHOR: " + book.getAuthor() + "] " +
                "[YEAR: " + book.getYear() + "]\r\n";
    }

    private String makeMovieDetailLine(Movie movie) {
        return "[ID: " + movie.getId() + "] " +
                "[NAME: " + movie.getName() + "] " +
                "[DIRECTOR: " + movie.getDirector() + "] " +
                "[YEAR: " + movie.getYear() + "] " +
                "[RATING: " + ((movie.getRating() == 0) ? "Not Rated" : movie.getRating() ) + "]\r\n";
    }

    public String doLogIn(String[] libNumberAndPsw) {
        if (userListService.checkCredential(libNumberAndPsw)) {
            console.getSession().setLoggedInUserLibNumber(libNumberAndPsw[0]);
            return "You have logged in with your Library number: " + libNumberAndPsw[0];
        }
        return "Invalid Library number or password!";
    }

    public String doLogOut() {
        console.getSession().setLoggedInUserLibNumber("");
        return "You have logged out";
    }
}
