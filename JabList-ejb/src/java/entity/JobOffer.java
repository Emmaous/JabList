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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "JOB_OFFER", catalog = "", schema = "SA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobOffer.findAll", query = "SELECT j FROM JobOffer j")
    , @NamedQuery(name = "JobOffer.findByOfferId", query = "SELECT j FROM JobOffer j WHERE j.offerId = :offerId")
    , @NamedQuery(name = "JobOffer.findByJobId", query = "SELECT j FROM JobOffer j WHERE j.jobId = :jobId")
    , @NamedQuery(name = "JobOffer.findByFreelancerId", query = "SELECT j FROM JobOffer j WHERE j.freelancerId = :freelancerId")
    , @NamedQuery(name = "JobOffer.findByJobIdAndStatus", query = "SELECT j FROM JobOffer j WHERE j.createdby = :createdby")
    , @NamedQuery(name = "JobOffer.findByFreelancerIdAndStatus", query = "SELECT j FROM JobOffer j JOIN Jobs jo WHERE j.jobId = jo.jobId AND j.jobOffersPK.freelancerId = :freelancerId AND jo.status = :status")
    , @NamedQuery(name = "JobOffer.findByFreelancerIdAndJobId", query = "SELECT j FROM JobOffer j JOIN Jobs jo WHERE j.jobId = jo.jobId AND j.jobOffersPK.freelancerId = :freelancerId AND j.jobOffersPK.jobId = :jobId")
    , @NamedQuery(name = "JobOffer.findByAssignedto", query = "SELECT j FROM JobAssigned j WHERE j.jobAssignedPK.assignedto = :assignedto")
//    , @NamedQuery(name = "JobOffer.findByDateassigned", query = "SELECT j FROM JobAssigned j WHERE j.dateassigned = :dateassigned")
    , @NamedQuery(name = "JobOffer.findByStatus", query = "SELECT j FROM JobOffer j WHERE j.status = :status")})
public class JobOffer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "OFFER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int offerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "JOB_ID")
    @Id
    private String jobId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Id
    @Column(name = "FREELANCER_ID")
    private String freelancerId;
    @Size(max = 10)
    @Column(name = "STATUS")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ASSIGNEDTO")
    @Id
    private String assignedto;
    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private JobDescription jobs;
    @JoinColumn(name = "FREELANCER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public JobOffer() {
    }
    
    public JobOffer(int offerId, String jobId, String freelancerId) {
        this.offerId = offerId;
        this.jobId = jobId;
        this.freelancerId = freelancerId;
    }
    
    public JobOffer(String jobId, String assignedto) {
        this.jobId = jobId;
        this.assignedto = assignedto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JobDescription getJobs() {
        return jobs;
    }

    public void setJobs(JobDescription jobs) {
        this.jobs = jobs;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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

    public String getAssignedto() {
        return assignedto;
    }

    public void setAssignedto(String assignedto) {
        this.assignedto = assignedto;
    }
    
    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) offerId;
        hash += (jobId != null ? jobId.hashCode() : 0);
        hash += (freelancerId != null ? freelancerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobOffer)) {
            return false;
        }
        JobOffer other = (JobOffer) object;
        if (this.offerId != other.offerId) {
            return false;
        }
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
        return "entity.JobOffers[ offerId=" + offerId + ", jobId=" + jobId 
                + ", freelancerId=" + freelancerId + " ]";
    }
}
