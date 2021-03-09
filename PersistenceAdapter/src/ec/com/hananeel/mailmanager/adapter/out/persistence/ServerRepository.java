package ec.com.hananeel.mailmanager.adapter.out.persistence;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "ServerRepository", mappedName = "ServerRepository")
@Local
public class ServerRepository {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "PersistenceAdapter")
    private EntityManager em;

    public ServerRepository() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
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
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ServerJpaEntity findServerJpaEntity(ServerJpaEntityPK pk) {
        return em.find(ServerJpaEntity.class, pk);
    }
}
