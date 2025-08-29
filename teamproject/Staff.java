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
public class Staff extends Person {
    public String UserName;
    public String password;
    ArrayList<Customer>customer;

    public Staff(String UserName, String password,UserInterface ui ) {
        super(ui);
        this.UserName = UserName;
        this.password = password;
        customer = new ArrayList<>();
    }
    @Override
    public void login(){
        Login l = new Login();
        if(l.check(this)){
            getUi().showUserMenu();
        
    }
        else if (l.check(this, UserName)){
            getUi().showUserMenu();
    }
        else System.out.println("Code running.....");}
    
    
    

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
