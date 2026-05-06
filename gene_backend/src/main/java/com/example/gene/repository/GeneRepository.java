package com.example.gene.repository;

import com.example.gene.model.Gene;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GeneRepository extends JpaRepository<Gene, String> {

    // Χρησιμοποιεί το @NamedEntityGraph("Gene.withAll") για να φορτώνει transcripts + variants
    @EntityGraph(value = "Gene.withAll", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Gene> findWithAllByGeneId(String geneId);

    

}
