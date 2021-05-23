package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Stefinance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StefinanceRepository extends JpaRepository<Stefinance, Long> {
    List<Stefinance> getStefinanceBySteId(Long id);
}
