/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.JobFacadeLocal;
import ejb.UserFacadeLocal;
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
    private UserFacadeLocal userFacade;

    @EJB
    private JobFacadeLocal jobFacade;  

    private String title;
    private String description;
    private Double paymentOffer;
    private String status;
    private JobsGroup7 cjob;
    
    
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
    
    /**
     *
     * Method to print all available jobs
     *
     * @param
     * @return
     */
    public List<JobsGroup7> printAllJobs(){
        return jobFacade.findAll();     
    };
  
    /**
     *
     * Method to create a job entity
     *
     * @param
     * @return
     */
    public void createJob(String providerId) {
        UsersGroup7 provider = userFacade.find(providerId);
        JobsGroup7 job = new JobsGroup7(001, title, description, paymentOffer, status, provider);
        jobFacade.create(job);
    }
    
    /**
     *
     * Method to delete a job
     *
     * @param
     * @return
     */
    public void deleteJob(JobsGroup7 job ) {
        jobFacade.remove(job);
    }

    public JobsGroup7 getCjob() {
        return cjob;
    }

    public void setCjob(JobsGroup7 cjob) {
        this.cjob = cjob;
    }
    
    /**
     *
     * Method to view details of a particular job
     *
     * @param
     * @return string of viewing page
     */
    public String viewJob(JobsGroup7 job){
        //this.title = ;
        return "jobDetails";
    }
    
    /**
     *
     * Method to accept a freelancer for a job
     *
     * @param
     * @return
     */
    public void acceptFreelancer(UsersGroup7 freelancer){
       
    }

}
