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
 * @author Okechukwu Okonwanji
 */
@Remote
public interface JobCreatorFacadeRemote {

    public void create(JobOffer jobCreator);

    public void edit(JobOffer jobCreator);

    public void remove(JobOffer jobCreator);
    
    public void removeCreatorByJob(String jobId);
    
    public List<JobOffer> findJobsByCreator(Object id);

    public JobOffer find(Object id);

    public List<JobOffer> findAll();

    public List<JobOffer> findRange(int[] range);

    public int count();
    
}
