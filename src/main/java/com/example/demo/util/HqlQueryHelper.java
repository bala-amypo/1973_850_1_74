package com.example.demo.util;

import com.example.demo.model.Claim;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HqlQueryHelper {

    private final EntityManager entityManager;

    // Must use Constructor Injection 
    public HqlQueryHelper(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Returns claims where the description contains the keyword (case-insensitive) [cite: 44, 45]
    public List<Claim> findClaimsByDescriptionKeyword(String keyword) {
        String hql = "FROM Claim c WHERE LOWER(c.description) LIKE LOWER(:keyword)";
        TypedQuery<Claim> query = entityManager.createQuery(hql, Claim.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }

    // Returns claims where claimAmount > minAmount [cite: 46]
    public List<Claim> findHighValueClaims(Double minAmount) {
        String hql = "FROM Claim c WHERE c.claimAmount > :minAmount";
        TypedQuery<Claim> query = entityManager.createQuery(hql, Claim.class);
        query.setParameter("minAmount", minAmount);
        return query.getResultList();
    }
}