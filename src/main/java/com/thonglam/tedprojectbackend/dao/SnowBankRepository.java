package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.SnowBank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SnowBankRepository extends JpaRepository<SnowBank, Long> {
    List<SnowBank> getSnowBankBySbCategoryName(String sbCategoryName);
}
