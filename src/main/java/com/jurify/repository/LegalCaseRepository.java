package com.jurify.repository;

import com.jurify.entity.LegalCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LegalCaseRepository extends JpaRepository<LegalCase, Long> {

    List<LegalCase> findByLawyerId(Long lawyerId);
}