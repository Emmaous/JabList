/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "SKILLS_GROUP7")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkillsGroup7.findAll", query = "SELECT s FROM SkillsGroup7 s"),
    @NamedQuery(name = "SkillsGroup7.findBySkillsId", query = "SELECT s FROM SkillsGroup7 s WHERE s.skillsId = :skillsId"),
    @NamedQuery(name = "SkillsGroup7.findBySkill", query = "SELECT s FROM SkillsGroup7 s WHERE s.skill = :skill")})
public class SkillsGroup7 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SKILLS_ID")
    private Integer skillsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "SKILL")
    private String skill;
    @ManyToMany(mappedBy = "skillsGroup7Collection")
    private Collection<UsersGroup7> usersGroup7Collection;

    public SkillsGroup7() {
    }

    public SkillsGroup7(Integer skillsId) {
        this.skillsId = skillsId;
    }

    public SkillsGroup7(Integer skillsId, String skill) {
        this.skillsId = skillsId;
        this.skill = skill;
    }

    public Integer getSkillsId() {
        return skillsId;
    }

    public void setSkillsId(Integer skillsId) {
        this.skillsId = skillsId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @XmlTransient
    public Collection<UsersGroup7> getUsersGroup7Collection() {
        return usersGroup7Collection;
    }

    public void setUsersGroup7Collection(Collection<UsersGroup7> usersGroup7Collection) {
        this.usersGroup7Collection = usersGroup7Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillsId != null ? skillsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillsGroup7)) {
            return false;
        }
        SkillsGroup7 other = (SkillsGroup7) object;
        if ((this.skillsId == null && other.skillsId != null) || (this.skillsId != null && !this.skillsId.equals(other.skillsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SkillsGroup7[ skillsId=" + skillsId + " ]";
    }
    
}
