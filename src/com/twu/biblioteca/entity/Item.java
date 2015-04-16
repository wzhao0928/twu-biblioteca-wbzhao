package com.twu.biblioteca.entity;

import java.time.Year;

/**
 * Created by wbzhao on 15-4-16.
 */
public abstract class Item {
    private long id;
    private String name;
    private String creator;
    private Year year;
    private boolean available;

    public Item(long id, String name, String creator, Year year) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.year = year;
        available = true;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    protected String getCreator() {
        return creator;
    }

    public Year getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Item) {
            Item that = (Item)obj;
            if (that.getId() == id)
                return true;
            return false;
        }
        return false;
    }
}
