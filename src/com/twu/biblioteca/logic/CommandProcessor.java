package com.twu.biblioteca.logic;

import com.twu.biblioteca.repo.BookListService;
import com.twu.biblioteca.ui.Option;

import java.util.Scanner;

/**
 * Created by wbzhao on 15-4-12.
 */
public class CommandProcessor {
    private BookListService bookListService;

    public CommandProcessor(BookListService bookListService) {
        this.bookListService = bookListService;
    }

    public String response(Option option) {
        String responseMsg = "";
        switch (option) {
            case LIST_BOOKS:
                responseMsg = bookListService.print();
                break;
            case INVALID:
                responseMsg = "Select a valid option!";
                break;
            case CHECKOUT:
                System.out.print("\tPlease input the ID of the book: ");
                long bookId = Long.parseLong(new Scanner(System.in).next());
                if (bookListService.checkOutBookById(bookId)) {
                    responseMsg = "Thank you! Enjoy the book!";
                } else {
                    responseMsg = "That book is not available.";
                }
                break;
            default:
                break;
        }
        System.out.println();
        System.out.println(responseMsg);
        System.out.println();
        return responseMsg;
    }
}
