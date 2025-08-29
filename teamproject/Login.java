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
public class Login {
    
    private final String adminName = "admin2025";
    private final String adpassword = "coffee";
    private final String stpassword = "cup";

    public Login() {
    }
    
    
    public boolean check(Customer customer,String UserName, String password){
        
        return customer.getUserName().equals(UserName) && customer.getPassword().equals(password);
        
    }
    public boolean check(Staff admin){
        return admin.getUserName().equals(adminName) && admin.getPassword().equals(adpassword);
    }
     public boolean check(Staff staff,String UserName){
        return staff.getUserName().equals(UserName) && staff.getPassword().equals(stpassword);
    }
    
    
    
}
