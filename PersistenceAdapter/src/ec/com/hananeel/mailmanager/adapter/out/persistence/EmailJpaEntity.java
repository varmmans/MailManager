package ec.com.hananeel.mailmanager.adapter.out.persistence;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "EmailJpaEntity.findAll", query = "select o from EmailJpaEntity o") })
@Table(name = "MENSAJES")
@IdClass(EmailJpaEntityPK.class)
@SuppressWarnings("oracle.jdeveloper.ejb.entity-class-auto-id-gen")
public class EmailJpaEntity implements Serializable {
    @SuppressWarnings("compatibility:-8753345298167438335")
    private static final long serialVersionUID = 1L;
    @Column(length = 500)
    private String mesasunto;
    @Column(length = 4000)
    private String mescarpet;
    @Id
    @Column(nullable = false)
    private Number mescodmes;
    @Column(nullable = false)
    private Number mescodrel;
    @Column(nullable = false, length = 50)
    private String mescodser;
    @Column(nullable = false, length = 50)
    private String mescoduse;
    @Column(length = 4000)
    private String mescuerpo;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date mesfecmod;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date mesfecnew;
    @Column(length = 500)
    private String mesmailcc;
    @Column(length = 500)
    private String mesmailco;
    @Column(nullable = false, length = 500)
    private String mesmailto;
    @Column(nullable = false, length = 500)
    private String mesnombre;
    @Column(nullable = false, length = 50)
    private String mesorigen;
    @Column(length = 4000)
    private String messatt01;
    @Column(length = 4000)
    private String messatt02;
    @Column(length = 4000)
    private String messatt03;
    @Column(nullable = false, length = 500)
    private String messender;
    @Column(nullable = false, length = 1)
    private String messtatus;
    @Column(nullable = false, length = 1)
    private String messtatut;
    @Column(nullable = false, length = 50)
    private String mesusemod;
    @Column(nullable = false, length = 50)
    private String mesusenew;
    @ManyToOne
    @JoinColumns({ @JoinColumn(name = "MESCODEMP", referencedColumnName = "SERCODEMP"),
                   @JoinColumn(name = "MESSERVER", referencedColumnName = "SERCODSER")
        })
    private ServerJpaEntity servidor;

    public EmailJpaEntity() {
    }

    public EmailJpaEntity(String mesasunto, String mescarpet, ServerJpaEntity servidor, Number mescodmes,
                          Number mescodrel, String mescodser, String mescoduse, String mescuerpo, Date mesfecmod,
                          Date mesfecnew, String mesmailcc, String mesmailco, String mesmailto, String mesnombre,
                          String mesorigen, String messatt01, String messatt02, String messatt03, String messender,
                          String messtatus, String messtatut, String mesusemod, String mesusenew) {
        this.mesasunto = mesasunto;
        this.mescarpet = mescarpet;
        this.servidor = servidor;
        this.mescodmes = mescodmes;
        this.mescodrel = mescodrel;
        this.mescodser = mescodser;
        this.mescoduse = mescoduse;
        this.mescuerpo = mescuerpo;
        this.mesfecmod = mesfecmod;
        this.mesfecnew = mesfecnew;
        this.mesmailcc = mesmailcc;
        this.mesmailco = mesmailco;
        this.mesmailto = mesmailto;
        this.mesnombre = mesnombre;
        this.mesorigen = mesorigen;
        this.messatt01 = messatt01;
        this.messatt02 = messatt02;
        this.messatt03 = messatt03;
        this.messender = messender;
        this.messtatus = messtatus;
        this.messtatut = messtatut;
        this.mesusemod = mesusemod;
        this.mesusenew = mesusenew;
    }

    public String getMesasunto() {
        return mesasunto;
    }

    public void setMesasunto(String mesasunto) {
        this.mesasunto = mesasunto;
    }

    public String getMescarpet() {
        return mescarpet;
    }

    public void setMescarpet(String mescarpet) {
        this.mescarpet = mescarpet;
    }


    public Number getMescodmes() {
        return mescodmes;
    }

    public void setMescodmes(Number mescodmes) {
        this.mescodmes = mescodmes;
    }

    public Number getMescodrel() {
        return mescodrel;
    }

    public void setMescodrel(Number mescodrel) {
        this.mescodrel = mescodrel;
    }

    public String getMescodser() {
        return mescodser;
    }

    public void setMescodser(String mescodser) {
        this.mescodser = mescodser;
    }

    public String getMescoduse() {
        return mescoduse;
    }

    public void setMescoduse(String mescoduse) {
        this.mescoduse = mescoduse;
    }

    public String getMescuerpo() {
        return mescuerpo;
    }

    public void setMescuerpo(String mescuerpo) {
        this.mescuerpo = mescuerpo;
    }

    public Date getMesfecmod() {
        return mesfecmod;
    }

    public void setMesfecmod(Date mesfecmod) {
        this.mesfecmod = mesfecmod;
    }

    public Date getMesfecnew() {
        return mesfecnew;
    }

    public void setMesfecnew(Date mesfecnew) {
        this.mesfecnew = mesfecnew;
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

    public String getMesmailto() {
        return mesmailto;
    }

    public void setMesmailto(String mesmailto) {
        this.mesmailto = mesmailto;
    }

    public String getMesnombre() {
        return mesnombre;
    }

    public void setMesnombre(String mesnombre) {
        this.mesnombre = mesnombre;
    }

    public String getMesorigen() {
        return mesorigen;
    }

    public void setMesorigen(String mesorigen) {
        this.mesorigen = mesorigen;
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

    public String getMessender() {
        return messender;
    }

    public void setMessender(String messender) {
        this.messender = messender;
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

    public String getMesusemod() {
        return mesusemod;
    }

    public void setMesusemod(String mesusemod) {
        this.mesusemod = mesusemod;
    }

    public String getMesusenew() {
        return mesusenew;
    }

    public void setMesusenew(String mesusenew) {
        this.mesusenew = mesusenew;
    }

    public ServerJpaEntity getServidor() {
        return servidor;
    }

    public void setServidor(ServerJpaEntity servidor) {
        this.servidor = servidor;
    }
}
