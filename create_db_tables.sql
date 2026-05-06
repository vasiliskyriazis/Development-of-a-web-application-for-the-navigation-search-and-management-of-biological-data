CREATE DATABASE IF NOT EXISTS vvdb;
use vvdb;

CREATE TABLE IF NOT EXISTS gene (
gene_id VARCHAR(50) PRIMARY KEY, 
gene_name VARCHAR(255),
description TEXT,
gene_type VARCHAR(100), 
gc_content FLOAT,
chrom VARCHAR(50), 
gene_start INT,
gene_end INT,
transcript_count INT,
gene_synonym VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS variant ( 
clinvar_id INT PRIMARY KEY,
chrom VARCHAR(50),
position INT,
clinical_significance VARCHAR(255), 
rsId VARCHAR(50),
ncbiAccession VARCHAR(255), 
ncbiID VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS gene_variant (
gene_id VARCHAR(50) NOT NULL,
variant_id INT NOT NULL,
PRIMARY KEY (gene_id, variant_id),
FOREIGN KEY (gene_id) REFERENCES gene(gene_id), 
FOREIGN KEY (variant_id) REFERENCES variant(clinvar_id)
);


CREATE TABLE IF NOT EXISTS transcript ( 
transcript_id VARCHAR(50) PRIMARY KEY, 
transcript_name VARCHAR(255), 
transcript_start INT,
transcript_end INT,
transcript_type VARCHAR(100),
refseq VARCHAR(255),
gene_id VARCHAR(50) NOT NULL,
FOREIGN KEY (gene_id) REFERENCES gene(gene_id)
);


