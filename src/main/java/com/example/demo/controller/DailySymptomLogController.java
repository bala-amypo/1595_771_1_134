package com.example.demo.controller;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/symptoms")
public class DailySymptomLogController {

    private final DailySymptomLogService service;

    public DailySymptomLogController(DailySymptomLogService service) {
        this.service = service;
    }

    @PostMapping
    public DailySymptomLog logSymptoms(@RequestBody DailySymptomLog log) {
        return service.logDailySymptoms(log);
    }

    @GetMapping("/patient/{patientId}")
    public List<DailySymptomLog> getLogs(@PathVariable Long patientId) {
        return service.getLogsForPatient(patientId);
    }
}
