/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "USERS_GROUP7")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersGroup7.findAll", query = "SELECT u FROM UsersGroup7 u"),
    @NamedQuery(name = "UsersGroup7.findByName", query = "SELECT u FROM UsersGroup7 u WHERE u.name = :name"),
    @NamedQuery(name = "UsersGroup7.findByPassword", query = "SELECT u FROM UsersGroup7 u WHERE u.password = :password"),
    @NamedQuery(name = "UsersGroup7.findByUserId", query = "SELECT u FROM UsersGroup7 u WHERE u.userId = :userId"),
    @NamedQuery(name = "UsersGroup7.findByRole", query = "SELECT u FROM UsersGroup7 u WHERE u.role = :role")})
public class UsersGroup7 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PASSWORD")
    private String password;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USER_ID")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ROLE")
    private String role;
    @ManyToMany(mappedBy = "usersGroup7Collection")
    private Collection<JobsGroup7> jobsGroup7Collection;
    @JoinTable(name = "FREELANCER_SKILLS_GROUP7", joinColumns = {
        @JoinColumn(name = "FREELANCER_ID", referencedColumnName = "USER_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SKILL_ID", referencedColumnName = "SKILLS_ID")})
    @ManyToMany
    private Collection<SkillsGroup7> skillsGroup7Collection;
    @OneToMany(mappedBy = "providerId")
    private Collection<JobsGroup7> jobsGroup7Collection1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usersGroup7")
    private FreelancerDetailsGroup7 freelancerDetailsGroup7;

    public UsersGroup7() {
    }

    public UsersGroup7(String userId) {
        this.userId = userId;
    }

    public UsersGroup7(String userId, String name, String password, String role) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public Collection<JobsGroup7> getJobsGroup7Collection() {
        return jobsGroup7Collection;
    }

    public void setJobsGroup7Collection(Collection<JobsGroup7> jobsGroup7Collection) {
        this.jobsGroup7Collection = jobsGroup7Collection;
    }

    @XmlTransient
    public Collection<SkillsGroup7> getSkillsGroup7Collection() {
        return skillsGroup7Collection;
    }

    public void setSkillsGroup7Collection(Collection<SkillsGroup7> skillsGroup7Collection) {
        this.skillsGroup7Collection = skillsGroup7Collection;
    }

    @XmlTransient
    public Collection<JobsGroup7> getJobsGroup7Collection1() {
        return jobsGroup7Collection1;
    }

    public void setJobsGroup7Collection1(Collection<JobsGroup7> jobsGroup7Collection1) {
        this.jobsGroup7Collection1 = jobsGroup7Collection1;
    }

    public FreelancerDetailsGroup7 getFreelancerDetailsGroup7() {
        return freelancerDetailsGroup7;
    }

    public void setFreelancerDetailsGroup7(FreelancerDetailsGroup7 freelancerDetailsGroup7) {
        this.freelancerDetailsGroup7 = freelancerDetailsGroup7;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersGroup7)) {
            return false;
        }
        UsersGroup7 other = (UsersGroup7) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UsersGroup7[ userId=" + userId + " ]";
    }
    
}
