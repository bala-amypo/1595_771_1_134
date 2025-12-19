package com.example.demo.controller;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recovery-curves")
public class RecoveryCurveProfileController {

    private final RecoveryCurveProfileService service;

    public RecoveryCurveProfileController(RecoveryCurveProfileService service) {
        this.service = service;
    }

    @GetMapping("/{surgeryType}")
    public List<RecoveryCurveProfile> getBySurgeryType(@PathVariable String surgeryType) {
        return service.getRecoveryCurveBySurgeryType(surgeryType);
    }
}
