package com.thonglam.tedprojectbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thonglam.tedprojectbackend.dao.BusinessacRepository;
import com.thonglam.tedprojectbackend.dao.BusinessacfinanceRepository;
import com.thonglam.tedprojectbackend.dto.Businessac;
import com.thonglam.tedprojectbackend.dto.Businessacfinance;
import com.thonglam.tedprojectbackend.exception.NotFoundException;
import com.thonglam.tedprojectbackend.service.BusinessacfinanceService;


@Service("businessacfinanceService")
public class BusinessacfinanceServiceImpl implements BusinessacfinanceService {

    @Autowired BusinessacfinanceRepository businessacfinanceRepository;
    @Autowired BusinessacRepository businessacRepository;


    @Override
    public List<Businessacfinance> getAllBusinessacfinance() {
        return businessacfinanceRepository.findAll();
    }



    @Override
    public Businessacfinance addFinanceToBusinessac(Long businessacId, Businessacfinance businessacfinance) {
        return businessacRepository.findById(businessacId)
                .map(businessac->{
                    businessacfinance.setBusinessac(businessac);
                    businessacfinance.setGrandTotal(largestGrandTotal(businessacId)+businessacfinance.getDisburseAmount());
                    businessac.setTotalDisbursed(largestGrandTotal(businessacId)+ businessacfinance.getDisburseAmount());
                    businessacRepository.save(businessac);
                    return businessacfinanceRepository.save(businessacfinance);
                }).orElseThrow(()->new NotFoundException("Businessac is not found"));
    }




    @Override
    public List<Businessacfinance> getByBusinessacId(Long businessacId) {
        return businessacfinanceRepository.getBusinessfinanceByBusinessacId(businessacId);
    }


    @Override
    public String deleteBusinessacfinance(Long businessacId, Long businessacfinanceId) {
        if(!businessacRepository.existsById(businessacId)){
            throw new NotFoundException("Entrepreneur is not found");
        }
        return businessacfinanceRepository.findById(businessacId)
                .map(businessacfinance->{
                    businessacfinanceRepository.delete(businessacfinance);
                    return "one milestone is deleted successfully";
                }).orElseThrow(()->new NotFoundException("Milestone is not found"));
    }



    @Override
    public Businessacfinance updateBusinessacFinance(Long businessacId, Long businessacfinanceId, Businessacfinance businessacfinance) {
        if(!businessacRepository.existsById(businessacId)){
            throw new NotFoundException("Business Acceleration Id is not found");
        }
        return businessacfinanceRepository.findById(businessacfinanceId)
                .map(bafinance->{
                    bafinance.setPurpose(businessacfinance.getPurpose());
                    bafinance.setDisburseAmount(businessacfinance.getAllocatedAmount());
                    bafinance.setAllocatedAmount(businessacfinance.getAllocatedAmount());
                    return businessacfinanceRepository.save(bafinance);
                }).orElseThrow(()->new NotFoundException("Business Acceleration finance is not found"));
    }





    public Double largestGrandTotal(Long id){
        Businessac singleBusinessac = businessacRepository.getOne(id);
        Double disburseAmound=0.0;
        List<Businessacfinance> financial = businessacfinanceRepository.getBusinessfinanceByBusinessacId(singleBusinessac.getId());
        for(Businessacfinance finan: financial){
            disburseAmound =disburseAmound +finan.getDisburseAmount();
        }
        return disburseAmound;
    }
}
