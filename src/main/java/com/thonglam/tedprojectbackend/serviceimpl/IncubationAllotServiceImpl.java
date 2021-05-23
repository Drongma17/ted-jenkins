package com.thonglam.tedprojectbackend.serviceimpl;

import com.thonglam.tedprojectbackend.dao.EntrepreneursDao;
import com.thonglam.tedprojectbackend.dao.IncubatonallotRepository;
import com.thonglam.tedprojectbackend.dto.Entrepreneurs;
import com.thonglam.tedprojectbackend.dto.IncubationAllot;
import com.thonglam.tedprojectbackend.exception.NotFoundException;
import com.thonglam.tedprojectbackend.service.IncubationallotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("incubationallotService")
public class IncubationAllotServiceImpl  implements IncubationallotService {

    @Autowired
    IncubatonallotRepository incubatonallotRepository;
    @Autowired
    EntrepreneursDao entrepreneursDao;


    @Override
    public List<IncubationAllot> getAllIncubationallot() {
        return incubatonallotRepository.findAll();
    }

    @Override
    public IncubationAllot addAllotToEntrepreneur(Long entrepreneurId, IncubationAllot incubationAllot) {
       return entrepreneursDao.findById(entrepreneurId)
               .map(incubation->{
                   incubationAllot.setEntrepreneur(incubation);
                   incubationAllot.setAllocatedSum(allocatedSum(entrepreneurId)+incubationAllot.getAllocatedAmount());
                   incubation.setAllocatedAmount(allocatedSum(entrepreneurId)+incubationAllot.getAllocatedAmount());
                   entrepreneursDao.save(incubation);
                   return incubatonallotRepository.save(incubationAllot);
               }).orElseThrow(()->new NotFoundException("Incubation is not found"));
    }




    @Override
    public List<IncubationAllot> getAllByEntrepreneurId(Long entrepreneurId) {
        if(!entrepreneursDao.existsById(entrepreneurId)){
            throw new NotFoundException("No Incubation is found");
        }
        return incubatonallotRepository.getIncubationAllotByEntrepreneurId(entrepreneurId);
    }




    @Override
    public String deleteIncubationAllot(Long entrepreneurId, int incubationallotId) {
        if(!entrepreneursDao.existsById(entrepreneurId)){
            throw new NotFoundException("Pre-Incubation is not found");
        }
      return incubatonallotRepository.findById(incubationallotId)
                .map(incubationAllot->{
                    incubatonallotRepository.delete(incubationAllot);
                    return "one alloted money is deleted from Pre-incubation";
                }).orElseThrow(()->new NotFoundException("incubation allot id is not found"));
    }




    @Override
    public IncubationAllot updateIncubationAllot(Long entrepreneurId, int incubationallotId, IncubationAllot incubationAllot) {
        if(!entrepreneursDao.existsById(entrepreneurId)){
            throw new NotFoundException("Pre-incubation is not found");
        }
        return incubatonallotRepository.findById(incubationallotId)
                .map(allocated->{
                    allocated.setAllocatedAmount(incubationAllot.getAllocatedAmount());
                    allocated.setAllocatedDate(incubationAllot.getAllocatedDate());
                    allocated.setDescription(incubationAllot.getDescription());
                    allocated.setPurpose(incubationAllot.getPurpose());
                    return incubatonallotRepository.save(allocated);
                }).orElseThrow(()->new NotFoundException("Incubation allot Id is not found"));
    }




    public Double allocatedSum(Long id){
        Entrepreneurs singleEntrepreneur = entrepreneursDao.getOne(id);
        Double allocatedsum=0.0;
        List<IncubationAllot> incubationAllots = incubatonallotRepository.getIncubationAllotByEntrepreneurId(singleEntrepreneur.getId());
        for(IncubationAllot incubationAllot: incubationAllots){
            allocatedsum =allocatedsum +incubationAllot.getAllocatedAmount();
        }
        return allocatedsum;
    }

}
