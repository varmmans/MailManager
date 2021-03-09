package ec.com.hananeel.mailmanager.application.port.out;

import ec.com.hananeel.mailmanager.domain.Email;
import ec.com.hananeel.mailmanager.exception.AdapterException;

import java.util.List;

import javax.ejb.Local;

@Local
public interface EmailPort {
    List<Email> loadEmailxStatus(String status);

    Email sendEmail(Email email) throws AdapterException;

    Email saveEmail(Email email);
}
