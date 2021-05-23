package com.thonglam.tedprojectbackend.serviceimpl;

import com.thonglam.tedprojectbackend.dao.InvestmentFinanceRepository;
import com.thonglam.tedprojectbackend.dao.InvestmentRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Investment;
import com.thonglam.tedprojectbackend.dto.InvestmentFinance;
import com.thonglam.tedprojectbackend.exception.NotFoundException;
import com.thonglam.tedprojectbackend.service.InvestmentFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("investmentFinanceService")
public class InvestmentFinanceServiceImpl implements InvestmentFinanceService {

    @Autowired  InvestmentFinanceRepository investmentFinanceRepository;
    @Autowired InvestmentRepository investmentRepository;

    @Override
    public List<InvestmentFinance> getAllInvestmentFinance() {
        return investmentFinanceRepository.findAll();
    }


    @Override
    public InvestmentFinance addFinanceToInvestment(Long investmentId, InvestmentFinance investmentFinance) {
        return investmentRepository.findById(investmentId)
                .map(invstFinance->{
                    investmentFinance.setInvestment(invstFinance);
                    investmentFinance.setGrandTotal(disbursedAmountOfInvestmentFinance(investmentId) +investmentFinance.getDisburseAmount());
                    invstFinance.setTotalDisbursed(disbursedAmountOfInvestmentFinance(investmentId) + investmentFinance.getDisburseAmount());
                    investmentRepository.save(invstFinance);
                    return investmentFinanceRepository.save(investmentFinance);
                }).orElseThrow(()->new NotFoundException("Entrepreneur is not found"));
    }






    @Override
    public List<InvestmentFinance> getByInvestmentId(Long investmentId) {
        return investmentFinanceRepository.getFinanceByInvestmentId(investmentId);
    }




    public Double disbursedAmountOfInvestmentFinance(Long id){
        Investment singleInvestment = investmentRepository.getOne(id);
        Double disburseAmound=0.0;
        List<InvestmentFinance> financial = investmentFinanceRepository.getFinanceByInvestmentId(singleInvestment.getId());
        for(InvestmentFinance finan: financial){
            disburseAmound =disburseAmound +finan.getDisburseAmount();
        }
        return disburseAmound;
    }



    @Override
    public InvestmentFinance updateInvestmentFinance(Long investmentId, Long investmentfinanceIf, InvestmentFinance investmentFinance) {
        if(!investmentRepository.existsById(investmentId)){
            throw new NotFoundException("Investment is not found");
        }
        return investmentFinanceRepository.findById(investmentfinanceIf)
                .map(investment -> {
                    investment.setDisburseAmount(investmentFinance.getDisburseAmount());
                    investment.setPurpose(investmentFinance.getPurpose());
                    investment.setDisburseDate(investmentFinance.getDisburseDate());
                    return investmentFinanceRepository.save(investment);
                }).orElseThrow(()->new NotFoundException("Milestone is not found"));
    }





    @Override
    public String deleteInvestmentFinance(Long investmentId, Long investmentfinanceId) {
        if(!investmentRepository.existsById(investmentId)){
            throw new NotFoundException("investment Id is not found");
        }
        return investmentFinanceRepository.findById(investmentfinanceId)
                .map(investmentfinance->{
                    investmentFinanceRepository.delete(investmentfinance);
                    return "one milestone is deleted successfully";
                }).orElseThrow(()->new NotFoundException("milestone is not found"));
    }



}
