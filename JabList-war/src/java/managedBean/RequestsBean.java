/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.UserFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Zoldyck-PC
 */
@Named(value = "requestsBean")
@RequestScoped
public class RequestsBean {

    @EJB
    private UserFacadeLocal userFacade;

    
    private String searchKeyword;
    private String username;
    private String pword;
    
    
    /**
     * Creates a new instance of RequestsBean
     */
    public RequestsBean() {
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }
    
    public void validateUser(){
        //userFacade.
    }
    /**
     *
     * Method to search for job by id
     *
     * @param
     * @return
     */
    public void searchByID(){
        
    }
    
    /**
     *
     * Method to search for job by keywords
     *
     * @param
     * @return
     */
    public void searchByKeyword(){
        
    }
}
