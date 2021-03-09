package ec.com.hananeel.mailmanager.domain;

import java.util.Date;
import java.util.Objects;

public class Email {
    /*
    String mesasunto, String mescarpet, Number mescodmes, Number mescodrel, Number mescodemp,
    String mescodser, String mescoduse, String mescuerpo, Date mesfecmod, Date mesfecnew,
    String mesmailcc, String mesmailco, String mesmailto, String mesnombre, String mesorigen,
    String messatt01, String messatt02, String messatt03, String messender, String messtatus,
    String messtatut, String mesusemod, String mesusenew, ServerJpaEntity serverJpaEntity
     */
    private String asunto;
    private String carpeta;
    private EmailId emailId;
    private Number codigoOrigen;
    private Number codigoEmpresa;
    private String codigoServidor;
    private String codigoUsuario;
    private String cuerpoMensaje;
    private Date fechaModificacion;
    private Date fechaCreacion;
    private String copiaCarbon;
    private String copiaOculta;
    private String destinatario;
    private String nombre;
    private String origenMensaje;
    private String adjunto1;
    private String adjunto2;
    private String adjunto3;
    private String remitente;
    private String status;
    private String tipo;
    private String usuarioModificacion;
    private String usuarioCreacion;
    private Server server;

    public Email(String asunto, String carpeta, EmailId emailId, Number codigoOrigen, Number codigoEmpresa,
                 String codigoServidor, String codigoUsuario, String cuerpoMensaje, Date fechaModificacion,
                 Date fechaCreacion, String copiaCarbon, String copiaOculta, String destinatario, String nombre,
                 String origenMensaje, String adjunto1, String adjunto2, String adjunto3, String remitente,
                 String status, String tipo, String usuarioModificacion, String usuarioCreacion, Server server) {
        this.asunto = asunto;
        this.carpeta = carpeta;
        this.emailId = emailId;
        this.codigoOrigen = codigoOrigen;
        this.codigoEmpresa = codigoEmpresa;
        this.codigoServidor = codigoServidor;
        this.codigoUsuario = codigoUsuario;
        this.cuerpoMensaje = cuerpoMensaje;
        this.fechaModificacion = fechaModificacion;
        this.fechaCreacion = fechaCreacion;
        this.copiaCarbon = copiaCarbon;
        this.copiaOculta = copiaOculta;
        this.destinatario = destinatario;
        this.nombre = nombre;
        this.origenMensaje = origenMensaje;
        this.adjunto1 = adjunto1;
        this.adjunto2 = adjunto2;
        this.adjunto3 = adjunto3;
        this.remitente = remitente;
        this.status = status;
        this.tipo = tipo;
        this.usuarioModificacion = usuarioModificacion;
        this.usuarioCreacion = usuarioCreacion;
        this.server = server;
    }

    public Email withId(EmailId emailId) {
        return new Email(asunto, carpeta, emailId, codigoOrigen, codigoEmpresa, codigoServidor, codigoUsuario,
                         cuerpoMensaje, fechaModificacion, fechaCreacion, copiaCarbon, copiaOculta, destinatario,
                         nombre, origenMensaje, adjunto1, adjunto2, adjunto3, remitente, status, tipo,
                         usuarioModificacion, usuarioCreacion, server);
    }

    //public Optional<EmailId> getId() {
    //  return Optional.ofNullable(this.emailId);
    //}

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setEmailId(EmailId emailId) {
        this.emailId = emailId;
    }

    public EmailId getEmailId() {
        return emailId;
    }

    public void setCodigoOrigen(Number codigoOrigen) {
        this.codigoOrigen = codigoOrigen;
    }

    public Number getCodigoOrigen() {
        return codigoOrigen;
    }

    public void setCodigoEmpresa(Number codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Number getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoServidor(String codigoServidor) {
        this.codigoServidor = codigoServidor;
    }

    public String getCodigoServidor() {
        return codigoServidor;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCuerpoMensaje(String cuerpoMensaje) {
        this.cuerpoMensaje = cuerpoMensaje;
    }

    public String getCuerpoMensaje() {
        return cuerpoMensaje;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setCopiaCarbon(String copiaCarbon) {
        this.copiaCarbon = copiaCarbon;
    }

    public String getCopiaCarbon() {
        return copiaCarbon;
    }

    public void setCopiaOculta(String copiaOculta) {
        this.copiaOculta = copiaOculta;
    }

    public String getCopiaOculta() {
        return copiaOculta;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setOrigenMensaje(String origenMensaje) {
        this.origenMensaje = origenMensaje;
    }

    public String getOrigenMensaje() {
        return origenMensaje;
    }

    public void setAdjunto1(String adjunto1) {
        this.adjunto1 = adjunto1;
    }

    public String getAdjunto1() {
        return adjunto1;
    }

    public void setAdjunto2(String adjunto2) {
        this.adjunto2 = adjunto2;
    }

    public String getAdjunto2() {
        return adjunto2;
    }

    public void setAdjunto3(String adjunto3) {
        this.adjunto3 = adjunto3;
    }

    public String getAdjunto3() {
        return adjunto3;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Server getServer() {
        return server;
    }

    // Accesorios de validación

    public boolean isPlainText() {
        return tipo.equalsIgnoreCase("P");
    }

    public boolean isHtml() {
        return tipo.equalsIgnoreCase("H");
    }

    public boolean isPending() {
        return status.equalsIgnoreCase("P");
    }

    public boolean isSended() {
        return status.equalsIgnoreCase("E");
    }

    public boolean isNewMessage() {
        return Objects.isNull(fechaCreacion) && Objects.isNull(fechaModificacion);
    }

    public boolean isOldMessage() {
        return Objects.nonNull(fechaCreacion) || Objects.nonNull(fechaModificacion);
    }

    public static class EmailId {

        private final Number codigoMensaje;

        public EmailId(Number codigoMensaje) {
            this.codigoMensaje = codigoMensaje;
        }

        public Number getCodigoMensaje() {
            return codigoMensaje;
        }
    }

    public enum Status {
        PENDING("P"),
        SENDED("E");

        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

}
