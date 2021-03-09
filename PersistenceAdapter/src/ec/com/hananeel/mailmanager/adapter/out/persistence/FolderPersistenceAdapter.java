package ec.com.hananeel.mailmanager.adapter.out.persistence;

import ec.com.hananeel.mailmanager.application.port.out.FolderPort;
import ec.com.hananeel.mailmanager.exception.AdapterException;
import ec.com.hananeel.mailmanager.qualifier.PersistenceAdapter;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "FolderPersistenceAdapter", mappedName = "FolderPersistenceAdapter")
@PersistenceAdapter
public class FolderPersistenceAdapter implements FolderPort {
    @Resource
    SessionContext sessionContext;

    @EJB
    private FolderRepository folderRepository;

    public FolderPersistenceAdapter() {
    }

    @Override
    public String loadHtmlScript(String folderPath) throws AdapterException {
        try {
            return folderRepository.loadHtmlScript(folderPath);
        } catch (AdapterException e) {
            throw e;
        }
    }
}
