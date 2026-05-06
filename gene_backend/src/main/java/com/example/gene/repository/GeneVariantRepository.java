package com.example.gene.repository;

import com.example.gene.model.GeneVariant;
import com.example.gene.model.GeneVariantId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneVariantRepository extends JpaRepository<GeneVariant, GeneVariantId> {
}
