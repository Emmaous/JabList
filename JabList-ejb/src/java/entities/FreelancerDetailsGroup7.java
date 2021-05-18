/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "FREELANCER_DETAILS_GROUP7")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FreelancerDetailsGroup7.findAll", query = "SELECT f FROM FreelancerDetailsGroup7 f"),
    @NamedQuery(name = "FreelancerDetailsGroup7.findByMessage", query = "SELECT f FROM FreelancerDetailsGroup7 f WHERE f.message = :message"),
    @NamedQuery(name = "FreelancerDetailsGroup7.findByFreelancerId", query = "SELECT f FROM FreelancerDetailsGroup7 f WHERE f.freelancerId = :freelancerId")})
public class FreelancerDetailsGroup7 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "MESSAGE")
    private String message;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FREELANCER_ID")
    private String freelancerId;
    @JoinColumn(name = "FREELANCER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UsersGroup7 usersGroup7;

    public FreelancerDetailsGroup7() {
    }

    public FreelancerDetailsGroup7(String freelancerId) {
        this.freelancerId = freelancerId;
    }

    public FreelancerDetailsGroup7(String freelancerId, String message) {
        this.freelancerId = freelancerId;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(String freelancerId) {
        this.freelancerId = freelancerId;
    }

    public UsersGroup7 getUsersGroup7() {
        return usersGroup7;
    }

    public void setUsersGroup7(UsersGroup7 usersGroup7) {
        this.usersGroup7 = usersGroup7;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (freelancerId != null ? freelancerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FreelancerDetailsGroup7)) {
            return false;
        }
        FreelancerDetailsGroup7 other = (FreelancerDetailsGroup7) object;
        if ((this.freelancerId == null && other.freelancerId != null) || (this.freelancerId != null && !this.freelancerId.equals(other.freelancerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FreelancerDetailsGroup7[ freelancerId=" + freelancerId + " ]";
    }
    
}
