/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author ZAHI
 */
public class Customer extends Person{
    public String UserName;
    public String password;
    public static ArrayList<Customer>customerList = new ArrayList<>();;
    public ArrayList<Payment>payments = new ArrayList<>();


    public Customer(String UserName, String password,UserInterface ui) {
        super(ui);
        this.UserName = UserName;
        this.password = password;
    }
    @Override
    public void login(){
        if (!customerList.contains(this)) {
            customerList.add(this);
        }
        getUi().showUserMenu();     
    }
    public static void CustomerListFile(String filePath) {
    try (Formatter write = new Formatter(filePath)) {
        for (Customer c : customerList) {
            write.format("Customer name: %s\n" , c.getUserName());
        for (Payment p : c.payments) {
        if (p.isOrdered()) {
            write.format("Payment Method: %s\n" , p.getPaymentMethod());
            write.format("  Items Ordered:\n");
        for(MenuItem item: p.getOrder().getItems()){
            write.format("  -%s : %d BTD \n",item.getName(),item.getPrice());
        }
        write.format("--------------------\n");
        }
        }
        }
        write.format("Total Customers: %d\n" ,customerList.size());
    } catch (FileNotFoundException e) {
        System.out.println("Failed to find the file " + e.getMessage());
    }
}
    public void addPayment(Payment p) {
        payments.add(p);
    }

    public int getTotalRevenue() {
        int total = 0;
        for (Payment p : payments) {
            if (p.isOrdered()) {
                total += p.getOrder().calculateTotal();
            }
        }
        return total;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
