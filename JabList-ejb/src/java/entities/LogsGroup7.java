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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "LOGS_GROUP7")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogsGroup7.findAll", query = "SELECT l FROM LogsGroup7 l"),
    @NamedQuery(name = "LogsGroup7.findByLogId", query = "SELECT l FROM LogsGroup7 l WHERE l.logId = :logId"),
    @NamedQuery(name = "LogsGroup7.findByLogMessage", query = "SELECT l FROM LogsGroup7 l WHERE l.logMessage = :logMessage")})
public class LogsGroup7 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOG_ID")
    private Integer logId;
    @Size(max = 40)
    @Column(name = "LOG_MESSAGE")
    private String logMessage;

    public LogsGroup7() {
    }

    public LogsGroup7(Integer logId) {
        this.logId = logId;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
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
        if (!(object instanceof LogsGroup7)) {
            return false;
        }
        LogsGroup7 other = (LogsGroup7) object;
        if ((this.logId == null && other.logId != null) || (this.logId != null && !this.logId.equals(other.logId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LogsGroup7[ logId=" + logId + " ]";
    }
    
}
