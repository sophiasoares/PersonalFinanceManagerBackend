package com.project.personalfinancemanager.service;

import com.project.personalfinancemanager.exception.EntityNotFoundException;
import com.project.personalfinancemanager.model.Income;
import com.project.personalfinancemanager.repository.IncomeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class IncomeService {

    private final IncomeRepository incomeRepository;

    @Autowired
    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public Income addIncome(Income income) {
        return incomeRepository.save(income);
    }

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    public Income updateIncome(Income income) {
        return incomeRepository.save(income);
    }

    public Income getIncomeById(Integer id) {
        return incomeRepository.findIncomeById(id)
                .orElseThrow(() -> new EntityNotFoundException("Income by id " + id + " was not found"));
    }

    public void deleteIncome(Integer id) {
        incomeRepository.deleteById(id);
    }
}
