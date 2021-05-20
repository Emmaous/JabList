/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.FreeLancerFacadeLocal;
import ejb.JobFacadeLocal;
import entities.JobsGroup7;
import entities.UsersGroup7;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Zoldyck-PC
 */
@Named(value = "providerManagerBean")
@SessionScoped
public class ProviderManagerBean implements Serializable {

    @EJB
    private FreeLancerFacadeLocal freeLancerFacade;

    @EJB
    private JobFacadeLocal jobFacade;
    
    
    
    private String name;
    private String pword;
    private String id;
    
    private JobsGroup7 job;
    private UsersGroup7 flancer;
    
    /**
     * Creates a new instance of ProviderManagerBean
     */
    public ProviderManagerBean() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JobsGroup7 getJob() {
        return job;
    }

    public void setJob(JobsGroup7 job) {
        this.job = job;
    }

    public UsersGroup7 getFlancer() {
        return flancer;
    }

    public void setFlancer(UsersGroup7 flancer) {
        this.flancer = flancer;
    }
 
    public List<JobsGroup7> printAllProvJobs(){
        return jobFacade.findJobsByProvider(id);
    
    }
    
     public String viewFreelancer(UsersGroup7 freelancer){
        flancer = freelancer;
        return "freeDetails";
        
    }
    
    public void acceptFreelancer(){
        
        
    }
    
    public String printFName(){
        return flancer.getName();
    }
    
    public String printFMessage(){
        return freeLancerFacade.find(flancer.getUserId()).getMessage();
    }
}
