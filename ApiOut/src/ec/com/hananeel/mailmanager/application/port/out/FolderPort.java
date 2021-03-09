package ec.com.hananeel.mailmanager.application.port.out;

import ec.com.hananeel.mailmanager.exception.AdapterException;

import javax.ejb.Local;

@Local
public interface FolderPort {
    String loadHtmlScript(String folderPath) throws AdapterException;
}
