/* Solution to Chapter 6, Exercise 1 in Teach Yourself Java in 21 Days (Covering Java 8
   and Android by Rogers Cadenhead. */

package com.java21days;

public class Item2 implements Comparable {
    private String id;
    private String name;
    private double retail;
    private int quantity;
    private double price;
    private boolean noDiscount;

    Item2(String idIn, String nameIn, String retailIn, String quanIn, String discountIn) {
        id = idIn;
        name = nameIn;
        retail = Double.parseDouble(retailIn);
        quantity = Integer.parseInt(quanIn);
        noDiscount = discountIn.equals("TRUE");
        
        if (quantity > 400) {
            price = retail * .5D;
        } else if (quantity > 200) {
            price = retail * .6D;
        } else {
            price = retail * .7D;
        }
        price = Math.floor( price * 100 + .5 ) / 100;
        if (noDiscount) {
            price = retail;
        }
    }

    public int compareTo(Object obj) {
        Item2 temp = (Item2)obj;
        if (this.price < temp.price) {
            return 1;
        } else if (this.price > temp.price) {
            return -1;
        }
        return 0; 
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRetail() {
        return retail;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
