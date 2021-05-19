/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.UsersGroup7;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Zoldyck-PC
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {

    @PersistenceContext(unitName = "JabList-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public void createUser(String name, String pword, String role) {
        
        // create customer object
        UsersGroup7 u = new UsersGroup7("001");

        // make new customer persistent
        // this creates a new entry in the DB at the end of the current
        // transaction
        persist(u);
        // set city and name and state
        u.setName(name);
        u.setPassword(pword);
        u.setRole(role);

    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
