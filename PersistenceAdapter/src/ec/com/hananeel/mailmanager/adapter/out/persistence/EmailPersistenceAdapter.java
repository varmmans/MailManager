package ec.com.hananeel.mailmanager.adapter.out.persistence;

import ec.com.hananeel.mailmanager.adapter.out.mapper.EmailMapper;
import ec.com.hananeel.mailmanager.adapter.out.mapper.ServerMapper;
import ec.com.hananeel.mailmanager.application.port.out.EmailPort;
import ec.com.hananeel.mailmanager.domain.Email;
import ec.com.hananeel.mailmanager.exception.AdapterException;
import ec.com.hananeel.mailmanager.qualifier.PersistenceAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

@Stateless(name = "EmailPersistenceAdapter", mappedName = "EmailPersistenceAdapter")
@PersistenceAdapter
public class EmailPersistenceAdapter implements EmailPort {
    @Resource
    SessionContext sessionContext;

    @EJB
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
    public Email sendEmail(Email email) throws AdapterException {

        try {
            // Get message properties
            String protocol = "smtp";
            String host = email.getServer().getSerdirrec();
            Integer port = email.getServer().getSernropor();
            String user = email.getServer().getSerusuari();
            String password = email.getServer().getSerpasswr();
            String from = email.getRemitente();
            String to = Optional.ofNullable(email.getDestinatario()).orElseThrow(NoSuchElementException::new);
            Optional<String> cc = Optional.ofNullable(email.getCopiaCarbon());
            Optional<String> bcc = Optional.ofNullable(email.getCopiaOculta());
            String subject = Optional.ofNullable(email.getAsunto()).orElseThrow(NoSuchElementException::new);
            String bodyMessage = email.isHtml() ? email.getCarpeta() : email.getCuerpoMensaje();
            Optional<String> att1 = Optional.ofNullable(email.getAdjunto1());
            Optional<String> att2 = Optional.ofNullable(email.getAdjunto2());
            Optional<String> att3 = Optional.ofNullable(email.getAdjunto3());
            String typeContent = email.isHtml() ? "text/html; charset=utf-8" : "text/plain; charset=utf-8";
            // Set server properties
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", port);
            props.put("mail.smtp.auth", true);
            props.put("mail.smtp.ssl.enable", true);
            props.put("mail.smtp.starttls.enable", true);
            // Create session instance
            Session session = Session.getInstance(props);
            session.setDebug(true);
            // Set message parts
            MimeMultipart multipart = new MimeMultipart();
            BodyPart body = new MimeBodyPart();
            body.setContent(bodyMessage, typeContent);
            multipart.addBodyPart(body);
            // Add attachments
            getBodyAttachments(att1.orElse(""), att2.orElse(""), att3.orElse("")).forEach(x -> {
                try {
                    multipart.addBodyPart(x);
                } catch (MessagingException me) {
                    throw new RuntimeException(me);
                }
            });
            //Compose the message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            if (cc.isPresent())
                message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc.get()));
            if (bcc.isPresent())
                message.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc.get()));
            message.setSubject(subject);
            message.setContent(multipart, typeContent);
            //Send the message
            Transport transport = session.getTransport(protocol);
            transport.connect(user, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            throw new AdapterException(e);
        }

        return email;
    }

    private List<BodyPart> getBodyAttachments(String... paths) {
        List<BodyPart> attachments = new ArrayList<>();
        for (String path : paths) {
            if (Objects.nonNull(path) || !path.isEmpty()) {
                FileDataSource file = new FileDataSource(path);
                if (file.getFile().exists()) {
                    BodyPart attachment = new MimeBodyPart();
                    try {
                        attachment.setDataHandler(new DataHandler(file));
                        attachment.setFileName(file.getName());
                        attachments.add(attachment);
                    } catch (MessagingException e) {
                        continue;
                    }
                }
            }
        }

        return attachments;
    }

    @Override
    public Email saveEmail(Email e) {
        EmailJpaEntityPK emailJpaEntityPK =
            new EmailJpaEntityPK(e.getCodigoEmpresa(), e.getEmailId().getCodigoMensaje());
        String mesasunto = e.getAsunto();
        String mescarpet = null; //e.getCarpeta();
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

        //EmailJpaEntity entity = EmailMapper.mapToJpaEntity(email);
        EmailJpaEntity entity =
            new EmailJpaEntity(emailJpaEntityPK, mescodrel, mesorigen, mescoduse, mescodser, mesnombre, messender,
                               mesmailto, mesmailcc, mesmailco, mesasunto, mescuerpo, mescarpet, messatt01, messatt02,
                               messatt03, messtatus, messtatut, mesusenew, mesfecnew, mesusemod, mesfecmod,
                               serverJpaEntity);
        emailRepository.mergeEmailJpaEntity(entity);
        
        return EmailMapper.mapToDomainEntity(entity);
    }

}
