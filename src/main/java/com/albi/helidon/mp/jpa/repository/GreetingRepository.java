package com.albi.helidon.mp.jpa.repository;

import com.albi.helidon.mp.jpa.model.Greeting;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Dependent
public class GreetingRepository {

    @PersistenceContext
    EntityManager em;

    public Greeting findBySalutation(String salutation) {
        TypedQuery<Greeting> query = em.createQuery("Select greeting from Greeting greeting " +
                "where greeting.salutation = :salutation", Greeting.class);
        query.setParameter("salutation", salutation);
        return query.getSingleResult();
    }

}
