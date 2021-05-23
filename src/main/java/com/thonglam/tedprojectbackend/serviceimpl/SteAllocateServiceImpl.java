package com.thonglam.tedprojectbackend.serviceimpl;

import com.thonglam.tedprojectbackend.dao.SteAllocateRepository;
import com.thonglam.tedprojectbackend.dao.SteRepository;
import com.thonglam.tedprojectbackend.dto.Ste;
import com.thonglam.tedprojectbackend.dto.SteAllocate;
import com.thonglam.tedprojectbackend.exception.NotFoundException;
import com.thonglam.tedprojectbackend.service.SteAllocateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("steAllocateService")
public class SteAllocateServiceImpl implements SteAllocateService {

    @Autowired SteRepository steRepository;
    @Autowired SteAllocateRepository steAllocateRepository;


    @Override
    public List<SteAllocate> getAllSteAllocates() {
        return steAllocateRepository.findAll();
    }



    @Override
    public SteAllocate addSteAllocate(Long steId, SteAllocate steAllocate) {
        return steRepository.findById(steId)
                .map(ste->{
                    steAllocate.setSte(ste);
                    steAllocate.setAllocatedSum(allocatedSum(steId) + steAllocate.getAllocatedAmount());
                    ste.setAllocatedAmount(allocatedSum(steId) + steAllocate.getAllocatedAmount());
                    steRepository.save(ste);
                    return steAllocateRepository.save(steAllocate);
                }).orElseThrow(()->new NotFoundException("STE is not found"));
    }



    @Override
    public List<SteAllocate> getSteAllocatesBySteId(Long steId) {
        return steAllocateRepository.getSteAllocateBySteId(steId);
    }



    @Override
    public String deleteSteAllocate(Long steId, int steallocateId) {
        if(!steRepository.existsById(steId)){
            throw new NotFoundException("ste is not found");
        }
        return steAllocateRepository.findById(steallocateId)
                .map(steallocate ->{
                    steAllocateRepository.delete(steallocate);
                    return "One allocated is deleted";
                }).orElseThrow(()->new NotFoundException("ste allocate id is not found"));
    }




    @Override
    public SteAllocate updateSteAllocate(Long steId, int steallocateId, SteAllocate steAllocate) {
        if(!steRepository.existsById(steId)){
            throw new NotFoundException("ste is not found");
        }
        return steAllocateRepository.findById(steallocateId)
                .map(allocate ->{
                    allocate.setPurpose(steAllocate.getPurpose());
                    allocate.setAllocatedAmount(steAllocate.getAllocatedAmount());
                    allocate.setAllocatedDate(steAllocate.getAllocatedDate());
                    allocate.setDescription(steAllocate.getDescription());
                    return steAllocateRepository.save(allocate);
                }).orElseThrow(()->new NotFoundException("ste allocate id is not found"));
    }



    public Double allocatedSum(Long id){
        Ste singleSte = steRepository.getOne(id);
        Double allocatedsum=0.0;
        List<SteAllocate> steallocates = steAllocateRepository.getSteAllocateBySteId(singleSte.getId());
        for(SteAllocate steallocate: steallocates){
            allocatedsum =allocatedsum +steallocate.getAllocatedAmount();
        }
        return allocatedsum;
    }

}
