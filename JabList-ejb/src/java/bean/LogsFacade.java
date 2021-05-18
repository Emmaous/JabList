/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Logs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Okechukwu Okonwanji
 */
@Stateless
public class LogsFacade extends AbstractFacade<Logs> implements remote.LogsFacadeRemote {

    @PersistenceContext(unitName = "JabList-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LogsFacade() {
        super(Logs.class);
    }
    
}
