package com.twu.biblioteca.logic;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.repo.BookListService;
import com.twu.biblioteca.ui.Option;

import java.util.List;
import java.util.Scanner;

/**
 * Created by wbzhao on 15-4-12.
 */
public class CommandProcessor {
    private BookListService bookListService;

    public CommandProcessor(BookListService bookListService) {
        this.bookListService = bookListService;
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
        if (bookListService.returnBookById(returnBookId)) {
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
        if (bookListService.checkOutBookById(checkoutBookId)) {
            responseMsg = "Thank you! Enjoy the book!";
        } else {
            responseMsg = "That book is not available.";
        }
        return responseMsg;
    }

    private String makeBookListView(List<Book> books) {
        String toPrint = "=== BOOK LIST ===\r\n";
        for (Book book : books) {
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
        String result = makeBookListView(bookListService.getBooks());
        return result;
    }

    public String doCheckOut() {
        return checkOutFlow();
    }

    public String doReturn() {
        return returnFlow();
    }


}
