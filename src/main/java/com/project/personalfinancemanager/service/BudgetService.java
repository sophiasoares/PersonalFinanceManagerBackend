package com.project.personalfinancemanager.service;

import com.project.personalfinancemanager.exception.EntityNotFoundException;
import com.project.personalfinancemanager.model.Budget;
import com.project.personalfinancemanager.repository.BudgetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BudgetService {

    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Budget addBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public List<Budget> findAllBudgets() {
        return budgetRepository.findAll();
    }

    public Budget findBudgetById(Integer id) {
        return budgetRepository.findBudgetById(id)
                .orElseThrow(() -> new EntityNotFoundException("Budget by id " + id + " was not found"));
    }

    public Budget updateBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public void deleteBudget(Integer id) {
        budgetRepository.deleteById(id);
    }
}
