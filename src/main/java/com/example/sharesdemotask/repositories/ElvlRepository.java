package com.example.sharesdemotask.repositories;

import com.example.sharesdemotask.models.Elvl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ElvlRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Elvl> findAll() {
        return em.createQuery("SELECT e FROM Elvl e", Elvl.class)
                .getResultList();
    }

    public Elvl findByIsin(String isin) {
        try {
            return em.createQuery("SELECT e FROM Elvl e WHERE e.isin=:param", Elvl.class)
                    .setParameter("param", isin)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public void save(Elvl elvl) {
        if (elvl.isNew()) {
            em.persist(elvl);
        } else {
            em.merge(elvl);
        }
    }
}
