/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.JobsGroup7;
import entities.UsersGroup7;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author phil
 */
@Stateless
public class JobFacade extends AbstractFacade<JobsGroup7> implements JobFacadeLocal {
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "JabList-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobFacade() {
        super(JobsGroup7.class);
    }
    
    /**
     *
     * @param user
     * @param jobId
     */
    @Override
    public void applyForJob(UsersGroup7 user, String jobId) {
        
        JobsGroup7 test = getEntityManager().createNamedQuery("JobsGroup7.findByJobId", JobsGroup7.class)
                .setParameter("jobId", jobId)
                .getSingleResult();
        test.getUsersGroup7Collection().add(user);
        em.persist(test);
    }
    
    @Override
    public List<JobsGroup7> findJobsByProvider(Object id) {
        return getEntityManager().createNamedQuery("JobsGroup7.findByProviderId", JobsGroup7.class)
                .setParameter("providerId", id)
                .getResultList();
    }
    
    @Override
    public List<JobsGroup7> findOffersByFreelancer(String freelancerId, String status) {
        return getEntityManager().createNamedQuery("JobOffers.findByFreelancerIdAndStatus", JobsGroup7.class)
                .setParameter("freelancerId", "freelancerId")
                .setParameter("status", "Open")
                .getResultList();
    }

    
}
