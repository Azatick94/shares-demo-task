package com.example.sharesdemotask.repositories;

import com.example.sharesdemotask.models.Quote;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QuoteRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Quote> findAll() {
        return em.createQuery("SELECT q FROM Quote q", Quote.class)
                .getResultList();
    }

    public Quote findById(int id)  {
        return em.find(Quote.class, id);
    }

    public List<Quote> findByIsin(String isin) {
        return em.createQuery("SELECT q FROM Quote q WHERE q.isin=:param", Quote.class)
                .setParameter("param", isin)
                .getResultList();
    }

    public void save(Quote quote) {
        if (quote.isNew()) {
            em.persist(quote);
        } else {
            em.merge(quote);
        }
    }
}
