package ec.com.hananeel.mailmanager.adapter.out.persistence;

import java.io.Serializable;

public class EmailJpaEntityPK implements Serializable {
    @SuppressWarnings("compatibility:-8863493256212102591")
    private static final long serialVersionUID = 1L;
    private Number mescodmes;

    public EmailJpaEntityPK() {
    }

    public EmailJpaEntityPK(Number mescodmes) {
        this.mescodmes = mescodmes;
    }

    public boolean equals(Object other) {
        if (other instanceof EmailJpaEntityPK) {
            final EmailJpaEntityPK otherMensajePersistenceAdapterPK = (EmailJpaEntityPK) other;
            final boolean areEqual = (otherMensajePersistenceAdapterPK.mescodmes.equals(mescodmes));
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Number getMescodmes() {
        return mescodmes;
    }

    public void setMescodmes(Number mescodmes) {
        this.mescodmes = mescodmes;
    }
}
