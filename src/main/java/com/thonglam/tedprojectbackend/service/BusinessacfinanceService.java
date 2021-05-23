package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.dto.Businessacfinance;

import java.util.List;

public interface BusinessacfinanceService {


    List<Businessacfinance> getAllBusinessacfinance();
    Businessacfinance addFinanceToBusinessac(Long businessacId, Businessacfinance businessacfinance);
    List<Businessacfinance> getByBusinessacId(Long businessacId);
    String deleteBusinessacfinance(Long businessacId, Long businessacfinanceId);
    Businessacfinance updateBusinessacFinance(Long businessacId, Long businessacfinanceId, Businessacfinance businessacfinance);

}
