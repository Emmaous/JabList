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
    
    
    
    public Collection<UsersGroup7> printProviders(){
        return userFacade.findByRoleName("PR");  
    }
    
    public Collection<UsersGroup7> printFreelancers(){
        return userFacade.findByRoleName("FR");  
    }
    
    public void removeProvider(UsersGroup7 provider){
        userFacade.remove(provider);
    }
    
    public void removeFreelancer(UsersGroup7 freelancer){
        userFacade.remove(freelancer);
        
    }
    
    public void createProvider(){
       String id = "001";
       UsersGroup7 user = new UsersGroup7(id, cname, cpword, "PR");
       userFacade.create(user);
    }
    
    public void createFreelancer(){
        String id = "002";
        UsersGroup7 user = new UsersGroup7(id, fname, fpword, "FR");
        FreelancerDetailsGroup7 free = new FreelancerDetailsGroup7(id, fmessage);
        userFacade.create(user);
        freeLancerFacade.create(free);
    }
       
}
