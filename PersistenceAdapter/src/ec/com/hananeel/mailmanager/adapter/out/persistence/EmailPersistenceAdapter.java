package ec.com.hananeel.mailmanager.adapter.out.persistence;

import ec.com.hananeel.mailmanager.application.port.out.EmailPort;
import ec.com.hananeel.mailmanager.domain.Email;
import ec.com.hananeel.mailmanager.domain.Server;
import ec.com.hananeel.mailmanager.qualifier.Component;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.inject.Inject;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class EmailPersistenceAdapter implements EmailPort {

    @Inject
    private EmailRepository emailRepository;

    public EmailPersistenceAdapter() {
    }

    @Override
    public List<Email> loadEmailxStatus(String status) {
        return emailRepository.queryByStatus(Email.Status
                                                  .PENDING
                                                  .toString())
                              .stream()
                              .map(x -> EmailMapper.mapToDomainEntity(x))
                              .collect(Collectors.toList());
    }

    @Override
    public Email sendEmail(Email email) {
        // Mapear propiedades
        String host = email.getServer().getSerdirrec();
        String user = email.getServer().getSerusuari();
        String password = email.getServer().getSerpasswr();
        String to = email.getDestinatario();
        String subject = email.getAsunto();
        String text = email.getCuerpoMensaje();
        // Obtener el objeto sesión
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", Boolean.TRUE.toString());

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);

            //send the message
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return email;
    }

    @Override
    public Email saveEmail(Email email) {
        return EmailMapper.mapToDomainEntity(emailRepository.persistMensajeJpaEntity(EmailMapper.mapToJpaEntity(email)));
    }

    public static class EmailMapper {
        // Mapeo Entidad JPA a Entidad de Dominio
        public static EmailJpaEntity mapToJpaEntity(Email e) {

            Server s = e.getServer();
            ServerJpaEntity server =
                new ServerJpaEntity(s.getServerId().getSercodemp(), s.getServerId().getSercodser(), s.getSerdirrec(),
                                    s.getSernropor(), s.getSerpasswr(), s.getSerusuari());
            return new EmailJpaEntity(e.getAsunto(), e.getCarpetaHtml(), server, e.getEmailId().getCodigoMensaje(),
                                      e.getReferencia(), e.getCodigoServidor(), e.getCodigoUsuario(),
                                      e.getCuerpoMensaje(), e.getFechaModificacion(), e.getFechaCreacion(),
                                      e.getCopiaCarbon(), e.getCopiaOculta(), e.getDestinatario(), e.getRemitente(),
                                      e.getOrigenMensaje(), e.getAdjunto1(), e.getAdjunto2(), e.getAdjunto3(),
                                      e.getMailOrigen(), e.getStatus(), e.getTipo(), e.getUsuarioModificacion(),
                                      e.getUsuarioCreacion());

        }

        public static Email mapToDomainEntity(EmailJpaEntity e) {
            ServerJpaEntity s = e.getServidor();
            Server server =
                new Server(new Server.ServerId(s.getSercodemp(), s.getSercodser()), s.getSerdirrec(), s.getSernropor(),
                           s.getSerpasswr(), s.getSerusuari());
            return new Email(new Email.EmailId(e.getMescodmes()), e.getMesnombre(), e.getMesmailto(), e.getMesmailcc(),
                             e.getMesmailco(), e.getMesasunto(), e.getMescuerpo(), e.getMesorigen(), e.getMessatt01(),
                             e.getMessatt02(), e.getMessatt03(), e.getMescarpet(), s.getSercodemp(), e.getMescodrel(),
                             e.getMescodser(), e.getMescoduse(), e.getMesfecnew(), e.getMesfecmod(), e.getMessender(),
                             e.getMesstatus(), e.getMesstatut(), e.getMesusemod(), e.getMesusenew(), server);
        }


    }
}
