package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.ReturnMoney;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReturnMoneyRepository extends JpaRepository<ReturnMoney, Long> {
    List<ReturnMoney> getReturnMoneyBySnowBankId(Long id);
}
