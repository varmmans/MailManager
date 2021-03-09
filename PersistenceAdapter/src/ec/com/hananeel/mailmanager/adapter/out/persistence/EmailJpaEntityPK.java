package ec.com.hananeel.mailmanager.adapter.out.persistence;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import javax.validation.constraints.NotNull;

@Embeddable
public class EmailJpaEntityPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "MESCODEMP")
    private Number mescodemp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MESCODMES")
    private Number mescodmes;

    public EmailJpaEntityPK() {
    }

    public EmailJpaEntityPK(Number mescodemp, Number mescodmes) {
        this.mescodemp = mescodemp;
        this.mescodmes = mescodmes;
    }

    public Number getMescodemp() {
        return mescodemp;
    }

    public void setMescodemp(Number mescodemp) {
        this.mescodemp = mescodemp;
    }

    public Number getMescodmes() {
        return mescodmes;
    }

    public void setMescodmes(Number mescodmes) {
        this.mescodmes = mescodmes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mescodemp != null ? mescodemp.hashCode() : 0);
        hash += (mescodmes != null ? mescodmes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailJpaEntityPK)) {
            return false;
        }
        EmailJpaEntityPK other = (EmailJpaEntityPK) object;
        if ((this.mescodemp == null && other.mescodemp != null) ||
            (this.mescodemp != null && !this.mescodemp.equals(other.mescodemp))) {
            return false;
        }
        if ((this.mescodmes == null && other.mescodmes != null) ||
            (this.mescodmes != null && !this.mescodmes.equals(other.mescodmes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.hananeel.mailmanager.adapter.out.persistence.MensajesPK[ mescodemp=" + mescodemp +
               ", mescodmes=" + mescodmes + " ]";
    }

}
