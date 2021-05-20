/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.FreeLancerFacadeLocal;
import ejb.UserFacadeLocal;
import entities.FreelancerDetailsGroup7;
import entities.UsersGroup7;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;

/**
 *
 * @author Zoldyck-PC
 */
@Named(value = "adminManagerBean")
@SessionScoped
public class AdminManagerBean implements Serializable {

    @EJB
    private FreeLancerFacadeLocal freeLancerFacade;

    @EJB
    private UserFacadeLocal userFacade;
    
    private String name;
    private String pword;
    
    //variables for fields of users
    private String cname;
    private String cpword;
    private String fname;
    private String fpword;
    private String fmessage;
    private String cid;

    /**
     * Creates a new instance of AdminManagerBean
     */
    public AdminManagerBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCpword() {
        return cpword;
    }

    public void setCpword(String cpword) {
        this.cpword = cpword;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFpword() {
        return fpword;
    }

    public void setFpword(String fpword) {
        this.fpword = fpword;
    }

    public String getFmessage() {
        return fmessage;
    }

    public void setFmessage(String fmessage) {
        this.fmessage = fmessage;
    }
    
    /**
     *
     * Method to print all providers
     *
     */
    public Collection<UsersGroup7> printProviders(){
        return userFacade.findByRoleName("PR");  
    }
    
    /**
     *
     * Method to print all Freelancer
     *
     * @param 
     * @return
     */
    public Collection<UsersGroup7> printFreelancers(){
        return userFacade.findByRoleName("FR");  
    }
    
    /**
     *
     * Method to delete a Provider
     *
     * @param
     * @return
     */
    public void removeProvider(UsersGroup7 provider){
        userFacade.remove(provider);
    }
    
    /**
     *
     * Method to delete a freelancer
     *
     * @param
     * @return
     */
    public void removeFreelancer(UsersGroup7 freelancer){
        freeLancerFacade.remove(freeLancerFacade.find(freelancer.getUserId()));
        userFacade.remove(freelancer);
    }
    
    /**
     *
     * Method to create a Provider
     *
     * @param
     * @return
     */
    public void createProvider(){
       String id = "001";
       UsersGroup7 user = new UsersGroup7(id, cname, cpword, "PR");
       userFacade.create(user);
    }
    
    /**
     *
     * Method to create a Freelancer
     *
     * @param
     * @return
     */
    public void createFreelancer(){
        String id = "002";
        UsersGroup7 user = new UsersGroup7(id, fname, fpword, "FR");
        FreelancerDetailsGroup7 free = new FreelancerDetailsGroup7(id, fmessage);
        userFacade.create(user);
        freeLancerFacade.create(free);
    }
       
}
