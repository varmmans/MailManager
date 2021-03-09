package ec.com.hananeel.mailmanager.adapter.out.mapper;

import ec.com.hananeel.mailmanager.adapter.out.persistence.EmailJpaEntity;
import ec.com.hananeel.mailmanager.adapter.out.persistence.EmailJpaEntityPK;
import ec.com.hananeel.mailmanager.adapter.out.persistence.ServerJpaEntity;
import ec.com.hananeel.mailmanager.domain.Email;
import ec.com.hananeel.mailmanager.domain.Server;

import java.util.Date;

public class EmailMapper {

    // Mapeo a Entidad JPA
    public static EmailJpaEntity mapToJpaEntity(Email e) {
        EmailJpaEntityPK emailJpaEntityPK =
            new EmailJpaEntityPK(e.getCodigoEmpresa(), e.getEmailId().getCodigoMensaje());
        String mesasunto = e.getAsunto();
        String mescarpet = e.getCarpeta();
        Number mescodrel = e.getCodigoOrigen();
        String mescodser = e.getCodigoServidor();
        String mescoduse = e.getCodigoUsuario();
        String mescuerpo = e.getCuerpoMensaje();
        Date mesfecmod = e.getFechaModificacion();
        Date mesfecnew = e.getFechaCreacion();
        String mesmailcc = e.getCopiaCarbon();
        String mesmailco = e.getCopiaOculta();
        String mesmailto = e.getDestinatario();
        String mesnombre = e.getNombre();
        String mesorigen = e.getOrigenMensaje();
        String messatt01 = e.getAdjunto1();
        String messatt02 = e.getAdjunto2();
        String messatt03 = e.getAdjunto3();
        String messender = e.getRemitente();
        String messtatus = e.getStatus();
        String messtatut = e.getTipo();
        String mesusemod = e.getUsuarioModificacion();
        String mesusenew = e.getUsuarioCreacion();
        ServerJpaEntity serverJpaEntity = ServerMapper.mapToJpaEntity(e.getServer());

        return new EmailJpaEntity(emailJpaEntityPK, mescodrel, mesorigen, mescoduse, mescodser, mesnombre, messender,
                                  mesmailto, mesmailcc, mesmailco, mesasunto, mescuerpo, mescarpet, messatt01,
                                  messatt02, messatt03, messtatus, messtatut, mesusenew, mesfecnew, mesusemod,
                                  mesfecmod, serverJpaEntity);
    }
    // Mapeo Entidad JPA a Entidad de Dominio
    public static Email mapToDomainEntity(EmailJpaEntity e) {
        String asunto = e.getMesasunto();
        String carpeta = e.getMescarpet();
        Email.EmailId emailId = new Email.EmailId(e.getEmailJpaEntityPK().getMescodmes());
        Number codigoOrigen = e.getMescodrel();
        Number codigoEmpresa = e.getEmailJpaEntityPK().getMescodemp();
        String codigoServidor = e.getMescodser();
        String codigoUsuario = e.getMescoduse();
        String cuerpoMensaje = e.getMescuerpo();
        Date fechaModificacion = e.getMesfecmod();
        Date fechaCreacion = e.getMesfecnew();
        String copiaCarbon = e.getMesmailcc();
        String copiaOculta = e.getMesmailco();
        String destinatario = e.getMesmailto();
        String nombre = e.getMesnombre();
        String origenMensaje = e.getMesorigen();
        String adjunto1 = e.getMessatt01();
        String adjunto2 = e.getMessatt02();
        String adjunto3 = e.getMessatt03();
        String remitente = e.getMessender();
        String status = e.getMesstatus();
        String tipo = e.getMesstatut();
        String usuarioModificacion = e.getMesusemod();
        String usuarioCreacion = e.getMesusenew();
        Server server = ServerMapper.mapToDomainEntity(e.getServerJpaEntity());

        return new Email(asunto, carpeta, emailId, codigoOrigen, codigoEmpresa, codigoServidor, codigoUsuario,
                         cuerpoMensaje, fechaModificacion, fechaCreacion, copiaCarbon, copiaOculta, destinatario,
                         nombre, origenMensaje, adjunto1, adjunto2, adjunto3, remitente, status, tipo,
                         usuarioModificacion, usuarioCreacion, server);
    }
}
