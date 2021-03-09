package ec.com.hananeel.mailmanager.application.port.out;

import ec.com.hananeel.mailmanager.exception.AdapterException;


public interface FolderPort {
    String loadHtmlScript(String folderPath) throws AdapterException;
}
