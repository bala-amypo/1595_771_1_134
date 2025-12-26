package com.example.demo.repository;

import com.example.demo.model.ClinicalAlertRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalAlertRepository
        extends JpaRepository<ClinicalAlertRecord, Long> {
}
