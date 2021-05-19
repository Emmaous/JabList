/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.TagsGroup7;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author phil
 */
@Stateless
public class TagFacade extends AbstractFacade<TagsGroup7> implements TagFacadeLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "JabList-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TagFacade() {
        super(TagsGroup7.class);
    }
    
    @Override
    public TagsGroup7 findByTag(String tag) {
        return getEntityManager().createNamedQuery("TagsGroup7.findByTag", TagsGroup7.class)
                .setParameter("tag", tag)
                .getSingleResult();
    }
}
