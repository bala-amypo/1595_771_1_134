package com.example.demo.controller;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class DailySymptomLogController {

    private final DailySymptomLogService dailySymptomLogService;

    public DailySymptomLogController(DailySymptomLogService dailySymptomLogService) {
        this.dailySymptomLogService = dailySymptomLogService;
    }

    @PostMapping
    public ResponseEntity<DailySymptomLog> createLog(@RequestBody DailySymptomLog log) {
        DailySymptomLog saved = dailySymptomLogService.recordSymptomLog(log);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DailySymptomLog> updateLog(@PathVariable Long id,
                                                      @RequestBody DailySymptomLog log) {
        DailySymptomLog updated = dailySymptomLogService.updateSymptomLog(id, log);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<DailySymptomLog>> getLogsByPatient(@PathVariable Long patientId) {
        List<DailySymptomLog> logs = dailySymptomLogService.getLogsByPatient(patientId);
        return ResponseEntity.ok(logs);
    }
}
