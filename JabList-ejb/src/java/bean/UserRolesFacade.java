/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Roles;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GROUP 2
 */
@Stateless
public class UserRolesFacade extends AbstractFacade<Roles> implements remote.UserRolesFacadeRemote {

    @PersistenceContext(unitName = "JabList-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserRolesFacade() {
        super(Roles.class);
    }

    @Override
    public Roles findByUserId(String userid) {
        return em.createNamedQuery("UserRoles.findByUserId",Roles.class)
                .setParameter("userId", userid)
                .getSingleResult();
    }
    
}
