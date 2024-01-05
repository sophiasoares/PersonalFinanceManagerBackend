package com.project.personalfinancemanager.controller;

import com.project.personalfinancemanager.model.Expense;
import com.project.personalfinancemanager.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    private final ExpenseService expenseService;
    private final Logger logger = LoggerFactory.getLogger(ExpenseController.class);

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable("id") Integer id) {
        Expense expense = expenseService.getExpenseById(id);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        logger.debug("Received a POST request to add an expense: {}", expense);

        try {
            Expense newExpense = expenseService.addExpense(expense);
            logger.info("Expense added successfully: {}", newExpense);
            return new ResponseEntity<>(newExpense, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error while adding an expense: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense) {
        Expense updateExpense = expenseService.updateExpense(expense);
        return new ResponseEntity<>(updateExpense, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable("id") Integer id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
