package com.jurify.controller;

import com.jurify.entity.LegalCase;
import com.jurify.service.LegalCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/cases")
public class LegalCaseController {

    private final LegalCaseService service;

    public LegalCaseController(LegalCaseService service) {
        this.service = service;
    }

    @GetMapping
    public List<LegalCase> getAllCases() {
        return service.getAllCases();
    }

    @GetMapping("/{id}")
    public LegalCase getCaseById(@PathVariable Long id) {
        return service.getCaseById(id);
    }

    @PostMapping
    public LegalCase createCase(
            @RequestBody LegalCase legalCase) {

        return service.createCase(legalCase);
    }

    @PutMapping("/{id}/assign/{lawyerId}")
    public LegalCase assignLawyer(
            @PathVariable Long id,
            @PathVariable Long lawyerId) {

        return service.assignLawyer(id, lawyerId);
    }

    @PutMapping("/{id}/status")
    public LegalCase updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteCase(@PathVariable Long id) {
        service.deleteCase(id);
    }
}