package com.twu.biblioteca.logic;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Item;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.repo.ItemListService;

import java.util.List;
import java.util.Scanner;

/**
 * Created by wbzhao on 15-4-12.
 */
public class CommandProcessor {
    private ItemListService bookListService;
    private ItemListService movieListService;

    public CommandProcessor(ItemListService bookListService, ItemListService movieListService) {
        this.bookListService = bookListService;
        this.movieListService = movieListService;
    }

    public String response(Option option) {
        String responseMsg = option.execute();
        System.out.println();
        System.out.println(responseMsg);
        System.out.println();
        return responseMsg;
    }

    public String doListBooks() {
        return makeListView(bookListService.getItems(), Book.class);
    }

    public String doListMovies() {
        return makeListView(movieListService.getItems(), Movie.class);
    }

    public String doCheckOut(Class clazz) {
        return checkOutFlow(clazz);
    }

    public String doReturn(Class clazz) {
        return returnFlow(clazz);
    }

    private String returnFlow(Class clazz) {
        long returnItemId = readItemId(clazz);
        if (clazz.equals(Book.class)) {
            return bookListService.returnItemById(returnItemId) ?
                    "Thank you for returning the book." : "That is not a valid book to return.";
        }
        if (clazz.equals(Movie.class)) {
            return movieListService.returnItemById(returnItemId) ?
                    "Thank you for returning the movie." : "That is not a valid movie to return.";
        }
        return null;
    }

    private String checkOutFlow(Class clazz) {
        long checkoutItemId = readItemId(clazz);
        if (clazz.equals(Book.class)) {
            return bookListService.checkOutItemById(checkoutItemId) ?
                    "Thank you! Enjoy the book!" : "That book is not available.";
        }
        if (clazz.equals(Movie.class)) {
            return movieListService.checkOutItemById(checkoutItemId) ?
                    "Thank you! Enjoy the movie!" : "That movie is not available.";
        }
        return "";
    }

    private long readItemId(Class clazz) {
        System.out.print("\tPlease input the ID of the " + clazz.getSimpleName() + ": ");
        return Long.parseLong(new Scanner(System.in).next());
    }

    private String makeListView(List<Item> items, Class clazz) {
        String toPrint = "=== " + clazz.getSimpleName().toUpperCase() + " LIST ===\r\n";
        for (Item item : items) {
            if (clazz.equals(Book.class)) {
                toPrint += makeBookDetailLine((Book)item);
            }
            if (clazz.equals(Movie.class)) {
                toPrint += makeMovieDetailLine((Movie) item);
            }
        }
        toPrint += "=================";
        return toPrint;
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

}
