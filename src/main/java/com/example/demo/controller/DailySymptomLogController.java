package com.example.demo.controller;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/symptom-logs")
public class DailySymptomLogController {

    private final DailySymptomLogService dailySymptomLogService;

    public DailySymptomLogController(DailySymptomLogService dailySymptomLogService) {
        this.dailySymptomLogService = dailySymptomLogService;
    }

    @PostMapping
    public ResponseEntity<DailySymptomLog> recordLog(
            @RequestBody DailySymptomLog log) {

        return ResponseEntity.ok(
                dailySymptomLogService.recordSymptomLog(log)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<DailySymptomLog> updateLog(
            @PathVariable Long id,
            @RequestBody DailySymptomLog updatedLog) {

        return ResponseEntity.ok(
                dailySymptomLogService.updateSymptomLog(id, updatedLog)
        );
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<DailySymptomLog>> getLogsByPatient(
            @PathVariable Long patientId) {

        return ResponseEntity.ok(
                dailySymptomLogService.getLogsByPatient(patientId)
        );
    }
}
