package com.thonglam.tedprojectbackend.serviceimpl;


import com.thonglam.tedprojectbackend.dao.BAAllocateRepository;
import com.thonglam.tedprojectbackend.dao.BusinessacRepository;
import com.thonglam.tedprojectbackend.dto.BAAllocate;
import com.thonglam.tedprojectbackend.dto.Businessac;
import com.thonglam.tedprojectbackend.exception.NotFoundException;
import com.thonglam.tedprojectbackend.service.BAAllocateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("baAllocateService")
public class BAAllocateServiceImpl implements BAAllocateService {

    @Autowired BusinessacRepository businessacRepository;
    @Autowired BAAllocateRepository baAllocateRepository;



    @Override
    public List<BAAllocate> getAllBAAllocates() {
        return baAllocateRepository.findAll();
    }



    @Override
    public BAAllocate addBAAllocateToBusinessac(Long businessacId, BAAllocate baAllocate) {
        return businessacRepository.findById(businessacId)
                .map(businessac->{
                    baAllocate.setBusinessac(businessac);
                    baAllocate.setAllocateSum(allocatedSum(businessacId) + baAllocate.getAllocateAmount());
                    businessac.setAllocatedAmount(allocatedSum(businessacId) + baAllocate.getAllocateAmount());
                    businessacRepository.save(businessac);
                    return baAllocateRepository.save(baAllocate);
                }).orElseThrow(()->new NotFoundException("Business Acceleration Allocation Id is not found"));
    }




    @Override
    public String deleteBAAllocate(Long businessacId, int bAAllocateId) {
        if(!businessacRepository.existsById(businessacId)){
            throw new NotFoundException("Business Acceleration is not found");
        }
        return baAllocateRepository.findById(bAAllocateId)
                .map(baAllocate ->{
                    baAllocateRepository.delete(baAllocate);
                    return "Allocation of Business Acceleration  is deleted";
                }).orElseThrow(()->new NotFoundException("businessac Allocation is not found"));
    }




    @Override
    public List<BAAllocate> getALLBAAllocateByBusinessacId(Long businessacId) {
        return baAllocateRepository.getBAAllocateByBusinessacId(businessacId);
    }




    @Override
    public BAAllocate updateBAAllocateOfBusinessac(Long businessacId, int bAAlocateId, BAAllocate baAllocate) {
        if(!businessacRepository.existsById(businessacId)){
            throw new NotFoundException("Business Acceleration is not found");
        }
        return baAllocateRepository.findById(bAAlocateId)
                .map(baallocation -> {
                    baallocation.setPurpose(baAllocate.getPurpose());
                    baallocation.setAllocateAmount(baAllocate.getAllocateAmount());
                    baallocation.setAllocateDate(baAllocate.getAllocateDate());
                    baallocation.setDescription(baAllocate.getDescription());
                    return baAllocateRepository.save(baallocation);
                }).orElseThrow(()->new NotFoundException("baAllocation Id is not found"));
    }



    public Double allocatedSum(Long id){
        Businessac singleBusinessac = businessacRepository.getOne(id);
        Double allocatedsum=0.0;
        List<BAAllocate> baAllocates = baAllocateRepository.getBAAllocateByBusinessacId(singleBusinessac.getId());
        for(BAAllocate baAllocate: baAllocates){
            allocatedsum =allocatedsum +baAllocate.getAllocateAmount();
        }
        return allocatedsum;
    }
}
