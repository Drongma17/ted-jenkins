package com.thonglam.tedprojectbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thonglam.tedprojectbackend.dao.EntrepreneursDao;
import com.thonglam.tedprojectbackend.dao.FinanceRepository;
import com.thonglam.tedprojectbackend.dto.Entrepreneurs;
import com.thonglam.tedprojectbackend.dto.Finance;
import com.thonglam.tedprojectbackend.exception.NotFoundException;
import com.thonglam.tedprojectbackend.service.FinanceService;


@Service("financeService, entrepreneurService")
public class FinanceServiceImpl implements FinanceService {

    @Autowired private FinanceRepository financeRepository;
    @Autowired private EntrepreneursDao entrepreneurRepository;


    @Override
    public List<Finance> getAllFinance() {
        return financeRepository.findAll();
    }

    @Override
    public Finance addFinanceToEntrepreneur(Long entrepreneurId, Finance finance) {
        return entrepreneurRepository.findById(entrepreneurId)
                .map(entrepreneur -> {
                    finance.setEntrepreneur(entrepreneur);
                    finance.setGrandTotal(GrandTotal(entrepreneurId)+ finance.getDisburseAmount());
                    entrepreneur.setTotalDisbursed(GrandTotal(entrepreneurId)+ finance.getDisburseAmount());
                    entrepreneurRepository.save(entrepreneur);
                    return financeRepository.save(finance);
                }).orElseThrow(()->new NotFoundException("Entrepreneur is not found"));

    }



    @Override
    public Finance updateFinance(Long entrepreneurId, Long financeId, Finance financee) {
        if(!entrepreneurRepository.existsById(entrepreneurId)){
            throw new NotFoundException("Entrepreneur is not found");
        }
        return financeRepository.findById(financeId)
                .map(finance -> {
                    finance.setDisburseAmount(financee.getDisburseAmount());
                    finance.setPurpose(financee.getPurpose());
                    finance.setDisburseDate(financee.getDisburseDate());
                    return financeRepository.save(finance);
                }).orElseThrow(()->new NotFoundException("Milestone is not found"));
    }





    @Override
    public String deleteFinance(Long entrepreneurId, Long financeId) {
        if(!entrepreneurRepository.existsById(entrepreneurId)){
            throw new NotFoundException("Entrepreneur is not found");
        }
        return financeRepository.findById(financeId)
                .map(finance -> {
                    financeRepository.delete(finance);
                    return "one milestone is deleted successfully";
                }).orElseThrow(()->new NotFoundException("Milestone is not found"));
    }





    @Override
    public List<Finance> getByEntrepreneurId(Long entrepreneurId) {
        return financeRepository.getFinanceByEntrepreneurId(entrepreneurId);
    }





    @Override
    public Double GrandTotal(Long id){
        Entrepreneurs singleEntrepreneur = entrepreneurRepository.getOne(id);
        Double disburseAmound=0.0;
        List<Finance> financial = financeRepository.getFinanceByEntrepreneurId(singleEntrepreneur.getId());
        for(Finance finan: financial){
            disburseAmound =disburseAmound +finan.getDisburseAmount();
        }
        return disburseAmound;
    }
}
