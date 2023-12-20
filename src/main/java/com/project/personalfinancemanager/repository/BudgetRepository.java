package com.project.personalfinancemanager.repository;

import com.project.personalfinancemanager.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Integer> {
    Optional<Budget> findBudgetById(Integer id);
}
