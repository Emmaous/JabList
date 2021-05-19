/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.JobsGroup7;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author phil
 */
@Local
public interface JobFacadeLocal {
    public void create(JobsGroup7 skill);

    public void edit(JobsGroup7 skill);

    public void remove(JobsGroup7 skill);

    public JobsGroup7 find(Object id);
    
    public List<JobsGroup7> findAll();

    public List<JobsGroup7> findRange(int[] range);

    public int count();
}
