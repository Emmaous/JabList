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
public interface JobAssignedFacadeRemote {

    public void create(JobOffer jobAssigned);

    public void edit(JobOffer jobAssigned);

    public void remove(JobOffer jobAssigned);

    public JobOffer find(Object id);

    public List<JobOffer> findAll();

    public List<JobOffer> findRange(int[] range);

    public int count();
    
}
