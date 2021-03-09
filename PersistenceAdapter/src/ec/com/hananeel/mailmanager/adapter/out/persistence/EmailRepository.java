package ec.com.hananeel.mailmanager.adapter.out.persistence;


import ec.com.hananeel.mailmanager.domain.Email;

import java.util.List;

import javax.enterprise.context.Dependent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Dependent
public class EmailRepository {
    private final EntityManager em;

    public EmailRepository() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAdapter");
        em = emf.createEntityManager();
    }

    /**
     * All changes that have been made to the managed entities in the
     * persistence context are applied to the database and committed.
     */
    public void commitTransaction() {
        final EntityTransaction entityTransaction = em.getTransaction();
        if (!entityTransaction.isActive()) {
            entityTransaction.begin();
        }
        entityTransaction.commit();
    }

    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        commitTransaction();
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        entity = em.merge(entity);
        commitTransaction();
        return entity;
    }

    public EmailJpaEntity persistMensajeJpaEntity(EmailJpaEntity mensajeJpaEntity) {
        em.persist(mensajeJpaEntity);
        commitTransaction();
        return mensajeJpaEntity;
    }

    public EmailJpaEntity mergeMensajeJpaEntity(EmailJpaEntity mensajeJpaEntity) {
        EmailJpaEntity entity = null;
        entity = em.merge(mensajeJpaEntity);
        commitTransaction();
        return entity;
    }

    public void removeMensajeJpaEntity(EmailJpaEntity mensajeJpaEntity) {
        mensajeJpaEntity = em.find(EmailJpaEntity.class, new EmailJpaEntityPK(mensajeJpaEntity.getMescodmes()));
        em.remove(mensajeJpaEntity);
        commitTransaction();
    }
    
    public EmailJpaEntity findMensajeJpaEntity(EmailJpaEntity pk){
        return em.find(EmailJpaEntity.class, pk);
    }

    List<EmailJpaEntity> queryByStatus(String string) {
        TypedQuery<EmailJpaEntity> queryByStatus = em.createNamedQuery("findByStatus",EmailJpaEntity.class).setParameter("messtatus", Email.Status.PENDING.toString());
        
        return null;
    }
}
