package ec.com.hananeel.mailmanager.application.service;

import ec.com.hananeel.mailmanager.application.port.in.SendEmailUseCase;
import ec.com.hananeel.mailmanager.application.port.out.EmailPort;
import ec.com.hananeel.mailmanager.application.port.out.FolderPort;
import ec.com.hananeel.mailmanager.domain.Email;
import ec.com.hananeel.mailmanager.exception.AdapterException;
import ec.com.hananeel.mailmanager.exception.ApplicationException;
import ec.com.hananeel.mailmanager.qualifier.UseCase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.validation.ConstraintViolationException;

@Stateless(name = "SendEmailService", mappedName = "SendEmailService")
@UseCase
public class SendEmailService implements SendEmailUseCase {
    @Resource
    SessionContext sessionContext;
    @EJB
    private EmailPort emailPort;
    @EJB
    private FolderPort folderPort;

    public SendEmailService() {
    }

    @Override
    public List<Email> sendEmails(SendEmailUseCase.SendEmailCommand command) throws ApplicationException {
        // Comando vacío, solo para trámite
        // Cargar listado de correos pendientes de envío
        List<Email> emailsIncome = emailPort.loadEmailxStatus(Email.Status
                                                                   .PENDING
                                                                   .toString());
        Map<Email, String> emailsSended = new HashMap<>();
        Map<Email, String> emailsSaved = new HashMap<>();
        String body;

        // Por cada mensaje cargar información del servidor de correo, usuario, clave
        for (Email email : emailsIncome) {
            // Elaborar el correo, si es HTML buscar en carpeta el script
            try {
                body = email.isHtml() ? folderPort.loadHtmlScript(email.getCuerpoMensaje()) : email.getCuerpoMensaje();
                email.setFechaModificacion(new Date());
                email.setStatus(Email.Status
                                     .SENDED
                                     .toString());
                email.setCarpeta(body);
                // Enviar correo
                sendEmailAsync(email).thenAccept(x -> emailsSended.put(x, "OK"));
                // Actualizar registro.
                emailsSaved.put(emailPort.saveEmail(email), "OK");
            } catch (AdapterException | ConstraintViolationException e) {
                emailsSended.put(email, e.getMessage());
                emailsSaved.put(email, e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println(emailsSended.size() + " mensajes enviados.");
        System.out.println(emailsSaved.size() + " mensajes actualizados.");

        return new ArrayList<Email>(emailsSaved.keySet());
    }

    private CompletableFuture<Email> sendEmailAsync(Email email) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return emailPort.sendEmail(email);
            } catch (AdapterException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
