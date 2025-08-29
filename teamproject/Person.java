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
public abstract class Person {
    private String name;
    private String Id;
    private UserInterface ui;
    public abstract void login();

    public Person(UserInterface ui) {
        this.ui = ui;
    }
    

    public UserInterface getUi() {
        return ui;
    }

    public void setUi(UserInterface ui) {
        this.ui = ui;
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return Id;
    }
    
    
}
