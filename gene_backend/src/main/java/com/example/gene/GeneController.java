package com.example.gene.controller;

import com.example.gene.model.Gene;
import com.example.gene.repository.GeneRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.gene.repository.GeneSearchRepository;


import java.util.List;
import java.util.Optional;

@CrossOrigin(
    origins = "http://localhost:4200",
    allowedHeaders = "*",
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
@RestController
@RequestMapping("/api/genes")
public class GeneController {

    private final GeneRepository geneRepository;
    private final GeneSearchRepository geneSearchRepository;

    public GeneController(GeneRepository geneRepository, GeneSearchRepository geneSearchRepository) {
        this.geneRepository = geneRepository;
        this.geneSearchRepository = geneSearchRepository;
    }

    // 1. Επιστροφή όλων των γονιδίων με associations
    @GetMapping
    public List<Gene> getAllGenes() {
        return geneRepository.findAll();
    }

    // 2. Επιστροφή συγκεκριμένου γονιδίου με associations
    @GetMapping("/{id}")
    public ResponseEntity<Gene> getGeneById(@PathVariable String id) {
        return geneRepository.findWithAllByGeneId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // 3. Εισαγωγή νέου γονιδίου
    @PostMapping
    public ResponseEntity<Gene> createGene(@RequestBody Gene gene) {
        if (geneRepository.existsById(gene.getGeneId())) {
            return ResponseEntity.badRequest().build(); 
        }
        Gene saved = geneRepository.save(gene);
        return ResponseEntity.ok(saved);
    }

    // 4. Ενημέρωση υπάρχοντος γονιδίου
    @PutMapping("/{id}")
    public ResponseEntity<Gene> updateGene(@PathVariable String id, @RequestBody Gene geneDetails) {
        return geneRepository.findById(id)
                .map(gene -> {
                    gene.setGeneName(geneDetails.getGeneName());
                    gene.setDescription(geneDetails.getDescription());
                    gene.setGeneType(geneDetails.getGeneType());
                    gene.setGcContent(geneDetails.getGcContent());
                    gene.setChrom(geneDetails.getChrom());
                    gene.setGeneStart(geneDetails.getGeneStart());
                    gene.setGeneEnd(geneDetails.getGeneEnd());
                    gene.setTranscriptCount(geneDetails.getTranscriptCount());
                    gene.setGeneSynonym(geneDetails.getGeneSynonym());
                    // transcripts & variants δεν τα ενημερώνουμε εδώ
                    Gene updated = geneRepository.save(gene);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 5. Διαγραφή γονιδίου
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGene(@PathVariable String id) {
        return geneRepository.findById(id)
                .map(g -> {
                    geneRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //6. Aναζήτηση
   @GetMapping("/search")
    public List<Gene> searchGenes(
            @RequestParam(required = false) String geneName,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "AND") String operator) {
        return geneSearchRepository.search(geneName, description, operator);
    }




}