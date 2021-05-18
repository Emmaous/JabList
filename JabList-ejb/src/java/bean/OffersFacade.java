/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Offers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GROUP 2
 */
@Stateless
public class OffersFacade extends AbstractFacade<Offers> implements remote.OffersFacadeRemote {

    @PersistenceContext(unitName = "JabList-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OffersFacade() {
        super(Offers.class);
    }
    
}
