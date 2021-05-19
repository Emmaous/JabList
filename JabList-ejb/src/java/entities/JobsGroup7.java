/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "JOBS_GROUP7")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobsGroup7.findAll", query = "SELECT j FROM JobsGroup7 j"),
    @NamedQuery(name = "JobsGroup7.findByJobId", query = "SELECT j FROM JobsGroup7 j WHERE j.jobId = :jobId"),
    @NamedQuery(name = "JobsGroup7.findByTitle", query = "SELECT j FROM JobsGroup7 j WHERE j.title = :title"),
    @NamedQuery(name = "JobsGroup7.findByDescription", query = "SELECT j FROM JobsGroup7 j WHERE j.description = :description"),
    @NamedQuery(name = "JobsGroup7.findByPaymentOffer", query = "SELECT j FROM JobsGroup7 j WHERE j.paymentOffer = :paymentOffer"),
    @NamedQuery(name = "JobsGroup7.findByProviderId", query = "SELECT j FROM JobsGroup7 j WHERE j.providerId = :providerId"),
    @NamedQuery(name = "JobsGroup7.findByStatus", query = "SELECT j FROM JobsGroup7 j WHERE j.status = :status")})
public class JobsGroup7 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "JOB_ID")
    private Integer jobId;
    @Size(max = 35)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAYMENT_OFFER")
    private Double paymentOffer;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;
    @JoinTable(name = "JOB_TAGS_GROUP7", joinColumns = {
        @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "TAG_ID", referencedColumnName = "TAG_ID")})
    @ManyToMany
    private List<TagsGroup7> tagsGroup7Collection;
    @JoinTable(name = "APPLICATION_GROUP7", joinColumns = {
        @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "FREELANCER_ID", referencedColumnName = "USER_ID")})
    @ManyToMany
    private List<UsersGroup7> usersGroup7Collection;
    @JoinColumn(name = "PROVIDER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private UsersGroup7 providerId;

    public JobsGroup7() {
    }

    public JobsGroup7(Integer jobId, String title, String description, Double paymentOffer, String status, List<TagsGroup7> tagsGroup7Collection, List<UsersGroup7> usersGroup7Collection, UsersGroup7 providerId) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.paymentOffer = paymentOffer;
        this.status = status;
        this.tagsGroup7Collection = tagsGroup7Collection;
        this.usersGroup7Collection = usersGroup7Collection;
        this.providerId = providerId;
    }
    
    

    public JobsGroup7(Integer jobId) {
        this.jobId = jobId;
        
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
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

    public Double getPaymentOffer() {
        return paymentOffer;
    }

    public void setPaymentOffer(Double paymentOffer) {
        this.paymentOffer = paymentOffer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<TagsGroup7> getTagsGroup7Collection() {
        return tagsGroup7Collection;
    }

    public void setTagsGroup7Collection(List<TagsGroup7> tagsGroup7Collection) {
        this.tagsGroup7Collection = tagsGroup7Collection;
    }

    @XmlTransient
    public List<UsersGroup7> getUsersGroup7Collection() {
        return usersGroup7Collection;
    }

    public void setUsersGroup7Collection(List<UsersGroup7> usersGroup7Collection) {
        this.usersGroup7Collection = usersGroup7Collection;
    }

    public UsersGroup7 getProviderId() {
        return providerId;
    }

    public void setProviderId(UsersGroup7 providerId) {
        this.providerId = providerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobId != null ? jobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobsGroup7)) {
            return false;
        }
        JobsGroup7 other = (JobsGroup7) object;
        if ((this.jobId == null && other.jobId != null) || (this.jobId != null && !this.jobId.equals(other.jobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.JobsGroup7[ jobId=" + jobId + " ]";
    }
    
}
