package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.dto.ReturnMoney;
import com.thonglam.tedprojectbackend.dto.SnowBank;

import java.util.List;
import java.util.Optional;

public interface ReturnMoneyService {


    List<ReturnMoney> getAllReturnMoney();
    ReturnMoney addReturnmoneyToSnowbank(Long snowbankId, ReturnMoney returnMoney);
    List<ReturnMoney> getReturnMoneyBySnowBankId(Long snowbankId);
     String deleteReturnMoney(Long snowbankId, Long returnmoneyId);
     ReturnMoney updateReturnMoney(Long snowbankId, Long returnmoneyId, ReturnMoney returnMoney);
    Double ReturnGrandTotal(Long id);
    Optional<SnowBank> getOneReturnMoney(Long returnMoney);
}
