package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Businessacfinance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessacfinanceRepository extends JpaRepository<Businessacfinance, Long> {
    List<Businessacfinance> getBusinessfinanceByBusinessacId(Long id);
}
