package ec.com.hananeel.mailmanager.application.service;

import ec.com.hananeel.mailmanager.application.port.in.SendEmailUseCase;
import ec.com.hananeel.mailmanager.application.port.out.EmailPort;
import ec.com.hananeel.mailmanager.application.port.out.FolderPort;
import ec.com.hananeel.mailmanager.application.port.out.ServerPort;
import ec.com.hananeel.mailmanager.domain.Email;
import ec.com.hananeel.mailmanager.domain.Server;
import ec.com.hananeel.mailmanager.exception.AdapterException;
import ec.com.hananeel.mailmanager.exception.ApplicationException;
import ec.com.hananeel.mailmanager.qualifier.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.Dependent;

import javax.inject.Inject;

@Component
@Dependent
public class SendEmailService implements SendEmailUseCase {

    private final ServerPort serverPort;
    private final EmailPort emailPort;
    private final FolderPort folderPort;

    @Inject
    public SendEmailService(@Component ServerPort serverPort, @Component EmailPort emailPort,
                            @Component FolderPort folderPort) {
        this.serverPort = serverPort;
        this.emailPort = emailPort;
        this.folderPort = folderPort;
    }

    @Override
    public List<Email> sendEmails(SendEmailUseCase.SendEmailCommand command) throws ApplicationException {
        // Comando vacío, solo para trámite
        // Cargar listado de correos pendientes de envío
        List<Email> emailsIncome = emailPort.loadEmailxStatus(Email.Status
                                                                   .PENDING
                                                                   .toString());
        List<Email> emailsOutcome = new ArrayList<>();
        String html;
        Date fechaRegistro = new Date();

        // Por cada mensaje cargar información del servidor de correo, usuario, clave
        for (Email email : emailsIncome) {
            Server.ServerId serverId = new Server.ServerId(email.getCodigoEmpresa(), email.getCodigoServidor());
            Server server = serverPort.loadServer(serverId);
            // Elaborar el correo, si es de texto plano enviar, si es Html buscar en carpeta el script
            if (email.isHtml()) {
                try {
                    html = folderPort.loadHtmlScript(email.getCarpetaHtml());
                } catch (AdapterException e) {
                    throw new ApplicationException(e);
                }
            }

            // Enviar correo
            emailPort.sendEmail(email);
            // Actualizar las fechas y el estado del registro del mensaje
            Email e = email;
            if (email.isNewMessage()) {
                email =
                    new Email(e.getEmailId(), e.getRemitente(), e.getDestinatario(), e.getCopiaCarbon(),
                              e.getCopiaOculta(), e.getAsunto(), e.getCuerpoMensaje(), e.getOrigenMensaje(),
                              e.getAdjunto1(), e.getAdjunto2(), e.getAdjunto3(), e.getCarpetaHtml(),
                              e.getCodigoEmpresa(), e.getCodigoEmpresa(), e.getCodigoServidor(), e.getCodigoUsuario(),
                              fechaRegistro, fechaRegistro, e.getMailOrigen(), Email.Status
                                                                                    .SENDED
                                                                                    .toString(), e.getTipo(),
                              e.getUsuarioModificacion(), e.getUsuarioCreacion(), server);
            } else {
                email =
                    new Email(e.getEmailId(), e.getRemitente(), e.getDestinatario(), e.getCopiaCarbon(),
                              e.getCopiaOculta(), e.getAsunto(), e.getCuerpoMensaje(), e.getOrigenMensaje(),
                              e.getAdjunto1(), e.getAdjunto2(), e.getAdjunto3(), e.getCarpetaHtml(),
                              e.getCodigoEmpresa(), e.getCodigoEmpresa(), e.getCodigoServidor(), e.getCodigoUsuario(),
                              e.getFechaCreacion(), fechaRegistro, e.getMailOrigen(), Email.Status
                                                                                           .SENDED
                                                                                           .toString(), e.getTipo(),
                              e.getUsuarioModificacion(), e.getUsuarioCreacion(), server);
            }

            // Recopilar todos los mensajes enviados
            emailsOutcome.add(emailPort.saveEmail(email));
        }

        return emailsOutcome;
    }
}
