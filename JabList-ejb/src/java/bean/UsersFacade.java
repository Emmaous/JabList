/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Roles;
import entity.Users;
import utils.AuthenticationUtils;
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
 * @author Okechukwu Okonwanji
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements remote.UsersFacadeRemote {

    @PersistenceContext(unitName = "JabList-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    @Override
    public String testMethod(String saying) {
        return "Echoing: " + saying;
    }
    
    public Users createUser(Users user,String roleName) {
		try {
			user.setPassword(AuthenticationUtils.encodeSHA256(user.getPassword()));
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
		}
		Roles role = new Roles();
		role.setUsers(user);
                role.setRoleName(roleName);
                role.setUserId(user.getUserId());
                em.persist(user);
		em.persist(role);
		
		return user;
	}

    @Override
    public List<Roles> findByRoleName(String roleName) {
        return em.createNamedQuery("UserRoles.findByRoleName")
                .setParameter("roleName", roleName)
                .getResultList();
    }
    
}
