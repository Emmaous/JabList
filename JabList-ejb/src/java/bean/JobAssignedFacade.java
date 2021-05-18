/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.JobOffer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Okechukwu Okonwanji 
 */
@Stateless
public class JobAssignedFacade extends AbstractFacade<JobOffer> implements remote.JobAssignedFacadeRemote {

    @PersistenceContext(unitName = "JabList-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JobAssignedFacade() {
        super(JobOffer.class);
    }
    
}
