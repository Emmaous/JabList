/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.TagsGroup7;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author phil
 */
@Local
public interface TagFacadeLocal {
    
    public void create(TagsGroup7 users);

    public void edit(TagsGroup7 users);

    public void remove(TagsGroup7 users);

    public TagsGroup7 find(Object id);
    
    public TagsGroup7 findByTag(String tag);
    
    public List<TagsGroup7> findAll();

    public List<TagsGroup7> findRange(int[] range);

    public int count();
}
