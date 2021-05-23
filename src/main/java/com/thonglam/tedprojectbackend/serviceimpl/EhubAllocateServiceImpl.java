package com.thonglam.tedprojectbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thonglam.tedprojectbackend.dao.EhubAllocateRepository;
import com.thonglam.tedprojectbackend.dao.EhubRepository;
import com.thonglam.tedprojectbackend.dto.Ehub;
import com.thonglam.tedprojectbackend.dto.EhubAllocate;
import com.thonglam.tedprojectbackend.exception.NotFoundException;
import com.thonglam.tedprojectbackend.service.EhubAllocateService;

@Service("ehubAllocateService")
public class EhubAllocateServiceImpl implements EhubAllocateService {

    @Autowired
    EhubRepository ehubRepository;
    @Autowired
    EhubAllocateRepository ehubAllocateRepository;


    @Override
    public List<EhubAllocate> getAllEhubAllocates() {
        return ehubAllocateRepository.findAll();
    }



    @Override
    public EhubAllocate addEhubAllocate(Long ehubId, EhubAllocate ehubAllocate) {
        return ehubRepository.findById(ehubId)
                .map(ehub->{
                    ehubAllocate.setEhub(ehub);
                    ehubAllocate.setAllocateSum(allocatedSum(ehubId) +ehubAllocate.getAllocateAmount());
                    ehub.setAllocatedAmount(allocatedSum(ehubId) +ehubAllocate.getAllocateAmount());
                    ehubRepository.save(ehub);
                    return ehubAllocateRepository.save(ehubAllocate);
                }).orElseThrow(()->new NotFoundException("ehub id is not found"));
    }




    @Override
    public List<EhubAllocate> getEhubAllocatesByEhubId(Long ehubId) {
        if(!ehubRepository.existsById(ehubId)){
            throw new NotFoundException("Particular ehub is not available");
        }
        return ehubAllocateRepository.getEhubAllocateByEhubId(ehubId);
    }




    @Override
    public String deleteEhubAllocate(Long ehubId, int ehuballocateId) {
        if(!ehubRepository.existsById(ehubId)){
            throw new NotFoundException("Particular ehub is not available");
        }
        return ehubAllocateRepository.findById(ehuballocateId)
                .map(ehub->{
                    ehubAllocateRepository.delete(ehub);
                    return "One Allocated Amount is deleted from Ehub";
                }).orElseThrow(()->new NotFoundException("ehub id is not found"));

    }




    @Override
    public EhubAllocate updateEhubAllocate(Long ehubId, int ehuballocateId, EhubAllocate ehubAllocate) {
        if(!ehubRepository.existsById(ehubId)){
            throw new NotFoundException("Particular ehub is not found");
        }
        return ehubAllocateRepository.findById(ehuballocateId)
                .map(allocated->{
                    allocated.setPurpose(ehubAllocate.getPurpose());
                    allocated.setAllocateAmount(ehubAllocate.getAllocateAmount());
                    allocated.setDescription(ehubAllocate.getDescription());
                    allocated.setAllocateDate(ehubAllocate.getAllocateDate());
                    return ehubAllocateRepository.save(allocated);
                }).orElseThrow(()->new NotFoundException("ehub id is not found"));
    }





    public Double allocatedSum(Long id){
        Ehub singleehub = ehubRepository.getOne(id);
        Double allocatedsum=0.0;
        List<EhubAllocate> ehuballocates = ehubAllocateRepository.getEhubAllocateByEhubId(singleehub.getId());
        for(EhubAllocate ehubAllocate: ehuballocates){
            allocatedsum =allocatedsum +ehubAllocate.getAllocateAmount();
        }
        return allocatedsum;
    }




}
