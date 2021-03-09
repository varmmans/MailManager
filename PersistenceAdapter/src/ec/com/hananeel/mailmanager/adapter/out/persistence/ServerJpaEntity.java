package ec.com.hananeel.mailmanager.adapter.out.persistence;

import java.io.Serializable;

import java.math.BigInteger;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ @NamedQuery(name = "ServerJpaEntity.findAll", query = "select o from ServerJpaEntity o") })
@Table(name = "SERVIDORES")
public class ServerJpaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServerJpaEntityPK serverJpaEntityPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SERDIRREC")
    private String serdirrec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERNROPOR")
    private Integer sernropor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SERUSUARI")
    private String serusuari;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SERPASSWR")
    private String serpasswr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serverJpaEntity")
    private List<EmailJpaEntity> emailJpaEntityList;

    public ServerJpaEntity() {
    }

    public ServerJpaEntity(ServerJpaEntityPK serverJpaEntityPK) {
        this.serverJpaEntityPK = serverJpaEntityPK;
    }

    public ServerJpaEntity(ServerJpaEntityPK serverJpaEntityPK, String serdirrec, Integer sernropor, String serusuari,
                           String serpasswr) {
        this.serverJpaEntityPK = serverJpaEntityPK;
        this.serdirrec = serdirrec;
        this.sernropor = sernropor;
        this.serusuari = serusuari;
        this.serpasswr = serpasswr;
    }

    public ServerJpaEntity(BigInteger sercodemp, String sercodser) {
        this.serverJpaEntityPK = new ServerJpaEntityPK(sercodemp, sercodser);
    }

    public ServerJpaEntityPK getServerJpaEntityPK() {
        return serverJpaEntityPK;
    }

    public void setServerJpaEntityPK(ServerJpaEntityPK serverJpaEntityPK) {
        this.serverJpaEntityPK = serverJpaEntityPK;
    }

    public String getSerdirrec() {
        return serdirrec;
    }

    public void setSerdirrec(String serdirrec) {
        this.serdirrec = serdirrec;
    }

    public Integer getSernropor() {
        return sernropor;
    }

    public void setSernropor(Integer sernropor) {
        this.sernropor = sernropor;
    }

    public String getSerusuari() {
        return serusuari;
    }

    public void setSerusuari(String serusuari) {
        this.serusuari = serusuari;
    }

    public String getSerpasswr() {
        return serpasswr;
    }

    public void setSerpasswr(String serpasswr) {
        this.serpasswr = serpasswr;
    }

    public List<EmailJpaEntity> getEmailJpaEntityList() {
        return emailJpaEntityList;
    }

    public void setEmailJpaEntityList(List<EmailJpaEntity> emailJpaEntityList) {
        this.emailJpaEntityList = emailJpaEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serverJpaEntityPK != null ? serverJpaEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServerJpaEntity)) {
            return false;
        }
        ServerJpaEntity other = (ServerJpaEntity) object;
        if ((this.serverJpaEntityPK == null && other.serverJpaEntityPK != null) ||
            (this.serverJpaEntityPK != null && !this.serverJpaEntityPK.equals(other.serverJpaEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.hananeel.mailmanager.adapter.out.persistence.Servidores[ servidoresPK=" + serverJpaEntityPK +
               " ]";
    }

}
