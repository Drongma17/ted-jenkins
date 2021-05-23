package com.thonglam.tedprojectbackend.serviceimpl;

import com.thonglam.tedprojectbackend.dao.EhubFinanceRepository;
import com.thonglam.tedprojectbackend.dao.EhubRepository;
import com.thonglam.tedprojectbackend.dto.Ehub;
import com.thonglam.tedprojectbackend.dto.EhubFinance;
import com.thonglam.tedprojectbackend.exception.NotFoundException;
import com.thonglam.tedprojectbackend.service.EhubFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ehubFinanceService")
public class EhubFinanceServiceImpl implements EhubFinanceService {

    @Autowired
    private EhubFinanceRepository ehubFinanceRepository;
    @Autowired
    EhubRepository ehubRepository;


    @Override
    public List<EhubFinance> getAllEhubFinance() {
        return ehubFinanceRepository.findAll();
    }


    @Override
    public EhubFinance addEhubFinanceToEhub(Long ehubId, EhubFinance ehubFinance) {
        return ehubRepository.findById(ehubId)
                .map(ehub -> {
                    ehubFinance.setEhub(ehub);
                    ehubFinance.setGrandTotal(largestGrandTotal(ehubId)+ ehubFinance.getDisburseAmount());
                    ehub.setTotalDisbursed(largestGrandTotal(ehubId)+ ehubFinance.getDisburseAmount());
                    ehubRepository.save(ehub);
                    return ehubFinanceRepository.save(ehubFinance);
                }).orElseThrow(()->new NotFoundException("Ehub is not found"));
    }


    @Override
    public List<EhubFinance> getAllEhubFinanceByEhubId(Long ehubId) {
        return ehubFinanceRepository.getEhubFinanceByEhubId(ehubId);
    }


    @Override
    public String deleteEhubFinance(Long ehubId, Long ehubfinanceId) {
        if(!ehubRepository.existsById(ehubId)){
            throw new NotFoundException("Ehub is not found");
        }
        return ehubFinanceRepository.findById(ehubfinanceId)
                .map(efinance -> {
                    ehubFinanceRepository.delete(efinance);
                    return "one milestone is deleted successfully";
                }).orElseThrow(()->new NotFoundException("Milestone is not found"));
    }



    @Override
    public EhubFinance updateEhubFinance(Long ehubId, Long ehubfinanceIf, EhubFinance ehubFinance) {
        if(!ehubRepository.existsById(ehubId)){
            throw new NotFoundException("Ehub is not found");
        }
        return ehubFinanceRepository.findById(ehubfinanceIf)
                .map(efinance -> {
                    efinance.setDisburseAmount(ehubFinance.getDisburseAmount());
                    efinance.setPurpose(ehubFinance.getPurpose());
                    efinance.setDisburseDate(ehubFinance.getDisburseDate());
                    return ehubFinanceRepository.save(efinance);
                }).orElseThrow(()->new NotFoundException("Milestone is not found"));
    }



    public Double largestGrandTotal(Long id){
        Ehub singleEhub = ehubRepository.getOne(id);
        Double disburseAmound=0.0;
        List<EhubFinance> financial = ehubFinanceRepository.getEhubFinanceByEhubId(singleEhub.getId());
        for(EhubFinance finan: financial){
            disburseAmound =disburseAmound +finan.getDisburseAmount();
        }
        return disburseAmound;
    }


}
