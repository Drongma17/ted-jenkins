package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.dto.Stefinance;

import java.util.List;

public interface StefinanceService {

    List<Stefinance> getAllSteFinance();
    Stefinance addFinanceToSte(Long steId, Stefinance finance);
    public String deleteStfinance(Long steId, Long steFinanceId);
    public List<Stefinance> getBySteId(Long steId);
    Stefinance updateStefinance(Long steId, Long stefinanceId, Stefinance stefinance);
}
