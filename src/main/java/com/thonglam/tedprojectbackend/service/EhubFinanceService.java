package com.thonglam.tedprojectbackend.service;

import java.util.List;

import com.thonglam.tedprojectbackend.dto.EhubFinance;

public interface EhubFinanceService {
    List<EhubFinance> getAllEhubFinance();
    EhubFinance addEhubFinanceToEhub(Long ehubId, EhubFinance ehubFinance);
    List<EhubFinance> getAllEhubFinanceByEhubId(Long ehubId);
    public String deleteEhubFinance(Long ehubId, Long ehubfinanceId);
    public EhubFinance updateEhubFinance(Long ehubId, Long ehubfinanceIf, EhubFinance ehubFinance);

}
