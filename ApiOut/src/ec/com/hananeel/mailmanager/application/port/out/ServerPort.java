package ec.com.hananeel.mailmanager.application.port.out;

import ec.com.hananeel.mailmanager.domain.Server;
import ec.com.hananeel.mailmanager.domain.Server.ServerId;

import javax.ejb.Local;

@Local
public interface ServerPort {
    Server loadServer(ServerId serverId);
}
