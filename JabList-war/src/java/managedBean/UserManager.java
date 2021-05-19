/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.UserFacadeLocal;
import ejb.UserSessionBeanLocal;
import entities.SkillsGroup7;
import entities.TagsGroup7;
import entities.UsersGroup7;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Zoldyck-PC
 */
@Named(value = "userManager")
@SessionScoped
public class UserManager implements Serializable {

    @EJB
    private UserFacadeLocal userFacade;
  
    private String name;
    private String pword;
    private String message;
    private String role;
    private List<SkillsGroup7> skills;
    
    /**
     * Creates a new instance of UserManager
     */
    public UserManager() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getDescription() {
        return message;
    }

    public void setDescription(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<SkillsGroup7> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillsGroup7> skills) {
        this.skills = skills;
    }
    
    public void createProvider(){
        UsersGroup7 user = new UsersGroup7();
        userFacade.createFreelancer(user, message, skills, role);
    }
    
    public void createFreelancer(){
        
    }
    
    
}
