package com.twu.biblioteca.ui;

/**
 * Created by wbzhao on 15-4-12.
 */
public enum Option {
    LIST_BOOKS("List Books"), INVALID(null);

    private String optString;

    Option(String optString) {
        this.optString = optString;
    }

    @Override
    public String toString() {
        return optString;
    }
}
