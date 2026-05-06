package com.example.gene.repository;

import com.example.gene.model.Gene;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
 
@Repository
public class GeneSearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

   public List<Gene> search(String geneName, String description, String operator) {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Gene> cq = cb.createQuery(Gene.class);
    Root<Gene> gene = cq.from(Gene.class);

    List<Predicate> predicates = new ArrayList<>();

    // --- Handle geneName ---
    if (geneName != null && !geneName.isEmpty()) {
        if (geneName.trim().toUpperCase().startsWith("NOT ")) {
            String term = geneName.substring(4).trim().toLowerCase();
            predicates.add(cb.not(cb.like(cb.lower(gene.get("geneName")), "%" + term + "%")));
        } else {
            predicates.add(cb.like(cb.lower(gene.get("geneName")), "%" + geneName.toLowerCase() + "%"));
        }
    }

    // --- Handle description ---
    if (description != null && !description.isEmpty()) {
        if (description.trim().toUpperCase().startsWith("NOT ")) {
            String term = description.substring(4).trim().toLowerCase();
            predicates.add(cb.not(cb.like(cb.lower(gene.get("description")), "%" + term + "%")));
        } else {
            predicates.add(cb.like(cb.lower(gene.get("description")), "%" + description.toLowerCase() + "%"));
        }
    }

    // --- Combine predicates ---
    if (predicates.size() > 1) {
        if (operator.equalsIgnoreCase("OR")) {
            cq.where(cb.or(predicates.toArray(new Predicate[0])));
        } else { // AND default
            cq.where(cb.and(predicates.toArray(new Predicate[0])));
        }
    } else if (predicates.size() == 1) {
        cq.where(predicates.get(0));
    }

    return entityManager.createQuery(cq).getResultList();
}

}
