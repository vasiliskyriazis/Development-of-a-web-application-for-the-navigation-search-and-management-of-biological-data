INSERT INTO gene (gene_id, gene_name, description, gene_type, gc_content, chrom, gene_start, gene_end, transcript_count, gene_synonym)
VALUES
('ENSG00000285479', 'CACNA1C', 'calcium voltage-gated channel subunit alpha1 C [Source:HGNC Symbol Acc:HGNC:1390]', 'protein_coding', 47.12, '18', 312916, 1046066, 50, 'CACNA1C-IT2'),
('ENSG00000106733', 'NMRK1', 'nicotinamide riboside kinase 1 [Source:HGNC Symbol Acc:HGNC:26057]', 'protein_coding', 40.5, '9', 75060573, 75088217, 7, 'BA235O14.2'),
('ENSG00000090863', 'GLG1', 'golgi glycoprotein 1 [Source:HGNC Symbol Acc:HGNC:4316]', 'protein_coding', 42.38, '16', 74447427, 74607144, 14, 'CFR-1'),
('ENSG00000090857', 'PDPR', 'pyruvate dehydrogenase phosphatase regulatory subunit [Source:HGNC Symbol Acc:HGNC:30264]', 'protein_coding', 47.1, '16', 70114332, 70162537, 11, 'PDP3'),
('ENSG00000275331', 'ABCC6', 'ATP binding cassette subfamily C member 6 [Source:HGNC Symbol Acc:HGNC:57]', 'protein_coding', 49.86, '16', 1806848, 1881517, 8, 'EST349056'),
('ENSG00000006125', 'AP2B1', 'adaptor related protein complex 2 subunit beta 1 [Source:HGNC Symbol Acc:HGNC:563]', 'protein_coding', 39.93, '17', 35578046, 35726413, 22, 'CLAPB1'),
('ENSG00000288427', 'CLSTN3', 'calsyntenin 3 [Source:HGNC Symbol Acc:HGNC:18371]', 'protein_coding', 51.75, '13', 57384, 86631, 16, 'KIAA0726'),
('ENSG00000291428', 'BRSK2', 'BR serine/threonine kinase 2 [Source:HGNC Symbol Acc:HGNC:11405]', 'protein_coding', 63.85, '15', 124165, 196955, 15, 'SAD-A'),
('ENSG00000150712', 'MTMR12', 'myotubularin related protein 12 [Source:HGNC Symbol Acc:HGNC:18191]', 'protein_coding', 44.08, '5', 32226994, 32312987, 7, '3-PAP'),
('ENSG00000170579', 'DLGAP1', 'DLG associated protein 1 [Source:HGNC Symbol Acc:HGNC:2905]', 'protein_coding', 39.67, '18', 3496032, 4455307, 22, 'GKAP'),
('ENSG00000139618', 'BRCA2', 'BRCA2 DNA repair associated [Source:HGNC Symbol Acc:HGNC:1101]', 'protein_coding', 38.2, '13', 32315086, 32400268, 19, 'BRCC2, FACD, FAD, FAD1, FANCD, FANCD1, XRCC11'),
('ENSG00000176697', 'BDNF', 'brain derived neurotrophic factor [Source:HGNC Symbol Acc:HGNC:1033]', 'protein_coding', 40.05, '11', 27654893, 27722058, 17, 'None');

INSERT INTO variant (clinvar_id, chrom, position, clinical_significance, rsId, ncbiAccession, ncbiID)
VALUES
(1168940, '13', 32315300, 'benign', '36221751', '0003582', '1157132'),
(2174981, '13', 32315355, 'uncertain_significance', 'none', '1901121', '0003582'),
(3390224, '13', 32323395, 'uncertain_significance', 'none', 'C3661900', '3549347'),
(1166054, '13', 32315411, 'likely_benign', '563971900', 'C2675520', '1157133'), 
(3353313, '11', 27657817, 'likely_benign', 'none', 'NC_00011', '3512534'), 
(3353378, '11', 27657830, 'likely_benign', 'none', 'NC_00014', '3512599'), 
(3356097, '11', 27657844, 'likely_benign', 'none', 'NC_00078', '3515319'), 
(2630210, '11', 27657906, 'uncertain_significance', 'none', 'NC_00099', '2798151'), 
(433370, '16', 16150095, 'benign/likely_benign', '59461468', '0009925', '426778'), 
(433369, '16', 16150116, 'benign', '3902401', '0009935', '426779'),
(433368, '16', 16150144, 'likely_pathogenic', '63750874', '0009965', '426780');

INSERT INTO transcript (transcript_id, transcript_name, transcript_start, transcript_end, transcript_type, refseq, gene_id)
VALUES
('ENST00000380152.8', 'BRCA2-201', 32315508, 32400268, 'protein_coding', 'NM_000059.4', 'ENSG00000139618'),
('ENST00000530893.7', 'BRCA2-204', 32315505, 32400268, 'protein_coding', '-', 'ENSG00000139618'),
('ENST00000470094.2', 'BRCA2-202', 32315508, 32400265, 'Nonsense_mediated_decay', '-', 'ENSG00000139618'),
('ENST00000356660.9', 'BDNF-202', 27654893, 27700455, 'protein_coding', 'NM_001709.5', 'ENSG00000176697'), 
('ENST00000314915.6', 'BDNF-201', 27654893, 27722058, 'protein_coding', '-', 'ENSG00000176697'),
('ENST00000525950.5', 'BDNF-211', 27654893, 27720779, 'protein_coding', '-', 'ENSG00000176697'),
('ENST00000347598.9', 'CACNA1C-220', 2052987, 2697950, 'protein_coding', '-', 'ENSG00000285479'),
('ENST00000399655.6', 'CACNA1C-220', 2052987, 2697950, 'protein_coding', 'NM_000719.7', 'ENSG00000285479'),
('ENST00000399603.6', 'CACNA1C-209', 2052987, 2697950, 'protein_coding', '-', 'ENSG00000285479'),
('ENST00000406454.8', 'CACNA1C-222', 2052987, 2692159, 'protein_coding', '-', 'ENSG00000285479');

INSERT INTO gene_variant (gene_id, variant_id) VALUES
('ENSG00000139618', 1168940), 
('ENSG00000139618', 2174981), 
('ENSG00000139618', 3390224), 
('ENSG00000139618', 1166054), 
('ENSG00000176697', 3353378), 
('ENSG00000176697', 3353313), 
('ENSG00000176697', 3356097), 
('ENSG00000176697', 2630210), 
('ENSG00000275331', 433370), 
('ENSG00000275331', 433369), 
('ENSG00000275331', 433368);





