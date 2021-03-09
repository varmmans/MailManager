package ec.com.hananeel.mailmanager.domain;


public class Server {

    private final ServerId serverId;
    private final String serdirrec;
    private final Integer sernropor;
    private final String serpasswr;
    private final String serusuari;

    public Server(ServerId serverId, String serdirrec, Integer sernropor, String serpasswr, String serusuari) {
        this.serverId = serverId;
        this.serdirrec = serdirrec;
        this.sernropor = sernropor;
        this.serpasswr = serpasswr;
        this.serusuari = serusuari;
    }

    public ServerId getServerId() {
        return serverId;
    }

    public String getSerdirrec() {
        return serdirrec;
    }

    public Integer getSernropor() {
        return sernropor;
    }

    public String getSerpasswr() {
        return serpasswr;
    }

    public String getSerusuari() {
        return serusuari;
    }

    public static Server withId(ServerId serverId, String serdirrec, Integer sernropor, String serpasswr,
                                String serusuari) {
        return new Server(serverId, serdirrec, sernropor, serpasswr, serusuari);
    }

    public static class ServerId {
        private final Number sercodemp;
        private final String sercodser;

        public ServerId(Number sercodemp, String sercodser) {
            this.sercodemp = sercodemp;
            this.sercodser = sercodser;
        }

        public Number getSercodemp() {
            return sercodemp;
        }

        public String getSercodser() {
            return sercodser;
        }
    }
}
