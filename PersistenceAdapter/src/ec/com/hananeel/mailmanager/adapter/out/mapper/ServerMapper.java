package ec.com.hananeel.mailmanager.adapter.out.mapper;

import ec.com.hananeel.mailmanager.adapter.out.persistence.ServerJpaEntity;
import ec.com.hananeel.mailmanager.adapter.out.persistence.ServerJpaEntityPK;
import ec.com.hananeel.mailmanager.domain.Server;

public class ServerMapper {

    public static Server mapToDomainEntity(ServerJpaEntity jpa) {
        // Fields map
        Server.ServerId serverId =
            new Server.ServerId(jpa.getServerJpaEntityPK().getSercodemp(), jpa.getServerJpaEntityPK().getSercodser());
        String serdirrec = jpa.getSerdirrec();
        Integer sernropor = jpa.getSernropor();
        String serpasswr = jpa.getSerpasswr();
        String serusuari = jpa.getSerusuari();

        return new Server(serverId, serdirrec, sernropor, serpasswr, serusuari);
    }

    public static ServerJpaEntity mapToJpaEntity(Server server) {
        // Fields map
        ServerJpaEntityPK serverJpaEntityPK =
            new ServerJpaEntityPK(server.getServerId().getSercodemp(), server.getServerId().getSercodser());
        String serdirrec = server.getSerdirrec();
        Integer sernropor = server.getSernropor();
        String serusuari = server.getSerusuari();
        String serpasswr = server.getSerpasswr();

        return new ServerJpaEntity(serverJpaEntityPK, serdirrec, sernropor, serusuari, serpasswr);
    }
}
