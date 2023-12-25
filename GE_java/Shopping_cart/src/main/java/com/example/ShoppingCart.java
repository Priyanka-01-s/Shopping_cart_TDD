package com.example;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Item, Integer> cartItems = new HashMap<>();

    public void addItem(Item item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        cartItems.put(item, cartItems.getOrDefault(item, 0) + quantity);
    }

    public void removeItem(Item item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        int currentQuantity = cartItems.getOrDefault(item, 0);
        if (currentQuantity - quantity <= 0) {
            cartItems.remove(item);
        } else {
            cartItems.put(item, currentQuantity - quantity);
        }
    }

    public Map<Item, Integer> getCartItems() {
        return new HashMap<>(cartItems); // Return a copy to prevent external modifications
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (Map.Entry<Item, Integer> entry : cartItems.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            total += item.getPrice() * quantity;
        }
        return total;
    }
}
