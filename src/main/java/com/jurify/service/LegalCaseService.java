package com.jurify.service;

import com.jurify.entity.LegalCase;
import com.jurify.repository.LegalCaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegalCaseService {

    private final LegalCaseRepository repository;

    public LegalCaseService(LegalCaseRepository repository) {
        this.repository = repository;
    }

    public List<LegalCase> getAllCases() {
        return repository.findAll();
    }

    public LegalCase getCaseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Case not found"));
    }

    public LegalCase createCase(LegalCase legalCase) {
        return repository.save(legalCase);
    }

    public LegalCase assignLawyer(Long caseId, Long lawyerId) {

        LegalCase legalCase = repository.findById(caseId)
                .orElseThrow(() ->
                        new RuntimeException("Case not found"));

        legalCase.setLawyerId(lawyerId);

        return repository.save(legalCase);
    }

    public LegalCase updateStatus(Long id, String status) {

        LegalCase legalCase = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Case not found"));

        legalCase.setStatus(status);

        return repository.save(legalCase);
    }

    public void deleteCase(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Case not found");
        }

        repository.deleteById(id);
    }
}