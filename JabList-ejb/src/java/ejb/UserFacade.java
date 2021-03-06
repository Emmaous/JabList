/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.FreelancerDetailsGroup7;
import entities.JobsGroup7;
import entities.SkillsGroup7;
import entities.TagsGroup7;
import utils.AuthenticationUtils;
import entities.UsersGroup7;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author phil
 */
@Stateless
public class UserFacade extends AbstractFacade<UsersGroup7> implements UserFacadeLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "JabList-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(UsersGroup7.class);
    }

    /**
     * 
     * Method to Create a Freelancer
     * 
     * @param user
     * @param msg
     * @param skills
     * @return 
     */
    @Override
    public UsersGroup7 createFreelancer(UsersGroup7 user, String msg) {
        try {
            user.setPassword(AuthenticationUtils.encodeSHA256(user.getPassword()));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }

        FreelancerDetailsGroup7 free = new FreelancerDetailsGroup7();
        free.setUsersGroup7(user);
        free.setFreelancerId(user.getUserId());
        free.setMessage(msg);
        //skills.forEach(skill -> {  
        //    em.persist(skill);
        //});
        
        em.persist(user);
        em.persist(free);
        
        return user;
    }
    
    /**
     * 
     * Method to Create a Provider
     * 
     * @param user
     * @return 
     */
    @Override
    public UsersGroup7 createProvider(UsersGroup7 user) {
        try {
            user.setPassword(AuthenticationUtils.encodeSHA256(user.getPassword()));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        
        em.persist(user);
        
        return user;
    }

    /**
     * 
     * Method to Find users by Role
     * 
     * @param user
     * @return 
     */
    @Override
    public List<UsersGroup7> findByRoleName(String roleName) {
        return em.createNamedQuery("UsersGroup7.findByRole")
                .setParameter("role", roleName)
                .getResultList();
    }
    
    /**
     * 
     * Method to Find users by Name
     * 
     * @param name
     * @return 
     */
    @Override
    public List<UsersGroup7> findByName(String name) {
        return em.createNamedQuery("UsersGroup7.findByName")
                .setParameter("name", name)
                .getResultList();
    }
    
    /**
     * 
     * Method to Find users by Password
     * 
     * @param password
     * @return 
     */
    @Override
    public List<UsersGroup7> findByPassword(String password) {
        return em.createNamedQuery("UsersGroup7.findByPassword")
                .setParameter("password", password)
                .getResultList();
    }

    /**
     * 
     * Method to find users by ID
     * 
     * @param userid
     * @return 
     */
    @Override
    public UsersGroup7 findByUserId(String userid) {
        return em.createNamedQuery("UsersGroup7.findByUserId", UsersGroup7.class)
                .setParameter("userId", userid)
                .getSingleResult();
    }
    
    /**
     * 
     * Method to find users by ID
     * 
     * @param jobId
     * @param free
     * @return 
     */
    @Override
    public List<JobsGroup7> jobsGroup7Collection(int jobId, String free) {
        return getEntityManager().createNamedQuery("JobsGroup7.findByFreelancerIdAndJobId", JobsGroup7.class)
                .setParameter("jobId", jobId)
                .setParameter("freelancerId", free)
                .getResultList();
    }
}
