package com.example.demo.controller;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;

@RestController
@RequestMapping("/api/recovery-curves")
@SecurityRequiremnet(name="bearerAuth")
@Tag(name = "Recovery Curves")
public class RecoveryCurveController {

    private final RecoveryCurveService curveService;

    public RecoveryCurveController(RecoveryCurveService curveService) {
        this.curveService = curveService;
    }

    @PostMapping
    public RecoveryCurveProfile createCurve(@RequestBody RecoveryCurveProfile curve) {
        return curveService.createCurveEntry(curve);
    }

    @GetMapping("/surgery/{surgeryType}")
    public List<RecoveryCurveProfile> getCurve(@PathVariable String surgeryType) {
        return curveService.getCurveForSurgery(surgeryType);
    }

    @GetMapping
    public List<RecoveryCurveProfile> getAllCurves() {
        return curveService.getAllCurves();
    }
}
