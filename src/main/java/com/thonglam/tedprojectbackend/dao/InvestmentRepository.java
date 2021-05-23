package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    List<Investment> getInvestmentByInvestmentCategory(String investmentCategory);
}
