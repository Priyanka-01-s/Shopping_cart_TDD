package com.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {    
    private List<Item> shoppingList = new ArrayList<>();

    public List<Item> getItems() {
        return shoppingList;
    }

    public void addItem(Item item){
        shoppingList.add(item);
    }

    public void removeItem(Item item){
        shoppingList.remove(item);
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (Item item : shoppingList) {
            total += item.getPrice();
        }
        return total;
    }

}
