package com.thonglam.tedprojectbackend.serviceimpl;

import com.thonglam.tedprojectbackend.dao.InvestmentAllocateRepository;
import com.thonglam.tedprojectbackend.dao.InvestmentRepository;
import com.thonglam.tedprojectbackend.dto.Investment;
import com.thonglam.tedprojectbackend.dto.InvestmentAllocate;
import com.thonglam.tedprojectbackend.exception.NotFoundException;
import com.thonglam.tedprojectbackend.service.InvestmentAllocateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("investmentAllocateService")
public class InvestmentAllocateServiceImpl implements InvestmentAllocateService {


    @Autowired
    InvestmentRepository investmentRepository;
    @Autowired
    InvestmentAllocateRepository investmentAllocateRepository;



    @Override
    public List<InvestmentAllocate> getAllInvestmentAllocate() {
        return investmentAllocateRepository.findAll();
    }





    @Override
    public InvestmentAllocate addAllotToInvest(Long investmentId, InvestmentAllocate investmentAllocate) {
        return investmentRepository.findById(investmentId)
                .map(investment->{
                    investmentAllocate.setInvestment(investment);
                    investmentAllocate.setAllocatedSum(allocatedSum(investmentId) + investmentAllocate.getAllocatedAmount());
                    investment.setAllocatedAmount(allocatedSum(investmentId) + investmentAllocate.getAllocatedAmount());
                    investmentRepository.save(investment);
                    return investmentAllocateRepository.save(investmentAllocate);
                }).orElseThrow(()->new NotFoundException("Investment Id is not available"));
    }





    @Override
    public List<InvestmentAllocate> getAllByInvestmentId(Long investmentId) {
        if(!investmentRepository.existsById(investmentId)){
            throw new NotFoundException("Investment is not available");
        }
        return investmentAllocateRepository.getInvestmentAllocateByInvestmentId(investmentId);
    }




    @Override
    public String deleteInvestmentAllot(Long investmentId, int investmentallocateId) {
        if(!investmentRepository.existsById(investmentId)){
            throw new NotFoundException("Investment is not available");
        }
        return investmentAllocateRepository.findById(investmentallocateId)
                .map(investment->{
                    investmentAllocateRepository.delete(investment);
                    return "one investment allocated ";
                }).orElseThrow(()->new NotFoundException("Investment allocated Id is not found"));
    }




    @Override
    public InvestmentAllocate updateInvestmentAllot(Long investmentId, int investmentAllocateId, InvestmentAllocate investmentAllocate) {
        if(!investmentRepository.existsById(investmentId)){
            throw new NotFoundException("Investment is not available");
        }
        return investmentAllocateRepository.findById(investmentAllocateId)
                .map(investmentallocate->{
                    investmentallocate.setPurpose(investmentAllocate.getPurpose());
                    investmentallocate.setAllocatedAmount(investmentAllocate.getAllocatedAmount());
                    investmentallocate.setDescription(investmentAllocate.getDescription());
                    investmentallocate.setAllocateDate(investmentAllocate.getAllocateDate());
                    return investmentAllocateRepository.save(investmentallocate);
                }).orElseThrow(()->new NotFoundException("Investment Id is not found"));
    }



    public Double allocatedSum(Long id){
        Investment singleInvestment = investmentRepository.getOne(id);
        Double allocatedsum=0.0;
        List<InvestmentAllocate> investmentallocates = investmentAllocateRepository.getInvestmentAllocateByInvestmentId(singleInvestment.getId());
        for(InvestmentAllocate investmentallocate: investmentallocates){
            allocatedsum =allocatedsum +investmentallocate.getAllocatedAmount();
        }
        return allocatedsum;
    }
}
