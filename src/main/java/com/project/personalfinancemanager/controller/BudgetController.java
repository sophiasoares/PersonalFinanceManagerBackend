package com.project.personalfinancemanager.controller;

import com.project.personalfinancemanager.model.Budget;
import com.project.personalfinancemanager.service.BudgetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Budget>> getAllBudgets() {
        List<Budget> budgets = budgetService.getAllBudgets();
        return new ResponseEntity<>(budgets, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Budget> getBudgetById(@PathVariable("id") Integer id) {
        Budget budget = budgetService.getBudgetById(id);
        return new ResponseEntity<>(budget, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Budget> addBudget(@RequestBody Budget budget) {
        Budget newBudget = budgetService.addBudget(budget);
        return new ResponseEntity<>(newBudget, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Budget> updateBudget(@RequestBody Budget budget) {
        Budget updateBudget = budgetService.updateBudget(budget);
        return new ResponseEntity<>(updateBudget, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBudget(@PathVariable("id") Integer id) {
        budgetService.deleteBudget(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}