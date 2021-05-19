/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.JobFacadeLocal;
import entities.JobsGroup7;
import entities.UsersGroup7;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;

/**
 *
 * @author Zoldyck-PC
 */
@Named(value = "jobsManagerBean")
@SessionScoped
public class JobsManagerBean implements Serializable {

    @EJB
    private JobFacadeLocal jobFacade;

    private String title;
    private String description;
    private Double paymentOffer;
    private String status;
    private JobsGroup7 cjob;
    private UUID uuid1 = UUID.randomUUID();
  //  private int jobId = (int) uuid1.toString().substring(0,7);
    
    
    /**
     * Creates a new instance of JobsManagerBean
     */
    public JobsManagerBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPaymentOffer() {
        return paymentOffer;
    }

    public void setPaymentOffer(Double paymentOffer) {
        this.paymentOffer = paymentOffer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<JobsGroup7> printAllJobs(){
        return null;     
    };
  
    public void createJob(UsersGroup7 providerId) {
        
        JobsGroup7 job = new JobsGroup7(001, title, description, paymentOffer, status, providerId);
        jobFacade.create(job);
    }
    
    public void deleteJob(JobsGroup7 job ) {
        
    }

    public JobsGroup7 getCjob() {
        return cjob;
    }

    public void setCjob(JobsGroup7 cjob) {
        this.cjob = cjob;
    }
    
    public String viewJob(JobsGroup7 job){
        //this.title = ;
        return "jobDetails";
    }
    
    public void acceptFreelancer(UsersGroup7 freelancer){
       
    }
}
