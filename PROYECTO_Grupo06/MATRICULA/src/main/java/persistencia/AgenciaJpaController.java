package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Agencia;
import persistencia.exceptions.NonexistentEntityException;

public class AgenciaJpaController implements Serializable {

    public AgenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public AgenciaJpaController() {
        emf=Persistence.createEntityManagerFactory("MATRICULA_PU");
    }

    public void create(Agencia agencia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(agencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Agencia agencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            agencia = em.merge(agencia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = agencia.getId();
                if (findAgencia(id) == null) {
                    throw new NonexistentEntityException("The agencia with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Agencia agencia;
            try {
                agencia = em.getReference(Agencia.class, id);
                agencia.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The agencia with id " + id + " no longer exists.", enfe);
            }
            em.remove(agencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Agencia> findAgenciaEntities() {
        return findAgenciaEntities(true, -1, -1);
    }

    public List<Agencia> findAgenciaEntities(int maxResults, int firstResult) {
        return findAgenciaEntities(false, maxResults, firstResult);
    }

    private List<Agencia> findAgenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Agencia.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Agencia findAgencia(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Agencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getAgenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Agencia> rt = cq.from(Agencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
