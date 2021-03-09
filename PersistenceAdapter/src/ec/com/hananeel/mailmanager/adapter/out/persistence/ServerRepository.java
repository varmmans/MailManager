package ec.com.hananeel.mailmanager.adapter.out.persistence;


import javax.enterprise.context.Dependent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Dependent
public class ServerRepository {
    private final EntityManager em;

    public ServerRepository() {
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

    public ServerJpaEntity persistServidorJpaEntity(ServerJpaEntity servidorJpaEntity) {
        em.persist(servidorJpaEntity);
        commitTransaction();
        return servidorJpaEntity;
    }

    public ServerJpaEntity mergeServidorJpaEntity(ServerJpaEntity servidorJpaEntity) {
        ServerJpaEntity entity = null;
        entity = em.merge(servidorJpaEntity);
        commitTransaction();
        return entity;
    }

    public void removeServidorJpaEntity(ServerJpaEntity servidorJpaEntity) {
        servidorJpaEntity =
            em.find(ServerJpaEntity.class,
                    new ServerJpaEntityPK(servidorJpaEntity.getSercodemp(), servidorJpaEntity.getSercodser()));
        em.remove(servidorJpaEntity);
        commitTransaction();
    }
    
    public ServerJpaEntity findServidorJpaEntity(ServerJpaEntityPK pk){
        return em.find(ServerJpaEntity.class, pk);
    }
}
