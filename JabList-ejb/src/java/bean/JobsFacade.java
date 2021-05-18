/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.JobDescription;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Okechukwu Okonwanji
 */
@Stateless
public class JobsFacade extends AbstractFacade<JobDescription> implements remote.JobsFacadeRemote {

    @PersistenceContext(unitName = "JabList-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobsFacade() {
        super(JobDescription.class);
    }

    @Override
    public List<JobDescription> findOpenJobs() {
        return getEntityManager().createNamedQuery("Jobs.findByStatus", JobDescription.class).setParameter("status", "Open").getResultList();
    }

    @Override
    public List<JobDescription> findJobsByProvider(String providerID) {
        return getEntityManager().createNamedQuery("Jobs.findOpenByProvider", JobDescription.class).setParameter("createdby", providerID).getResultList();
    }

    @Override
    public List<JobDescription> findJobsByProviderStatus(String providerID, String status) {
        return getEntityManager().createNamedQuery("Jobs.findByStatusByProvider", JobDescription.class)
                .setParameter("createdby", providerID)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public List<JobDescription> findJobsByjobID(String jobID) {
        return getEntityManager().createNamedQuery("Jobs.findByJobId", JobDescription.class)
                .setParameter("jobId", jobID)
                .getResultList();
    }

    @Override
    public List<JobDescription> findJobsByKeyword(String keyword) {
        return getEntityManager().createNamedQuery("Jobs.findByKeyword", JobDescription.class)
                .setParameter("keywords", keyword)
                .getResultList();
    }

    @Override
    public JobDescription findByID(String id) {
        return getEntityManager().createNamedQuery("Jobs.findByJobId", JobDescription.class)
                .setParameter("jobId", id)
                .getSingleResult();
    }
    
}
