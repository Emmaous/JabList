/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.SkillsGroup7;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author phil
 */
@Local
public interface SkillFacadeLocal {
    
    public void create(SkillsGroup7 skill);

    public void edit(SkillsGroup7 skill);

    public void remove(SkillsGroup7 skill);

    public SkillsGroup7 find(Object id);
    
    public List<SkillsGroup7> findAll();

    public List<SkillsGroup7> findRange(int[] range);

    public int count();
}
