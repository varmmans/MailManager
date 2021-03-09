package ec.com.hananeel.mailmanager.adapter.out.persistence;

import ec.com.hananeel.mailmanager.application.port.out.FolderPort;
import ec.com.hananeel.mailmanager.exception.AdapterException;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FolderPersistenceAdapter implements FolderPort {

    @Override
    public String loadHtmlScript(String folderPath) throws AdapterException {
        StringBuilder html = new StringBuilder();
        // Recuperar archivo desde el sistema de archivos del servidor
        File input = new File(folderPath);
        if (input.exists())
            try {
                Document doc = Jsoup.parse(input, "UTF-8", "");
                html.append(doc.html());
            } catch (IOException e) {
                throw new AdapterException(e);
            }
        // Retornar el mensaje HTML completo
        return html.toString();
    }
}
