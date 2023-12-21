package com.project.personalfinancemanager.controller;


import com.project.personalfinancemanager.model.Income;
import com.project.personalfinancemanager.service.IncomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/income")
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Income>> getAllIncomes() {
        List<Income> incomes = incomeService.getAllIncomes();
        return new ResponseEntity<>(incomes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable("id") Integer id) {
        Income income = incomeService.getIncomeById(id);
        return new ResponseEntity<>(income, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Income> addIncome(@RequestBody Income income) {
        Income newIncome = incomeService.addIncome(income);
        return new ResponseEntity<>(newIncome, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Income> updateIncome(@RequestBody Income income) {
        Income updateIncome = incomeService.updateIncome(income);
        return new ResponseEntity<>(updateIncome, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteIncome(@PathVariable("id") Integer id) {
        incomeService.deleteIncome(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
