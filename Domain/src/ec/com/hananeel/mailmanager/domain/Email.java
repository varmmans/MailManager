package ec.com.hananeel.mailmanager.domain;

import java.util.Date;
import java.util.Objects;

public class Email {

    private final EmailId emailId;
    private final String remitente;
    private final String destinatario;
    private final String copiaCarbon;
    private final String copiaOculta;
    private final String asunto;
    private String cuerpoMensaje;
    private final String origenMensaje;
    private final String adjunto1;
    private final String adjunto2;
    private final String adjunto3;
    private final String carpetaHtml;
    private final Number codigoEmpresa;
    private final Number CodigoOrigen;
    private final String codigoServidor;
    private final String codigoUsuario;
    private final Date fechaCreacion;
    private final Date fechaModificacion;
    private final String mailOrigen;
    private final String status;
    private final String tipo;
    private final String usuarioModificacion;
    private final String usuarioCreacion;
    private final Server server;

    public Email(EmailId emailId, String remitente, String destinatario, String copiaCarbon, String copiaOculta,
                 String asunto, String cuerpoMensaje, String origenMensaje, String adjunto1, String adjunto2,
                 String adjunto3, String carpetaHtml, Number codigoEmpresa, Number codigoOrigen, String codigoServidor,
                 String codigoUsuario, Date fechaCreacion, Date fechaModificacion, String mailOrigen, String status,
                 String tipo, String usuarioModificacion, String usuarioCreacion, Server server) {
        this.emailId = emailId;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.copiaCarbon = copiaCarbon;
        this.copiaOculta = copiaOculta;
        this.asunto = asunto;
        this.cuerpoMensaje = cuerpoMensaje;
        this.origenMensaje = origenMensaje;
        this.adjunto1 = adjunto1;
        this.adjunto2 = adjunto2;
        this.adjunto3 = adjunto3;
        this.carpetaHtml = carpetaHtml;
        this.codigoEmpresa = codigoEmpresa;
        this.CodigoOrigen = codigoOrigen;
        this.codigoServidor = codigoServidor;
        this.codigoUsuario = codigoUsuario;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.mailOrigen = mailOrigen;
        this.status = status;
        this.tipo = tipo;
        this.usuarioModificacion = usuarioModificacion;
        this.usuarioCreacion = usuarioCreacion;
        this.server = server;
    }

    public Email withId(EmailId emailId) {
        return new Email(emailId, remitente, destinatario, copiaCarbon, copiaOculta, asunto, cuerpoMensaje,
                         origenMensaje, adjunto1, adjunto2, adjunto3, carpetaHtml, codigoEmpresa, CodigoOrigen,
                         codigoServidor, codigoUsuario, fechaCreacion, fechaModificacion, mailOrigen, status, tipo,
                         usuarioModificacion, usuarioCreacion, server);
    }

    //public Optional<EmailId> getId() {
    //  return Optional.ofNullable(this.emailId);
    //}

    public EmailId getEmailId() {
        return emailId;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getCopiaCarbon() {
        return copiaCarbon;
    }

    public String getCopiaOculta() {
        return copiaOculta;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getCuerpoMensaje() {
        return cuerpoMensaje;
    }

    public String getOrigenMensaje() {
        return origenMensaje;
    }

    public String getAdjunto1() {
        return adjunto1;
    }

    public String getAdjunto2() {
        return adjunto2;
    }

    public String getAdjunto3() {
        return adjunto3;
    }

    public String getCarpetaHtml() {
        return carpetaHtml;
    }

    public Number getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public Number getReferencia() {
        return CodigoOrigen;
    }

    public String getCodigoServidor() {
        return codigoServidor;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public String getMailOrigen() {
        return mailOrigen;
    }

    public String getStatus() {
        return status;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
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
