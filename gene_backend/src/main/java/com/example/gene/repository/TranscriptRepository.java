package com.example.gene.repository;

import com.example.gene.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscriptRepository extends JpaRepository<Transcript, String> {
}
