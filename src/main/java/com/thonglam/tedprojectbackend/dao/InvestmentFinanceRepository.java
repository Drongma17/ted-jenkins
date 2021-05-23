package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.InvestmentFinance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentFinanceRepository extends JpaRepository<InvestmentFinance, Long> {
    List<InvestmentFinance>  getFinanceByInvestmentId(Long id);
}
