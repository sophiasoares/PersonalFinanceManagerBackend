package com.project.personalfinancemanager.repository;

import com.project.personalfinancemanager.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    Optional<Expense> findExpenseById(Integer id);
}
