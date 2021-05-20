/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.FreeLancerFacadeLocal;
import ejb.SkillFacadeLocal;
import ejb.UserFacadeLocal;
import entities.JobsGroup7;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Zoldyck-PC
 */
@Named(value = "freelancerManagerBean")
@RequestScoped
public class FreelancerManagerBean {

    @EJB
    private SkillFacadeLocal skillFacade;

    @EJB
    private FreeLancerFacadeLocal freeLancerFacade;

    @EJB
    private UserFacadeLocal userFacade;

    
    
    private String name;
    private String id;
    private String pword;
    
    /**
     * Creates a new instance of FreelancerManagerBean
     */
    public FreelancerManagerBean() {
    }
  
    /**
     *
     * Method to print a Freelancer offers
     *
     * @param
     * @return
     */
    public List<JobsGroup7> printOffers(){
        return null;
    }
}
