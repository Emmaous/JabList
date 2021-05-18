/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import entity.Roles;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Okechukwu Okonwanji
 */
@Remote
public interface UserRolesFacadeRemote {

    public void create(Roles userRoles);

    public void edit(Roles userRoles);

    public void remove(Roles userRoles);

    public Roles find(Object id);

    public List<Roles> findAll();

    public List<Roles> findRange(int[] range);
    
    public Roles findByUserId(String userid);

    public int count();
}
