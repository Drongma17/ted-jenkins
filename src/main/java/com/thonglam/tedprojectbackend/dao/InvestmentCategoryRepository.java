package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.InvestmentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentCategoryRepository extends JpaRepository<InvestmentCategory, Integer> {
}
