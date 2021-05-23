package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.InvestmentAllocate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentAllocateRepository extends JpaRepository<InvestmentAllocate, Integer> {
    List<InvestmentAllocate> getInvestmentAllocateByInvestmentId(Long id);
}
