/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import entity.Logs;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Okechukwu Okonwanji 
 */
@Remote
public interface LogsFacadeRemote {

    public void create(Logs logs);

    public void edit(Logs logs);

    public void remove(Logs logs);

    public Logs find(Object id);

    public List<Logs> findAll();

    public List<Logs> findRange(int[] range);

    public int count();
}
