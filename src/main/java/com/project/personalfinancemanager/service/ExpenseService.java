package com.project.personalfinancemanager.service;

import com.project.personalfinancemanager.exception.EntityNotFoundException;
import com.project.personalfinancemanager.model.Expense;
import com.project.personalfinancemanager.repository.ExpenseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> findAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense findExpenseById(Integer id) {
        return expenseRepository.findExpenseById(id)
                .orElseThrow(() -> new EntityNotFoundException("Expense by id " + id + " was not found"));
    }

    public Expense updateExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Integer id) {
        expenseRepository.deleteById(id);
    }
}
