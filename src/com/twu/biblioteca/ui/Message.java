package com.twu.biblioteca.ui;

/**
 * Created by wbzhao on 15/4/24.
 */
public abstract class Message {
    protected final String content;

    protected Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
