package com.example.demo.util;

import com.example.demo.model.Claim;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;
import java.util.List;

@Component // [cite: 409]
public class HqlQueryHelper {
    private final EntityManager entityManager;

    public HqlQueryHelper(EntityManager entityManager) {
        this.entityManager = entityManager; // [cite: 409]
    }

    public List<Claim> findClaimsByDescriptionKeyword(String keyword) {
        String hql = "FROM Claim c WHERE LOWER(c.description) LIKE LOWER(:keyword)"; // [cite: 410, 413]
        return entityManager.createQuery(hql, Claim.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
    }

    public List<Claim> findHighValueClaims(Double minAmount) {
        String hql = "FROM Claim c WHERE c.claimAmount > :minAmount"; // [cite: 410, 414]
        return entityManager.createQuery(hql, Claim.class)
                .setParameter("minAmount", minAmount)
                .getResultList();
    }
}