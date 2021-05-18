/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.JobOffer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GROUP 2
 */
@Stateless
public class JobCreatorFacade extends AbstractFacade<JobOffer> implements remote.JobCreatorFacadeRemote {

    @PersistenceContext(unitName = "JabList-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobCreatorFacade() {
        super(JobOffer.class);
    }

    @Override
    public void removeCreatorByJob(String jobId) {
        getEntityManager().createQuery("DELETE FROM JobCreator j WHERE j.jobCreatorPK.jobId = :jobId")
                .setParameter("jobId", jobId).executeUpdate();
    }

    @Override
    public List<JobOffer> findJobsByCreator(Object id) {
        return getEntityManager().createNamedQuery("JobCreator.findByCreatedby", JobOffer.class)
                .setParameter("createdby", id)
                .getResultList();
    }
    
}
