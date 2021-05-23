package com.thonglam.tedprojectbackend.service;


import com.thonglam.tedprojectbackend.dto.Finance;

import java.util.List;

public interface FinanceService {


    List<Finance> getAllFinance();
    Finance addFinanceToEntrepreneur(Long entrepreneurId, Finance finance);
    List<Finance> getByEntrepreneurId(Long entrepreneurId);
    public String deleteFinance(Long entrepreneurId, Long financeId);
    public Finance updateFinance(Long entrepreneurId, Long financeId, Finance finance);
    public Double GrandTotal(Long id);

}
