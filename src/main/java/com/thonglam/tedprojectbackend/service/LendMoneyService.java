package com.thonglam.tedprojectbackend.service;

import java.util.List;

import com.thonglam.tedprojectbackend.dto.LendMoney;

public interface LendMoneyService {

    List<LendMoney> getAllLendMoney();
    LendMoney addLendMoney(Long customerId, LendMoney lendMoney);
    List<LendMoney> getLendMoneyBySnowBankId(Long customerId);
    String deleteLendMoney(Long customerId, int lendmoneyId);
    LendMoney updateLendMoney(Long customerId, int lendmoneyId, LendMoney lendMoney);
}
