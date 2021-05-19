/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.SkillsGroup7;
import entities.UsersGroup7;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author phil
 */
@Local
public interface UserFacadeLocal {
    
    public void create(UsersGroup7 users);

    public void edit(UsersGroup7 users);

    public void remove(UsersGroup7 users);

    public UsersGroup7 find(Object id);
    
    public UsersGroup7 findByUserId(String userid);
    
    public UsersGroup7 createFreelancer(UsersGroup7 user, String msg);
    
    public UsersGroup7 createProvider(UsersGroup7 user);

    public Collection<UsersGroup7> findAll();
    
    public Collection<UsersGroup7> findByRoleName(String roleName);

    public Collection<UsersGroup7> findRange(int[] range);

    public int count();
}
