/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

/**
 *
 * @author ZAHI
 */
public class Customer extends Person{
    public String UserName;
    public String password;

    public Customer(String UserName, String password,UserInterface ui) {
        super(ui);
        this.UserName = UserName;
        this.password = password;
    }
    @Override
    public void login(){
        getUi().showUserMenu();     
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
    
    
 
    public void showInfo(){
        
    }
    
}
