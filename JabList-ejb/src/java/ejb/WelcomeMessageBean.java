/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author Zoldyck-PC
 */
@Stateless
public class WelcomeMessageBean implements WelcomeMessageBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public String welcomeUser(){
        return "Welcome to JabList :)";
    }
}