package com.example.demo.util;

import com.example.demo.model.Claim;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HqlQueryHelper {

    @PersistenceContext
    private EntityManager entityManager;

    // Find claims with amount greater than given value
    public List<Claim> findHighValueClaims(Double minAmount) {
        return entityManager.createQuery(
                "SELECT c FROM Claim c WHERE c.claimAmount > :amount",
                Claim.class
        )
        .setParameter("amount", minAmount)
        .getResultList();
    }

    // Find claims whose description contains a keyword
    public List<Claim> findClaimsByDescriptionKeyword(String keyword) {
        return entityManager.createQuery(
                "SELECT c FROM Claim c WHERE c.description LIKE :kw",
                Claim.class
        )
        .setParameter("kw", "%" + keyword + "%")
        .getResultList();
    }
}

