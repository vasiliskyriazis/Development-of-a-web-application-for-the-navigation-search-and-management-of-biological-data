package com.example.gene.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gene_variant")
public class GeneVariant {

    @EmbeddedId
    private GeneVariantId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("geneId")
    @JoinColumn(name = "gene_id", nullable = false)
    private Gene gene;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("variantId")
    @JoinColumn(name = "variant_id",  referencedColumnName = "clinvar_id", nullable = false)
    private Variant variant;

    // --- Getters/Setters ---
    public GeneVariantId getId() {
        return id;
    }

    public void setId(GeneVariantId id) {
        this.id = id;
    }

    public Gene getGene() {
        return gene;
    }

    public void setGene(Gene gene) {
        this.gene = gene;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }
}
