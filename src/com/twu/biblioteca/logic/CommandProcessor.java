package com.twu.biblioteca.logic;

import com.twu.biblioteca.repo.BookListService;
import com.twu.biblioteca.ui.Option;

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
                System.out.println(responseMsg);
                break;
            default:
                break;
        }
        return responseMsg;
    }
}
