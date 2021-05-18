/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Roles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Okechukwu Okonwanji
 */
@Stateless
public class UserRolesFacade extends AbstractFacade<Roles> implements remote.UserRolesFacadeRemote {

    @PersistenceContext(unitName = "JabList-ejbPU")
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
