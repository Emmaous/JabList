/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.LogsGroup7;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author phil
 */
@Remote
public interface LogFacadeRemote {
    public void create(LogsGroup7 skill);

    public void edit(LogsGroup7 skill);

    public void remove(LogsGroup7 skill);

    public LogsGroup7 find(Object id);
    
    public List<LogsGroup7> findAll();

    public List<LogsGroup7> findRange(int[] range);

    public int count();
    
}
