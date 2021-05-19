/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.FreelancerDetailsGroup7;
import entities.SkillsGroup7;
import entities.TagsGroup7;
import utils.AuthenticationUtils;
import entities.UsersGroup7;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
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

    public UsersGroup7 createFreelancer(UsersGroup7 user, String msg, String skill, String roleName) {
        try {
            user.setPassword(AuthenticationUtils.encodeSHA256(user.getPassword()));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }

        FreelancerDetailsGroup7 free = new FreelancerDetailsGroup7();
        SkillsGroup7 skills = new SkillsGroup7();
        free.setUsersGroup7(user);
        free.setFreelancerId(user.getUserId());
        free.setMessage(msg);
        skills.setSkill(skill);
        
        em.persist(user);
        em.persist(free);
        em.persist(skills);
        
        return user;
    }
    
    public UsersGroup7 createProvider(UsersGroup7 user, String roleName) {
        try {
            user.setPassword(AuthenticationUtils.encodeSHA256(user.getPassword()));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
        }
        
        em.persist(user);
        
        return user;
    }

    @Override
    public Collection<UsersGroup7> findByRoleName(String roleName) {
        return em.createNamedQuery("UsersGroup7.findByRole")
                .setParameter("roleName", roleName)
                .getResultList();
    }

    @Override
    public UsersGroup7 findByUserId(String userid) {
        return em.createNamedQuery("UsersGroup7.findByUserId", UsersGroup7.class)
                .setParameter("userId", userid)
                .getSingleResult();
    }
}
