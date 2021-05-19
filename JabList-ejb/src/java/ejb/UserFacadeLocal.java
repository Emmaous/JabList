/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.UsersGroup7;
import java.util.Collection;
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

    public Collection<UsersGroup7> findAll();
    
    public Collection<UsersGroup7> findByRoleName(String roleName);

    public Collection<UsersGroup7> findRange(int[] range);

    public int count();
}
