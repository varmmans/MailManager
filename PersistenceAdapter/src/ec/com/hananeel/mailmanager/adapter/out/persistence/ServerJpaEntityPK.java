package ec.com.hananeel.mailmanager.adapter.out.persistence;

import java.io.Serializable;

public class ServerJpaEntityPK implements Serializable {
    @SuppressWarnings("compatibility:4640842983239304537")
    private static final long serialVersionUID = 1L;
    private Number sercodemp;
    private String sercodser;

    public ServerJpaEntityPK() {
    }

    public ServerJpaEntityPK(Number sercodemp, String sercodser) {
        this.sercodemp = sercodemp;
        this.sercodser = sercodser;
    }

    public boolean equals(Object other) {
        if (other instanceof ServerJpaEntityPK) {
            final ServerJpaEntityPK otherServidorPersistenceAdapterPK = (ServerJpaEntityPK) other;
            final boolean areEqual =
                (otherServidorPersistenceAdapterPK.sercodemp.equals(sercodemp) &&
                 otherServidorPersistenceAdapterPK.sercodser.equals(sercodser));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Number getSercodemp() {
        return sercodemp;
    }

    public void setSercodemp(Number sercodemp) {
        this.sercodemp = sercodemp;
    }

    public String getSercodser() {
        return sercodser;
    }

    public void setSercodser(String sercodser) {
        this.sercodser = sercodser;
    }
}
