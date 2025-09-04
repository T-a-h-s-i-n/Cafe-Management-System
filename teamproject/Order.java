/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

import java.util.ArrayList;

/**
 *
 * @author ZAHI
 */
public class Order {

    private ArrayList<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public int calculateTotal() {
        int total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;

    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }
}
    
