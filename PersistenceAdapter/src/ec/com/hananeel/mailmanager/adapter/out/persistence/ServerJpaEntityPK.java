package ec.com.hananeel.mailmanager.adapter.out.persistence;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class ServerJpaEntityPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SERCODEMP")
    private Number sercodemp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SERCODSER")
    private String sercodser;

    public ServerJpaEntityPK() {
    }

    public ServerJpaEntityPK(Number sercodemp, String sercodser) {
        this.sercodemp = sercodemp;
        this.sercodser = sercodser;
    }

    public Number getSercodemp() {
        return sercodemp;
    }

    public void setSercodemp(Number sercodemp) {
        this.sercodemp = sercodemp;
    }

    public String getSercodser() {
        return sercodser;
    }

    public void setSercodser(String sercodser) {
        this.sercodser = sercodser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sercodemp != null ? sercodemp.hashCode() : 0);
        hash += (sercodser != null ? sercodser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServerJpaEntityPK)) {
            return false;
        }
        ServerJpaEntityPK other = (ServerJpaEntityPK) object;
        if ((this.sercodemp == null && other.sercodemp != null) ||
            (this.sercodemp != null && !this.sercodemp.equals(other.sercodemp))) {
            return false;
        }
        if ((this.sercodser == null && other.sercodser != null) ||
            (this.sercodser != null && !this.sercodser.equals(other.sercodser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.hananeel.mailmanager.adapter.out.persistence.ServidoresPK[ sercodemp=" + sercodemp +
               ", sercodser=" + sercodser + " ]";
    }

}
