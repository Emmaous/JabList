/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import entity.Roles;
import entity.Users;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Okechukwu Okonwanji
 */
@Remote
public interface UsersFacadeRemote {

    public String testMethod(String saying);
    
    public void create(Users users);

    public void edit(Users users);

    public void remove(Users users);

    public Users find(Object id);

    public List<Users> findAll();
    
    public List<Roles> findByRoleName(String roleName);

    public List<Users> findRange(int[] range);

    public int count();
}
