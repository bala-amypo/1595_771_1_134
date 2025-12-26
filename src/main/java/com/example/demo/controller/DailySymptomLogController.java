package com.example.demo.controller;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.repository.DailySymptomLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/symptoms")
@RequiredArgsConstructor
public class DailySymptomLogController {

    private final DailySymptomLogRepository repository;

    @GetMapping
    public ResponseEntity<List<DailySymptomLog>> getAllLogs() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<DailySymptomLog> addLog(@RequestBody DailySymptomLog log) {
        return ResponseEntity.ok(repository.save(log));
    }
}
