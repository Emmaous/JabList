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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GROUP 2
 */
@Entity
@Table(name = "LOGS", catalog = "", schema = "SA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logs.findAll", query = "SELECT l FROM Logs l")
    , @NamedQuery(name = "Logs.findByLogId", query = "SELECT l FROM Logs l WHERE l.logId = :logId")
    , @NamedQuery(name = "Logs.findByDescription", query = "SELECT l FROM Logs l WHERE l.description = :description")})
public class Logs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOG_ID")
    private Integer logId;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;

    public Logs() {
    }

    public Logs(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logId != null ? logId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logs)) {
            return false;
        }
        Logs other = (Logs) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Logs[ logId=" + logId + " ]";
    }
    
}
