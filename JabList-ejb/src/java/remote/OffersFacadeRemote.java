/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import entity.Offers;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Okechukwu Okonwanji
 */
@Remote
public interface OffersFacadeRemote {

    public void create(Offers offers);

    public void edit(Offers offers);

    public void remove(Offers offers);

    public Offers find(Object id);

    public List<Offers> findAll();

    public List<Offers> findRange(int[] range);

    public int count();
}
