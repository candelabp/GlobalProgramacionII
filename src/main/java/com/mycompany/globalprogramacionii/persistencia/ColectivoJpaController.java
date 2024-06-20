/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.globalprogramacionii.persistencia;

import com.mycompany.globalprogramacionii.logica.Colectivo;
import com.mycompany.globalprogramacionii.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author cande
 */
public class ColectivoJpaController implements Serializable {
public ColectivoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("GlobalPU");
    }
    public ColectivoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Colectivo colectivo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(colectivo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Colectivo colectivo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            colectivo = em.merge(colectivo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = colectivo.getId();
                if (findColectivo(id) == null) {
                    throw new NonexistentEntityException("The colectivo with id " + id + " no longer exists.");
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
            Colectivo colectivo;
            try {
                colectivo = em.getReference(Colectivo.class, id);
                colectivo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The colectivo with id " + id + " no longer exists.", enfe);
            }
            em.remove(colectivo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Colectivo> findColectivoEntities() {
        return findColectivoEntities(true, -1, -1);
    }

    public List<Colectivo> findColectivoEntities(int maxResults, int firstResult) {
        return findColectivoEntities(false, maxResults, firstResult);
    }

    private List<Colectivo> findColectivoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Colectivo.class));
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

    public Colectivo findColectivo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Colectivo.class, id);
        } finally {
            em.close();
        }
    }

    public int getColectivoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Colectivo> rt = cq.from(Colectivo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
