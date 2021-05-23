package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinanceRepository extends JpaRepository<Finance, Long> {
    List<Finance> getFinanceByEntrepreneurId(Long id);
}
