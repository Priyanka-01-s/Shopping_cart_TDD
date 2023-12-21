package com.example;

public class Item {
    
    private int itemId;
    private String itemName;
    private double itemPrice;
    
    public Item(int itemId, String itemName, double itemPrice){
        this.itemId=itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getId(){
        return itemId;
    }

    public String getName(){
        return itemName;
    }

    public double getPrice(){
        return itemPrice;
    }
}