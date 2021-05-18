/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Okechukwu Okonwanji
 */
@Entity
@Table(name = "USERS", catalog = "", schema = "SA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findBySkills", query = "SELECT u FROM Users u WHERE u.skills = :skills")
    , @NamedQuery(name = "Users.findByMessage", query = "SELECT u FROM Users u WHERE u.message = :message")
    , @NamedQuery(name = "Users.findByBalance", query = "SELECT u FROM Users u WHERE u.balance = :balance")
    , @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USER_ID")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 500)
    @Column(name = "SKILLS")
    private String skills;
    @Size(max = 500)
    @Column(name = "MESSAGE")
    private String message;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BALANCE")
    private Float balance;
    @Size(max = 250)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<JobDescription> jobDescriptionList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
//    private List<JobOffer> jobOffersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<JobOffer> jobOfferList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<Roles> userRoles;

    public Users() {
    }

    public Users(String userId) {
        this.userId = userId;
    }

    public Users(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<JobDescription> getJobDescriptionList() {
        return jobDescriptionList;
    }

    public void setJobDescriptionList(List<JobDescription> jobDescriptionList) {
        this.jobDescriptionList = jobDescriptionList;
    }

    @XmlTransient
    public List<JobOffer> getJobAssignedList() {
        return jobOfferList;
    }

    public void setJobAssignedList(List<JobOffer> jobOfferList) {
        this.jobOfferList = jobOfferList;
    }

    @XmlTransient
    public List<Roles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<Roles> userRoles) {
        this.userRoles = userRoles;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Users[ userId=" + userId + " ]";
    }
    
}
