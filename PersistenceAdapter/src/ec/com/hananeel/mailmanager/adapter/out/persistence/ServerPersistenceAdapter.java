package ec.com.hananeel.mailmanager.adapter.out.persistence;

import ec.com.hananeel.mailmanager.adapter.out.mapper.ServerMapper;
import ec.com.hananeel.mailmanager.application.port.out.ServerPort;
import ec.com.hananeel.mailmanager.domain.Server;
import ec.com.hananeel.mailmanager.qualifier.PersistenceAdapter;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "ServerPersistenceAdapter", mappedName = "ServerPersistenceAdapter")
@PersistenceAdapter
public class ServerPersistenceAdapter implements ServerPort {
    @Resource
    SessionContext sessionContext;

    @EJB
    private ServerRepository serverRepository;

    public ServerPersistenceAdapter() {
    }

    @Override
    public Server loadServer(Server.ServerId serverId) {
        // Obtener la entidad JPA
        ServerJpaEntityPK pk = new ServerJpaEntityPK(serverId.getSercodemp(), serverId.getSercodser());
        ServerJpaEntity jpa = serverRepository.findServerJpaEntity(pk);
        // Mapear la entidad JPA con la entidad de dominio
        return ServerMapper.mapToDomainEntity(jpa);
    }

}
