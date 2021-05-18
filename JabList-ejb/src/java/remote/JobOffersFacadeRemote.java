/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import entity.JobOffer;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author GROUP 2
 */
@Remote
public interface JobOffersFacadeRemote {

    public void create(JobOffer jobOffers);

    public void edit(JobOffer jobOffers);

    public void remove(JobOffer jobOffers);
    
    public void removeOfferByJob(String jobId);
    
    public  JobOffer findByFreelancerIDJobID(String freelancerID, String JobID);

    public  JobOffer find(Object id);
    
    public void removeCreatorByJob(String jobId);
    
    public List<JobOffer> findJobsByCreator(Object id);

    public List<JobOffer> findAll();
    
    public List<JobOffer> findOffersByFreelancer(String freelancerId, String status);
    
    public List<JobOffer> findOffersByJob(String jobId, String status);

    public List<JobOffer> findRange(int[] range);

    public int count();
}
