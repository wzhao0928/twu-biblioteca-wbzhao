package com.twu.biblioteca.repo;

import com.twu.biblioteca.entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wbzhao on 15-4-12.
 */
public abstract class ItemListService {
    protected List<Item> items;

    public List<Item> getItems() {
        List<Item> availableItems = new ArrayList<Item>();
        for (Item item : items) {
            if (item.isAvailable()) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    public boolean checkOutItemById(long id, String userLibNumber) {
        for (Item item : items) {
            if (item.getId() == id && item.isAvailable()) {
                item.setAvailable(false, userLibNumber);
                return true;
            }
        }
        return false;    }

    public boolean returnItemById(long id, String userLibNumber) {
        for (Item item : items) {
            if (item.getId() == id && !item.isAvailable() && item.getHolderLibNumber().equals(userLibNumber)) {
                item.setAvailable(true, "");
                return true;
            }
        }
        return false;
    }
}
