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
@Table(name = "TAGS_GROUP7")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TagsGroup7.findAll", query = "SELECT t FROM TagsGroup7 t"),
    @NamedQuery(name = "TagsGroup7.findByTagId", query = "SELECT t FROM TagsGroup7 t WHERE t.tagId = :tagId"),
    @NamedQuery(name = "TagsGroup7.findByTag", query = "SELECT t FROM TagsGroup7 t WHERE t.tag = :tag")})
public class TagsGroup7 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAG_ID")
    private Integer tagId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TAG")
    private String tag;
    @ManyToMany(mappedBy = "tagsGroup7Collection")
    private List<JobsGroup7> jobsGroup7Collection;

    public TagsGroup7() {
    }

    public TagsGroup7(Integer tagId) {
        this.tagId = tagId;
    }

    public TagsGroup7(Integer tagId, String tag) {
        this.tagId = tagId;
        this.tag = tag;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @XmlTransient
    public List<JobsGroup7> getJobsGroup7Collection() {
        return jobsGroup7Collection;
    }

    public void setJobsGroup7Collection(List<JobsGroup7> jobsGroup7Collection) {
        this.jobsGroup7Collection = jobsGroup7Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagId != null ? tagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TagsGroup7)) {
            return false;
        }
        TagsGroup7 other = (TagsGroup7) object;
        if ((this.tagId == null && other.tagId != null) || (this.tagId != null && !this.tagId.equals(other.tagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TagsGroup7[ tagId=" + tagId + " ]";
    }
    
}
