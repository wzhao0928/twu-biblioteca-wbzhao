package com.twu.biblioteca.logic;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Item;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.repo.ItemListService;
import com.twu.biblioteca.ui.Option;

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
        Option.setProcessor(this);
    }

    public String response(Option option) {
        String responseMsg = option.execute();
        System.out.println();
        System.out.println(responseMsg);
        System.out.println();
        return responseMsg;
    }

    private String returnFlow() {
        String responseMsg;
        long returnBookId = readBookId();
        if (bookListService.returnItemById(returnBookId)) {
            responseMsg = "Thank you for returning the book.";
        } else {
            responseMsg = "That is not a valid book to return.";
        }
        return responseMsg;
    }

    private long readBookId() {
        System.out.print("\tPlease input the ID of the book: ");
        return Long.parseLong(new Scanner(System.in).next());
    }

    private String checkOutFlow() {
        String responseMsg;
        long checkoutBookId = readBookId();
        if (bookListService.checkOutItemById(checkoutBookId)) {
            responseMsg = "Thank you! Enjoy the book!";
        } else {
            responseMsg = "That book is not available.";
        }
        return responseMsg;
    }

    private String makeBookListView(List<Item> books) {
        String toPrint = "=== BOOK LIST ===\r\n";
        for (Item item : books) {
            Book book = (Book)item;
            String bookDetail = "[ID: " + book.getId() + "] " +
                    "[NAME: " + book.getName() + "] " +
                    "[AUTHOR: " + book.getAuthor() + "] " +
                    "[YEAR: " + book.getYear() + "]\r\n";
            toPrint += bookDetail;
        }
        toPrint += "=================";
        return toPrint;
    }

    public String doListBooks() {
        String result = makeBookListView(bookListService.getItems());
        return result;
    }

    public String doCheckOut() {
        return checkOutFlow();
    }

    public String doReturn() {
        return returnFlow();
    }


    public String doListMovies() {
        return makeMovieListView(movieListService.getItems());
    }

    private String makeMovieListView(List<Item> movies) {
        String toPrint = "=== BOOK LIST ===\r\n";
        for (Item item : movies) {
            Movie movie = (Movie)item;
            String bookDetail = "[ID: " + movie.getId() + "] " +
                    "[NAME: " + movie.getName() + "] " +
                    "[AUTHOR: " + movie.getDirector() + "] " +
                    "[YEAR: " + movie.getYear() + "]\r\n" +
                    "[RATING: " + ((movie.getRating() == 0) ? "Not Rated" : movie.getRating() ) + "]";
            toPrint += bookDetail;
        }
        toPrint += "=================";
        return toPrint;
    }
}
