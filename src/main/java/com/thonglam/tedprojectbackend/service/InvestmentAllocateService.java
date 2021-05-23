package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.dto.InvestmentAllocate;

import java.util.List;

public interface InvestmentAllocateService {

    List<InvestmentAllocate> getAllInvestmentAllocate();
    InvestmentAllocate addAllotToInvest(Long investmentId, InvestmentAllocate investmentAllocate);
    List<InvestmentAllocate> getAllByInvestmentId(Long investmentId);
    public String deleteInvestmentAllot(Long investmentId, int investmentallocateId);
    public InvestmentAllocate updateInvestmentAllot(Long investmentId, int investmentAllocateId, InvestmentAllocate investmentAllocate);


}
