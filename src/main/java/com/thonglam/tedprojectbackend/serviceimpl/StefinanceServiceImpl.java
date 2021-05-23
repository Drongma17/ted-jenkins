package com.thonglam.tedprojectbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thonglam.tedprojectbackend.dao.SteRepository;
import com.thonglam.tedprojectbackend.dao.StefinanceRepository;
import com.thonglam.tedprojectbackend.dto.Ste;
import com.thonglam.tedprojectbackend.dto.Stefinance;
import com.thonglam.tedprojectbackend.exception.NotFoundException;
import com.thonglam.tedprojectbackend.service.StefinanceService;

@Service("steId")
public class StefinanceServiceImpl implements StefinanceService {

    @Autowired SteRepository steRepository;
    @Autowired StefinanceRepository stefinanceRepository;


    @Override
    public List<Stefinance> getAllSteFinance() {
        return stefinanceRepository.findAll();
    }



    @Override
    public Stefinance addFinanceToSte(Long steId, Stefinance finance) {
        return steRepository.findById(steId)
                .map(ste -> {
                    finance.setSte(ste);
                    finance.setGrandTotal(largestGrandTotal(steId)+ finance.getDisburseAmount());
                    ste.setTotalDisbursed(largestGrandTotal(steId)+ finance.getDisburseAmount());
                    steRepository.save(ste);
                    return stefinanceRepository.save(finance);
                }).orElseThrow(()->new NotFoundException("STE is not found"));
    }




    @Override
    public String deleteStfinance(Long steId, Long steFinanceId) {
        if(!steRepository.existsById(steId)){
            throw new NotFoundException("ste Id is not found");
        }
        return stefinanceRepository.findById(steFinanceId)
                .map(stefinance->{
                    stefinanceRepository.delete(stefinance);
                    return "one milestone is deleted successfully";
                }).orElseThrow(()->new NotFoundException("milestone is not found"));
    }




    @Override
    public List<Stefinance> getBySteId(Long steId) {
        return stefinanceRepository.getStefinanceBySteId(steId);
    }



    @Override
    public Stefinance updateStefinance(Long steId, Long stefinanceId, Stefinance stefinance) {
        if(!stefinanceRepository.existsById(steId)){
            throw  new NotFoundException("Skill to Enterprice is not present");
        }
        return stefinanceRepository.findById(stefinanceId)
                .map(finance->{
                    finance.setPurpose(stefinance.getPurpose());
                    finance.setDisburseAmount(stefinance.getDisburseAmount());
                    finance.setDisburseDate(stefinance.getDisburseDate());
                    return stefinanceRepository.save(finance);
                }).orElseThrow(()->new NotFoundException("ste finance is not found"));
    }


    public Double largestGrandTotal(Long id){
        Ste singleEntrepreneur = steRepository.getOne(id);
        Double disburseAmound=0.0;
        List<Stefinance> financial = stefinanceRepository.getStefinanceBySteId(singleEntrepreneur.getId());
        for(Stefinance finan: financial){
            disburseAmound =disburseAmound +finan.getDisburseAmount();
        }
        return disburseAmound;
    }
}
