package com.example.gene.model;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "variant")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Variant {

    @Id
    @Column(name = "clinvar_id")  // primary key στη βάση
    private String clinvarId;

    @Column(name = "chrom")
    private String chrom;

    @Column(name = "position")
    private Long position;

    @Column(name = "variant_type")
    private String variantType;

    @Column(name = "clinical_significance")
    private String clinicalSignificance;

    @Column(name = "rs_id")
    private String rsId;

    @Column(name = "ncbi_accession")
    private String ncbiAccession;

    @Column(name = "ncbi_id")
    private String ncbiID;

    // --- Getters & Setters ---
    public String getClinvarId() {
        return clinvarId;
    }

    public void setClinvarId(String clinvarId) {
        this.clinvarId = clinvarId;
    }

    public String getChrom() {
        return chrom;
    }

    public void setChrom(String chrom) {
        this.chrom = chrom;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public String getVariantType() {
        return variantType;
    }

    public void setVariantType(String variantType) {
        this.variantType = variantType;
    }

    public String getClinicalSignificance() {
        return clinicalSignificance;
    }

    public void setClinicalSignificance(String clinicalSignificance) {
        this.clinicalSignificance = clinicalSignificance;
    }

    public String getRsId() {
        return rsId;
    }

    public void setRsId(String rsId) {
        this.rsId = rsId;
    }

    public String getNcbiAccession() {
        return ncbiAccession;
    }

    public void setNcbiAccession(String ncbiAccession) {
        this.ncbiAccession = ncbiAccession;
    }

    public String getNcbiID() {
        return ncbiID;
    }

    public void setNcbiID(String ncbiID) {
        this.ncbiID = ncbiID;
    }
}
