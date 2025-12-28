package com.example.demo.controller;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/api/symptom-logs")
@SecurityRequirement(name="bearerAuth")
@Tag(name = "Daily Symptom Logs")
public class DailySymptomLogController {

    private final DailySymptomLogService logService;

    public DailySymptomLogController(DailySymptomLogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public DailySymptomLog recordLog(@RequestBody DailySymptomLog log) {
        return logService.recordSymptomLog(log);
    }

    @PutMapping("/{id}")
    public DailySymptomLog updateLog(
            @PathVariable Long id,
            @RequestBody DailySymptomLog updated) {
        return logService.updateSymptomLog(id, updated);
    }

    @GetMapping("/patient/{patientId}")
    public List<DailySymptomLog> getLogsByPatient(@PathVariable Long patientId) {
        return logService.getLogsByPatient(patientId);
    }
}
