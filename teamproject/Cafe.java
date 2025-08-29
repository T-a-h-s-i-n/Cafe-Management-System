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
public class Cafe {

    Menu menu = new Menu();

    public void setUpMenuDrink() {
        //Hot drinks
        menu.addItem(new MenuItem("Espresso", 330));
        menu.addItem(new MenuItem("Cappuccino", 440));
        menu.addItem(new MenuItem("Latte", 440));
        menu.addItem(new MenuItem("Mocha", 495));
        menu.addItem(new MenuItem("Hot Chocolate", 385));
        menu.addItem(new MenuItem("Green Tea", 330));
        //cold drinks
        menu.addItem(new MenuItem("Iced Coffee", 385));
        menu.addItem(new MenuItem("Lemonade", 330));
        menu.addItem(new MenuItem("Orange Juice", 330));
        menu.addItem(new MenuItem("Mango Juice", 385));
        menu.addItem(new MenuItem("Milkshake", 440));
        menu.addItem(new MenuItem("Boba Tea", 495));
    }
    
    public MenuItem findItemByName(String name) {
            for (MenuItem item : menu.getItems()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return item;
                }
            }
            return null;
        }

    protected class Menu {

        private ArrayList<MenuItem> items = new ArrayList<>();

        public void addItem(MenuItem item) {
            items.add(item);
        }

        public ArrayList<MenuItem> getItems() {
            return items;
        }

    }

}
