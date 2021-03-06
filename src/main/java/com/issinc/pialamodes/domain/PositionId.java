package com.issinc.pialamodes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *  Created by jay.moss on 11/4/2015.
 */
@Embeddable
public class PositionId implements Serializable {

    @Column(name="hexident", nullable=false)
    private String hexIdent;

    @Column(name="timestamp", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    protected PositionId() {
    }

    public PositionId(String hexIdent) {
        this.hexIdent = hexIdent;
        this.timestamp = new Date();
    }

    public PositionId(String hexIdent, Date timestamp) {
        this.hexIdent = hexIdent;
        this.timestamp = timestamp;
    }

    public String getHexIdent() {
        return hexIdent;
    }
    public void setHexIdent(String hexIdent) {
        this.hexIdent = hexIdent;
    }

    public Date getTimestamp() {
        return timestamp;
    }
//    public void setTimestamp(Date timestamp) {
//        this.timestamp = timestamp;
//    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionId that = (PositionId) o;

        if (!hexIdent.equals(that.hexIdent)) return false;
        return timestamp.equals(that.timestamp);
    }

    @Override
    public int hashCode() {
        int result = hexIdent.hashCode();
        result = 31 * result + timestamp.hashCode();
        return result;
    }
}
