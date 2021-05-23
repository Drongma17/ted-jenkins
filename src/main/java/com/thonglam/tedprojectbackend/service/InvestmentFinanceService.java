package com.thonglam.tedprojectbackend.service;


import com.thonglam.tedprojectbackend.dto.InvestmentFinance;

import java.util.List;

public interface InvestmentFinanceService {

    List<InvestmentFinance> getAllInvestmentFinance();
    InvestmentFinance addFinanceToInvestment(Long investmentId, InvestmentFinance finance);
    public String deleteInvestmentFinance(Long investmentId, Long investmentfinanceId);
    public List<InvestmentFinance> getByInvestmentId(Long investmentId);
    public InvestmentFinance updateInvestmentFinance(Long investmentId, Long investmentfinanceIf, InvestmentFinance investmentFinance);
}
