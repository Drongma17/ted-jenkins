package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.LendMoney;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LendMoneyRepository extends JpaRepository<LendMoney, Integer> {
    List<LendMoney> getLendMoneyBySnowBankId(Long id);
}
