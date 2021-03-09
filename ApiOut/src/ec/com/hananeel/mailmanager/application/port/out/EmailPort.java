package ec.com.hananeel.mailmanager.application.port.out;

import ec.com.hananeel.mailmanager.domain.Email;

import java.util.List;

public interface EmailPort {
    List<Email> loadEmailxStatus(String status);
    Email sendEmail(Email email);
    Email saveEmail(Email email);
}
