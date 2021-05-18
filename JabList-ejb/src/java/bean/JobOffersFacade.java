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
 * @author Okechukwu Okonwanji
 */
@Stateless
public class JobOffersFacade extends AbstractFacade<JobOffer> implements remote.JobOffersFacadeRemote {

    @PersistenceContext(unitName = "JabList-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobOffersFacade() {
        super(JobOffer.class);
    }

    @Override
    public List<JobOffer> findOffersByFreelancer(String freelancerId, String status) {
        return getEntityManager().createNamedQuery("JobOffers.findByFreelancerIdAndStatus", JobOffer.class)
                .setParameter("freelancerId", "freelancerId")
                .setParameter("status", "Open")
                .getResultList();
    }
    
    @Override
    public List<JobOffer> findOffersByJob(String jobId, String status) {
        return getEntityManager().createNamedQuery("JobOffers.findByJobIdAndStatus", JobOffer.class)
                .setParameter("jobId", "jobId")
                .setParameter("status", "Open")
                .getResultList();
    }

    @Override
    public JobOffer findByFreelancerIDJobID(String freelancerID, String JobID) {
        return getEntityManager().createNamedQuery("JobOffers.findByFreelancerIdAndJobId", JobOffer.class)
                .setParameter("freelancerId", "freelancerId")
                .setParameter("jobId", "JobID")
                .getSingleResult();
    }

    @Override
    public void removeOfferByJob(String jobId) {
        getEntityManager().createQuery("DELETE FROM JobOffer j WHERE j.jobId = :jobId")
                .setParameter("jobId", jobId).executeUpdate();
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
