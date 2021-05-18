/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Okechukwu Okonwanji
 */
@Entity
@Table(name = "OFFERS", catalog = "", schema = "SA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offers.findAll", query = "SELECT o FROM Offers o")
    , @NamedQuery(name = "Offers.findByStatus", query = "SELECT o FROM Offers o WHERE o.status = :status")
    , @NamedQuery(name = "Offers.findByJobId", query = "SELECT o FROM Offers o WHERE o.jobId = :jobId")
    , @NamedQuery(name = "Offers.findByFreelancerId", query = "SELECT o FROM Offers o WHERE o.freelancerId = :freelancerId")})
public class Offers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "JOB_ID")
    @Id
    private String jobId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FREELANCER_ID")
    @Id
    private String freelancerId;
    @Size(max = 10)
    @Column(name = "STATUS")
    private String status;

    public Offers() {
    }

    public Offers(String jobId, String freelancerId) {
        this.jobId = jobId;
        this.freelancerId = freelancerId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getFreelancerId() {
        return freelancerId;
    }

    public void setFreelancerId(String freelancerId) {
        this.freelancerId = freelancerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (jobId != null ? jobId.hashCode() : 0);
        hash += (freelancerId != null ? freelancerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offers)) {
            return false;
        }
        Offers other = (Offers) object;
        if ((this.jobId == null && other.jobId != null) || (this.jobId != null && !this.jobId.equals(other.jobId))) {
            return false;
        }
        if ((this.freelancerId == null && other.freelancerId != null) || (this.freelancerId != null && !this.freelancerId.equals(other.freelancerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Offers[ jobId=" + jobId + ", freelancerId=" + freelancerId + " ]";
    }
    
}
