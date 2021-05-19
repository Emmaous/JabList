/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.JobsGroup7;
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
    
    @Override
    public List<JobsGroup7> findJobsByProvider(Object id) {
        return getEntityManager().createNamedQuery("JobsGroup7.findByProviderId", JobsGroup7.class)
                .setParameter("providerId", id)
                .getResultList();
    }
}
