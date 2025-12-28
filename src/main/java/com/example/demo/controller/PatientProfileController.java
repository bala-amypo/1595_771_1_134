package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@SecurityRequiremnet(name="bearerAuth")
@Tag(name = "Patient Profiles")
public class PatientProfileController {

    private final PatientProfileService patientService;

    public PatientProfileController(PatientProfileService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public PatientProfile createPatient(@RequestBody PatientProfile profile) {
        return patientService.createPatient(profile);
    }

    @GetMapping("/{id}")
    public PatientProfile getPatient(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping
    public List<PatientProfile> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PutMapping("/{id}/status")
    public PatientProfile updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return patientService.updatePatientStatus(id, active);
    }

    @GetMapping("/lookup/{patientId}")
    public PatientProfile findByPatientId(@PathVariable String patientId) {
            return patientService.findByPatientId(patientId)
            .orElseThrow(() ->
                    new com.example.demo.exception.ResourceNotFoundException(
                            "Patient not found"));
}

}
