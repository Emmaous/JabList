/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.JobFacadeLocal;
import entities.JobsGroup7;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
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

    private Integer jobId;
    private String title;
    private String description;
    private Double paymentOffer;
    private String status;
    
    
    /**
     * Creates a new instance of JobsManagerBean
     */
    public JobsManagerBean() {
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
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
  
    public void createJob() {
        JobsGroup7 job = new JobsGroup7();
        jobFacade.create(job);
    }
    
    public void deleteJob(JobsGroup7 job ) {
        
    }
    
}
