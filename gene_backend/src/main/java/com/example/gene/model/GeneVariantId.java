package com.example.gene.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GeneVariantId implements Serializable {

    @Column(name = "gene_id")
    private String geneId;

    @Column(name = "variant_id")
    private Long variantId;

    public GeneVariantId() {}

    public GeneVariantId(String geneId, Long variantId) {
        this.geneId = geneId;
        this.variantId = variantId;
    }

    // --- Getters/Setters ---
    public String getGeneId() {
        return geneId;
    }

    public void setGeneId(String geneId) {
        this.geneId = geneId;
    }

    public Long getVariantId() {
        return variantId;
    }

    public void setVariantId(Long variantId) {
        this.variantId = variantId;
    }

    // equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeneVariantId)) return false;
        GeneVariantId that = (GeneVariantId) o;
        return Objects.equals(geneId, that.geneId) &&
               Objects.equals(variantId, that.variantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geneId, variantId);
    }
}
