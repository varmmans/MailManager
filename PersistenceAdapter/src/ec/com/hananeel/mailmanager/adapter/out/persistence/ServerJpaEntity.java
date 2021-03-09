package ec.com.hananeel.mailmanager.adapter.out.persistence;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "ServerJpaEntity.findAll", query = "select o from ServerJpaEntity o") })
@Table(name = "SERVIDORES")
@IdClass(ServerJpaEntityPK.class)
@SuppressWarnings("oracle.jdeveloper.ejb.entity-class-auto-id-gen")
public class ServerJpaEntity implements Serializable {
    @SuppressWarnings("compatibility:4490655167391106211")
    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    private Number sercodemp;
    @Id
    @Column(nullable = false, length = 50)
    private String sercodser;
    @Column(nullable = false, length = 100)
    private String serdirrec;
    @Column(nullable = false)
    private Integer sernropor;
    @Column(nullable = false, length = 50)
    private String serpasswr;
    @Column(nullable = false, length = 50)
    private String serusuari;
    @OneToMany(mappedBy = "servidor", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<EmailJpaEntity> mensajes;

    public ServerJpaEntity() {
    }

    public ServerJpaEntity(Number sercodemp, String sercodser, String serdirrec, Integer sernropor, String serpasswr,
                           String serusuari) {
        this.sercodemp = sercodemp;
        this.sercodser = sercodser;
        this.serdirrec = serdirrec;
        this.sernropor = sernropor;
        this.serpasswr = serpasswr;
        this.serusuari = serusuari;
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

    public String getSerpasswr() {
        return serpasswr;
    }

    public void setSerpasswr(String serpasswr) {
        this.serpasswr = serpasswr;
    }

    public String getSerusuari() {
        return serusuari;
    }

    public void setSerusuari(String serusuari) {
        this.serusuari = serusuari;
    }

    public List<EmailJpaEntity> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<EmailJpaEntity> mensajes) {
        this.mensajes = mensajes;
    }

    public EmailJpaEntity addMensajePersistenceAdapter(EmailJpaEntity mensajePersistenceAdapter) {
        getMensajes().add(mensajePersistenceAdapter);
        mensajePersistenceAdapter.setServidor(this);
        return mensajePersistenceAdapter;
    }

    public EmailJpaEntity removeMensajePersistenceAdapter(EmailJpaEntity mensajePersistenceAdapter) {
        getMensajes().remove(mensajePersistenceAdapter);
        mensajePersistenceAdapter.setServidor(null);
        return mensajePersistenceAdapter;
    }
}
