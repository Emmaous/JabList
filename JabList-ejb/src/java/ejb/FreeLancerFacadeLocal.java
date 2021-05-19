/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.FreelancerDetailsGroup7;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author phil
 */
@Local
public interface FreeLancerFacadeLocal {
    public void create(FreelancerDetailsGroup7 skill);

    public void edit(FreelancerDetailsGroup7 skill);

    public void remove(FreelancerDetailsGroup7 skill);

    public FreelancerDetailsGroup7 find(Object id);
    
    public List<FreelancerDetailsGroup7> findAll();

    public List<FreelancerDetailsGroup7> findRange(int[] range);

    public int count();
}
