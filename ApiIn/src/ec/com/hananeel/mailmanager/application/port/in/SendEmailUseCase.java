package ec.com.hananeel.mailmanager.application.port.in;

import ec.com.hananeel.mailmanager.common.SelfValidating;
import ec.com.hananeel.mailmanager.domain.Email;
import ec.com.hananeel.mailmanager.exception.ApplicationException;
import ec.com.hananeel.mailmanager.qualifier.Component;

import java.util.List;

import javax.ejb.Local;

@Local
public interface SendEmailUseCase {

    List<Email> sendEmails(SendEmailCommand command) throws ApplicationException;

    @Component
    public static class SendEmailCommand extends SelfValidating<SendEmailCommand> {

        public SendEmailCommand() {
        }
    }
}
