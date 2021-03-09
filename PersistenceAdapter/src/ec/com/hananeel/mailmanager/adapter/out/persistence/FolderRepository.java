package ec.com.hananeel.mailmanager.adapter.out.persistence;

import ec.com.hananeel.mailmanager.exception.AdapterException;

import java.io.File;
import java.io.IOException;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.apache.commons.validator.routines.UrlValidator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@Stateless(name = "FolderRepository", mappedName = "FolderRepository")
@Local
public class FolderRepository {
    @Resource
    SessionContext sessionContext;
    UrlValidator validator;

    public FolderRepository() {
        validator = new UrlValidator();
    }

    public String loadHtmlScript(String fileUrlPath) throws AdapterException {
        StringBuilder stringHtml = new StringBuilder();
        Document doc;
        // Recuperar archivo desde el sistema de archivos del servidor
        try {
            String path = Optional.ofNullable(fileUrlPath).orElseThrow(NoSuchElementException::new);
            File input = new File(path);
            doc = (input.exists()) ? Jsoup.parse(input, "UTF-8", "") : new Document("Recurso HTML no disponible.");//Jsoup.connect(path).get();
            stringHtml.append(doc.html());
        } catch (IOException e) {
            throw new AdapterException(e);
        }
        // Retornar el mensaje HTML completo
        return stringHtml.toString();
    }
}
