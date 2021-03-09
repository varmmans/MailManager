package ec.com.hananeel.mailmanager.adapter.out.persistence;

import ec.com.hananeel.mailmanager.application.port.out.ServerPort;
import ec.com.hananeel.mailmanager.domain.Server;
import ec.com.hananeel.mailmanager.qualifier.Component;

import javax.inject.Inject;

@Component
public class ServerPersistenceAdapter implements ServerPort {

    @Inject
    private ServerRepository serverRepository;

    public ServerPersistenceAdapter() {
    }

    @Override
    public Server loadServer(Server.ServerId serverId) {
        // Obtener la entidad JPA
        ServerJpaEntityPK pk = new ServerJpaEntityPK(serverId.getSercodemp(), serverId.getSercodser());
        ServerJpaEntity jpa = serverRepository.findServidorJpaEntity(pk);
        // Mapear la entidad JPA con la entidad de dominio
        return ServerMapper.mapToDomainEntity(jpa);
    }

    public static class ServerMapper {

        public static Server mapToDomainEntity(ServerJpaEntity jpa) {
            Server.ServerId serverId = new Server.ServerId(jpa.getSercodemp(), jpa.getSercodser());
            return Server.withId(serverId, jpa.getSerdirrec(), jpa.getSernropor(), jpa.getSerpasswr(),
                                 jpa.getSerusuari());
        }

        public static ServerJpaEntity mapToJpaEntity(Server server) {
            return new ServerJpaEntity(server.getServerId().getSercodemp(), server.getServerId().getSercodser(),
                                       server.getSerdirrec(), server.getSernropor(), server.getSerpasswr(),
                                       server.getSerusuari());
        }
    }
}
