/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;


import ejb.*;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.*;

/**
 *
 * @author Zoldyck-PC
 */
@Named(value = "greetingManager")
@RequestScoped
public class GreetingManager {
    
    private String welcome_msg;
    private boolean access = false;

    @EJB
    WelcomeMessageBeanLocal homepage_greeting;
    
    /**
     * Creates a new instance of GreetingManager
     */
    public GreetingManager() {
    }

    public String getWelcome_msg() {
        return welcome_msg;
    }

    public void setWelcome_msg(String welcome_msg) {
        this.welcome_msg = welcome_msg;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
    
    public void greetUser() {
        access = true;
        welcome_msg = homepage_greeting.welcomeUser();
    }
}
