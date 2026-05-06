package com.example.gene.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "gene")
@NamedEntityGraph(
    name = "Gene.withAll",
    attributeNodes = {
        @NamedAttributeNode("transcripts"),
        @NamedAttributeNode(value = "geneVariants", subgraph = "gv.variant")
    },
    subgraphs = {
        @NamedSubgraph(name = "gv.variant", attributeNodes = @NamedAttributeNode("variant"))
    }
)
public class Gene {

    @Id
    @Column(name = "gene_id")
    private String geneId;

    private String geneName;
    private String description;
    private String geneType;
    private Float gcContent;
    private String chrom;
    private Integer geneStart;
    private Integer geneEnd;
    private Integer transcriptCount;
    private String geneSynonym;

    // 1×N: Gene -> Transcripts
    @OneToMany(mappedBy = "gene", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Transcript> transcripts = new HashSet<>();

    // M×N μέσω join entity
    @OneToMany(mappedBy = "gene", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<GeneVariant> geneVariants = new HashSet<>();

    // Flat λίστα από Variant
    @Transient
    @JsonProperty("variants")
    public Set<Variant> getVariants() {
        return geneVariants == null ? Set.of() :
                geneVariants.stream()
                        .map(GeneVariant::getVariant)
                        .filter(v -> v != null)
                        .collect(Collectors.toSet());
    }

    // --- Getters/Setters ---

    public String getGeneId() {
        return geneId;
    }

    public void setGeneId(String geneId) {
        this.geneId = geneId;
    }

    public String getGeneName() {
        return geneName;
    }

    public void setGeneName(String geneName) {
        this.geneName = geneName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGeneType() {
        return geneType;
    }

    public void setGeneType(String geneType) {
        this.geneType = geneType;
    }

    public Float getGcContent() {
        return gcContent;
    }

    public void setGcContent(Float gcContent) {
        this.gcContent = gcContent;
    }

    public String getChrom() {
        return chrom;
    }

    public void setChrom(String chrom) {
        this.chrom = chrom;
    }

    public Integer getGeneStart() {
        return geneStart;
    }

    public void setGeneStart(Integer geneStart) {
        this.geneStart = geneStart;
    }

    public Integer getGeneEnd() {
        return geneEnd;
    }

    public void setGeneEnd(Integer geneEnd) {
        this.geneEnd = geneEnd;
    }

    public Integer getTranscriptCount() {
        return transcriptCount;
    }

    public void setTranscriptCount(Integer transcriptCount) {
        this.transcriptCount = transcriptCount;
    }

    public String getGeneSynonym() {
        return geneSynonym;
    }

    public void setGeneSynonym(String geneSynonym) {
        this.geneSynonym = geneSynonym;
    }

    public Set<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(Set<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

    public Set<GeneVariant> getGeneVariants() {
        return geneVariants;
    }

    public void setGeneVariants(Set<GeneVariant> geneVariants) {
        this.geneVariants = geneVariants;
    }
}
