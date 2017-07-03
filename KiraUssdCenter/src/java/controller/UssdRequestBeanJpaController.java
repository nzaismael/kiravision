/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import controller.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import ussd.entities.UssdRequestBean;

/**
 *
 * @author ismaelnzamutuma
 */
public class UssdRequestBeanJpaController implements Serializable {

    public UssdRequestBeanJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UssdRequestBean ussdRequestBean) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(ussdRequestBean);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findUssdRequestBean(ussdRequestBean.getSessionId()) != null) {
                throw new PreexistingEntityException("UssdRequestBean " + ussdRequestBean + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UssdRequestBean ussdRequestBean) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ussdRequestBean = em.merge(ussdRequestBean);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ussdRequestBean.getSessionId();
                if (findUssdRequestBean(id) == null) {
                    throw new NonexistentEntityException("The ussdRequestBean with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            UssdRequestBean ussdRequestBean;
            try {
                ussdRequestBean = em.getReference(UssdRequestBean.class, id);
                ussdRequestBean.getSessionId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ussdRequestBean with id " + id + " no longer exists.", enfe);
            }
            em.remove(ussdRequestBean);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UssdRequestBean> findUssdRequestBeanEntities() {
        return findUssdRequestBeanEntities(true, -1, -1);
    }

    public List<UssdRequestBean> findUssdRequestBeanEntities(int maxResults, int firstResult) {
        return findUssdRequestBeanEntities(false, maxResults, firstResult);
    }

    private List<UssdRequestBean> findUssdRequestBeanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UssdRequestBean.class));
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

    public UssdRequestBean findUssdRequestBean(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UssdRequestBean.class, id);
        } finally {
            em.close();
        }
    }

    public int getUssdRequestBeanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UssdRequestBean> rt = cq.from(UssdRequestBean.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
