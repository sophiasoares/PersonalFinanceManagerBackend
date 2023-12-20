package com.project.personalfinancemanager.repository;

import com.project.personalfinancemanager.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IncomeRepository extends JpaRepository<Income, Integer> {
    Optional<Income> findIncomeById(Integer id);
}
