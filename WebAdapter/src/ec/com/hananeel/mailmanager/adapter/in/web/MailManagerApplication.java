package ec.com.hananeel.mailmanager.adapter.in.web;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("emails")
public class MailManagerApplication extends Application {
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();

        // Register root resources.
        classes.add(SendEmailController.class);

        // Register provider classes.

        return classes;
    }
}
