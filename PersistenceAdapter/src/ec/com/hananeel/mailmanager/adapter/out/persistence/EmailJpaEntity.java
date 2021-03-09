package ec.com.hananeel.mailmanager.adapter.out.persistence;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ @NamedQuery(name = "EmailJpaEntity.findAll", query = "select o from EmailJpaEntity o"),
                @NamedQuery(name = "EmailJpaEntity.findByStatus",
                            query = "select o from EmailJpaEntity o where o.messtatus = :messtatus")
    })
@Table(name = "MENSAJES")
public class EmailJpaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmailJpaEntityPK emailJpaEntityPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MESCODREL")
    private Number mescodrel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MESORIGEN")
    private String mesorigen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MESCODUSE")
    private String mescoduse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MESCODSER")
    private String mescodser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "MESNOMBRE")
    private String mesnombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "MESSENDER")
    private String messender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "MESMAILTO")
    private String mesmailto;
    @Size(max = 500)
    @Column(name = "MESMAILCC")
    private String mesmailcc;
    @Size(max = 500)
    @Column(name = "MESMAILCO")
    private String mesmailco;
    @Size(max = 500)
    @Column(name = "MESASUNTO")
    private String mesasunto;
    @Size(max = 4000)
    @Column(name = "MESCUERPO")
    private String mescuerpo;
    @Size(max = 4000)
    @Column(name = "MESCARPET")
    private String mescarpet;
    @Size(max = 4000)
    @Column(name = "MESSATT01")
    private String messatt01;
    @Size(max = 4000)
    @Column(name = "MESSATT02")
    private String messatt02;
    @Size(max = 4000)
    @Column(name = "MESSATT03")
    private String messatt03;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MESSTATUS")
    private String messtatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "MESSTATUT")
    private String messtatut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MESUSENEW")
    private String mesusenew;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MESFECNEW")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mesfecnew;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MESUSEMOD")
    private String mesusemod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MESFECMOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mesfecmod;
    @JoinColumns({ @JoinColumn(name = "MESCODEMP", referencedColumnName = "SERCODEMP", insertable = false,
                               updatable = false), @JoinColumn(name = "MESSERVER", referencedColumnName = "SERCODSER")
        })
    @ManyToOne(optional = false)
    private ServerJpaEntity serverJpaEntity;

    public EmailJpaEntity() {
    }

    public EmailJpaEntity(EmailJpaEntityPK mensajesPK) {
        this.emailJpaEntityPK = mensajesPK;
    }


    public EmailJpaEntity(EmailJpaEntityPK emailJpaEntityPK, Number mescodrel, String mesorigen, String mescoduse,
                          String mescodser, String mesnombre, String messender, String mesmailto, String mesmailcc,
                          String mesmailco, String mesasunto, String mescuerpo, String mescarpet, String messatt01,
                          String messatt02, String messatt03, String messtatus, String messtatut, String mesusenew,
                          Date mesfecnew, String mesusemod, Date mesfecmod, ServerJpaEntity serverJpaEntity) {
        this.emailJpaEntityPK = emailJpaEntityPK;
        this.mescodrel = mescodrel;
        this.mesorigen = mesorigen;
        this.mescoduse = mescoduse;
        this.mescodser = mescodser;
        this.mesnombre = mesnombre;
        this.messender = messender;
        this.mesmailto = mesmailto;
        this.mesmailcc = mesmailcc;
        this.mesmailco = mesmailco;
        this.mesasunto = mesasunto;
        this.mescuerpo = mescuerpo;
        this.mescarpet = mescarpet;
        this.messatt01 = messatt01;
        this.messatt02 = messatt02;
        this.messatt03 = messatt03;
        this.messtatus = messtatus;
        this.messtatut = messtatut;
        this.mesusenew = mesusenew;
        this.mesfecnew = mesfecnew;
        this.mesusemod = mesusemod;
        this.mesfecmod = mesfecmod;
        this.serverJpaEntity = serverJpaEntity;
    }

    public EmailJpaEntity(Number mescodemp, Number mescodmes) {
        this.emailJpaEntityPK = new EmailJpaEntityPK(mescodemp, mescodmes);
    }

    public EmailJpaEntityPK getEmailJpaEntityPK() {
        return emailJpaEntityPK;
    }

    public void setEmailJpaEntityPK(EmailJpaEntityPK emailJpaEntityPK) {
        this.emailJpaEntityPK = emailJpaEntityPK;
    }

    public Number getMescodrel() {
        return mescodrel;
    }

    public void setMescodrel(Number mescodrel) {
        this.mescodrel = mescodrel;
    }

    public String getMesorigen() {
        return mesorigen;
    }

    public void setMesorigen(String mesorigen) {
        this.mesorigen = mesorigen;
    }

    public String getMescoduse() {
        return mescoduse;
    }

    public void setMescoduse(String mescoduse) {
        this.mescoduse = mescoduse;
    }

    public String getMescodser() {
        return mescodser;
    }

    public void setMescodser(String mescodser) {
        this.mescodser = mescodser;
    }

    public String getMesnombre() {
        return mesnombre;
    }

    public void setMesnombre(String mesnombre) {
        this.mesnombre = mesnombre;
    }

    public String getMessender() {
        return messender;
    }

    public void setMessender(String messender) {
        this.messender = messender;
    }

    public String getMesmailto() {
        return mesmailto;
    }

    public void setMesmailto(String mesmailto) {
        this.mesmailto = mesmailto;
    }

    public String getMesmailcc() {
        return mesmailcc;
    }

    public void setMesmailcc(String mesmailcc) {
        this.mesmailcc = mesmailcc;
    }

    public String getMesmailco() {
        return mesmailco;
    }

    public void setMesmailco(String mesmailco) {
        this.mesmailco = mesmailco;
    }

    public String getMesasunto() {
        return mesasunto;
    }

    public void setMesasunto(String mesasunto) {
        this.mesasunto = mesasunto;
    }

    public String getMescuerpo() {
        return mescuerpo;
    }

    public void setMescuerpo(String mescuerpo) {
        this.mescuerpo = mescuerpo;
    }

    public String getMescarpet() {
        return mescarpet;
    }

    public void setMescarpet(String mescarpet) {
        this.mescarpet = mescarpet;
    }

    public String getMessatt01() {
        return messatt01;
    }

    public void setMessatt01(String messatt01) {
        this.messatt01 = messatt01;
    }

    public String getMessatt02() {
        return messatt02;
    }

    public void setMessatt02(String messatt02) {
        this.messatt02 = messatt02;
    }

    public String getMessatt03() {
        return messatt03;
    }

    public void setMessatt03(String messatt03) {
        this.messatt03 = messatt03;
    }

    public String getMesstatus() {
        return messtatus;
    }

    public void setMesstatus(String messtatus) {
        this.messtatus = messtatus;
    }

    public String getMesstatut() {
        return messtatut;
    }

    public void setMesstatut(String messtatut) {
        this.messtatut = messtatut;
    }

    public String getMesusenew() {
        return mesusenew;
    }

    public void setMesusenew(String mesusenew) {
        this.mesusenew = mesusenew;
    }

    public Date getMesfecnew() {
        return mesfecnew;
    }

    public void setMesfecnew(Date mesfecnew) {
        this.mesfecnew = mesfecnew;
    }

    public String getMesusemod() {
        return mesusemod;
    }

    public void setMesusemod(String mesusemod) {
        this.mesusemod = mesusemod;
    }

    public Date getMesfecmod() {
        return mesfecmod;
    }

    public void setMesfecmod(Date mesfecmod) {
        this.mesfecmod = mesfecmod;
    }

    public ServerJpaEntity getServerJpaEntity() {
        return serverJpaEntity;
    }

    public void setServerJpaEntity(ServerJpaEntity serverJpaEntity) {
        this.serverJpaEntity = serverJpaEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailJpaEntityPK != null ? emailJpaEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailJpaEntity)) {
            return false;
        }
        EmailJpaEntity other = (EmailJpaEntity) object;
        if ((this.emailJpaEntityPK == null && other.emailJpaEntityPK != null) ||
            (this.emailJpaEntityPK != null && !this.emailJpaEntityPK.equals(other.emailJpaEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.hananeel.mailmanager.adapter.out.persistence.Mensajes[ mensajesPK=" + emailJpaEntityPK + " ]";
    }

}
