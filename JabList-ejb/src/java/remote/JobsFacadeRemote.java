/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import entity.JobDescription;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author GROUP 2
 */
@Remote
public interface JobsFacadeRemote {

    public void create(JobDescription jobs);

    public void edit(JobDescription jobs);

    public void remove(JobDescription jobs);

    public JobDescription find(Object id);
    
    public JobDescription findByID(String id);

    public List<JobDescription> findAll();
    
    public List<JobDescription> findOpenJobs();
    
    public List<JobDescription> findJobsByProvider(String providerID);
    
    public List<JobDescription> findJobsByProviderStatus(String providerID, String status);

    public List<JobDescription> findRange(int[] range);
    
    public List<JobDescription> findJobsByjobID(String jobID);
    
    public List<JobDescription> findJobsByKeyword(String keyword);

    public int count(); 
}
