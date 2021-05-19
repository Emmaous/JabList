/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import ejb.UserFacadeLocal;
import entities.SkillsGroup7;
import entities.UsersGroup7;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
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
    private SkillsGroup7 skill;
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

    public SkillsGroup7 getSkill() {
        return skill;
    }

    public void setSkill(SkillsGroup7 skill) {
        this.skill = skill;
    }
    
    public List<SkillsGroup7> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillsGroup7> skills) {
        this.skills = skills;
    }
    
    public void addSkill(){
        skills.add(skill);
    }
    
    public void createProvider(){
       String id = "";
       UsersGroup7 user = new UsersGroup7(id, name, pword, "PR");
       userFacade.createProvider(user);
    }
    
    public Collection<UsersGroup7> printProviders(){
        return userFacade.findByRoleName("PR");  
    }
    
    public Collection<UsersGroup7> printFreelancers(){
        return userFacade.findByRoleName("FR");  
    }
    
    public void removeProvider(UsersGroup7 provider){
        userFacade.remove(provider);
    }
    
    public void removeFreelancer(UsersGroup7 freelancer){
        userFacade.remove(freelancer);
        
    }
    
    public void createFreelancer(){
        String id = "";
        UsersGroup7 user = new UsersGroup7(id, name, pword, "FR");
        userFacade.createFreelancer(user, message, skills);
    }
    
    
}
