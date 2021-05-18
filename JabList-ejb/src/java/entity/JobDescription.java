/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "JOB_DESCRIPTION", catalog = "", schema = "SA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobDescription.findAll", query = "SELECT j FROM JobDescription j")
    , @NamedQuery(name = "JobDescription.findByJobId", query = "SELECT j FROM JobDescription j WHERE j.jobId = :jobId")
    , @NamedQuery(name = "JobDescription.findByTitle", query = "SELECT j FROM JobDescription j WHERE j.title = :title")
    , @NamedQuery(name = "JobDescription.findByDescription", query = "SELECT j FROM JobDescription j WHERE j.description = :description")
    , @NamedQuery(name = "JobDescription.findByStatus", query = "SELECT j FROM JobDescription j WHERE j.status = :status")
    , @NamedQuery(name = "JobDescription.findByKeyword", query = "SELECT j FROM JobDescription j WHERE j.keywords LIKE CONCAT(:keywords,'%')")
    , @NamedQuery(name = "JobDescription.findByCreatedby", query = "SELECT j FROM JobDescription j WHERE j.createdby = :createdby")
    , @NamedQuery(name = "JobDescription.findByStatusByProvider", query = "SELECT j FROM JobDescription j JOIN JobOffer jc ON j.jobId = jc.jobId WHERE j.status = :status AND j.createdby = :createdby")
    , @NamedQuery(name = "JobDescription.findOpenByProvider", query = "SELECT j FROM JobDescription j JOIN JobOffer jc ON j.jobId = jc.jobId WHERE j.createdby = :createdby")
    , @NamedQuery(name = "JobDescription.findByPaymentOffer", query = "SELECT j FROM JobDescription j WHERE j.paymentOffer = :paymentOffer")})
public class JobDescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "JOB_ID")
    private String jobId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 10)
    @Column(name = "STATUS")
    private String status;
    @Lob
    @Size(max = 32700)
    @Column(name = "KEYWORDS")
    private String keywords;
    @Column(name = "PAYMENT_OFFER")
    private BigInteger paymentOffer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CREATEDBY")
    @Id
    private String createdby;
    @JoinColumn(name = "CREATEDBY", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobs")
    private List<JobOffer> jobCreatorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobs")
    private List<JobOffer> jobOffersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobs")
    private List<JobOffer> jobAssignedList;

    public JobDescription() {
    }

    public JobDescription(String jobId) {
        this.jobId = jobId;
    }

    public JobDescription(String jobId, String title, String description) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
    }
    
    public JobDescription(String jobId, String createdby) {
        this.jobId = jobId;
        this.createdby = createdby;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public BigInteger getPaymentOffer() {
        return paymentOffer;
    }

    public void setPaymentOffer(BigInteger paymentOffer) {
        this.paymentOffer = paymentOffer;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @XmlTransient
    public List<JobOffer> getJobCreatorList() {
        return jobCreatorList;
    }

    public void setJobCreatorList(List<JobOffer> jobCreatorList) {
        this.jobCreatorList = jobCreatorList;
    }

    @XmlTransient
    public List<JobOffer> getJobOffersList() {
        return jobOffersList;
    }

    public void setJobOffersList(List<JobOffer> jobOffersList) {
        this.jobOffersList = jobOffersList;
    }

    @XmlTransient
    public List<JobOffer> getJobAssignedList() {
        return jobAssignedList;
    }

    public void setJobAssignedList(List<JobOffer> jobAssignedList) {
        this.jobAssignedList = jobAssignedList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobId != null ? jobId.hashCode() : 0);
        hash += (createdby != null ? createdby.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobDescription)) {
            return false;
        }
        JobDescription other = (JobDescription) object;
        if ((this.jobId == null && other.jobId != null) || (this.jobId != null && !this.jobId.equals(other.jobId))) {
            return false;
        }
        if ((this.createdby == null && other.createdby != null) || (this.createdby != null && !this.createdby.equals(other.createdby))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.JobDescription[ jobId=" + jobId + ", createdby=" + createdby + " ]";
    }
    
}
