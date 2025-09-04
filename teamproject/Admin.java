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
public class Admin extends Person {
    public String UserName;
    public String password;

    public Admin (String UserName, String password,UserInterface ui ) {
        super(ui);
        this.UserName = UserName;
        this.password = password;
    }
    @Override
    public void login(){
        Login l = new Login();
        if(l.check(this)){
            getUi().showAdminFiles();
    }
        else getUi().showError("Wrong Password or Username, Try again");
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