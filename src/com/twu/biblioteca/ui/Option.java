package com.twu.biblioteca.ui;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.logic.CommandProcessor;

/**
 * Created by wbzhao on 15-4-12.
 */
public enum Option {
    LIST_BOOKS("List Books") {
        @Override
        public String execute() {
            return processor.doListBooks();
        }
    },

    LIST_MOVIES("List Movies") {
        @Override
        public String execute() {
            return processor.doListMovies();
        }
    },

    INVALID(null) {
        @Override
        public String execute() {
            return "Select a valid option!";
        }
    },

    QUIT("Quit") {
        @Override
        public String execute() {
            return "";
        }
    },

    CHECKOUT_BOOK("Check-out Book") {
        @Override
        public String execute() {
            return processor.doCheckOut(Book.class);
        }
    },

    RETURN_BOOK("Return Book") {
        @Override
        public String execute() {
            return processor.doReturn(Book.class);
        }
    },

    CHECKOUT_MOVIE("Check-out Movie") {
        @Override
        public String execute() {
            return processor.doCheckOut(Movie.class);
        }
    },

    RETURN_MOVIE("Return Movie") {
        @Override
        public String execute() {
            return processor.doReturn(Movie.class);
        }
    }
    ;

    private String optString;
    private static CommandProcessor processor;

    Option(String optString) {
        this.optString = optString;
    }

    public static void setProcessor(CommandProcessor processor) {
        Option.processor = processor;
    }

    @Override
    public String toString() {
        return optString;
    }

    abstract public String execute();
}
