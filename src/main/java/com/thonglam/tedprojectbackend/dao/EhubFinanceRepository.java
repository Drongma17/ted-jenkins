package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.EhubFinance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EhubFinanceRepository extends JpaRepository<EhubFinance, Long> {
    List<EhubFinance> getEhubFinanceByEhubId(Long id);
}
