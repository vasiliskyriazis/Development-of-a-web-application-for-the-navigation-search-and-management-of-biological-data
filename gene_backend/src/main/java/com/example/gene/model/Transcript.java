package com.example.gene.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "transcript")
public class Transcript {

    @Id
    @Column(name = "transcript_id")
    private String transcriptId;

    @Column(name = "transcript_name")
    private String transcriptName;

    @Column(name = "transcript_start")
    private Integer transcriptStart;

    @Column(name = "transcript_end")
    private Integer transcriptEnd;

    @Column(name = "transcript_type")
    private String transcriptType;

    @Column(name = "refseq")
    private String refseq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gene_id", nullable = false)
    @JsonBackReference
    private Gene gene;

    // --- Getters/Setters ---
    public String getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(String transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getTranscriptName() {
        return transcriptName;
    }

    public void setTranscriptName(String transcriptName) {
        this.transcriptName = transcriptName;
    }

    public Integer getTranscriptStart() {
        return transcriptStart;
    }

    public void setTranscriptStart(Integer transcriptStart) {
        this.transcriptStart = transcriptStart;
    }

    public Integer getTranscriptEnd() {
        return transcriptEnd;
    }

    public void setTranscriptEnd(Integer transcriptEnd) {
        this.transcriptEnd = transcriptEnd;
    }

    public String getTranscriptType() {
        return transcriptType;
    }

    public void setTranscriptType(String transcriptType) {
        this.transcriptType = transcriptType;
    }

    public String getRefseq() {
        return refseq;
    }

    public void setRefseq(String refseq) {
        this.refseq = refseq;
    }

    public Gene getGene() {
        return gene;
    }

    public void setGene(Gene gene) {
        this.gene = gene;
    }
}
