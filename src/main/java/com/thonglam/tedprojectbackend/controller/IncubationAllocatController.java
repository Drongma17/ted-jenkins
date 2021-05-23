package com.thonglam.tedprojectbackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thonglam.tedprojectbackend.dto.IncubationAllot;
import com.thonglam.tedprojectbackend.service.IncubationallotService;

@RestController
@RequestMapping("/incubationAllot")
public class IncubationAllocatController {


    @Autowired
    IncubationallotService incubationallotService;



    @GetMapping("/getAllIncubationAllocated")
    List<IncubationAllot> getAllIncubationallot(){
        return incubationallotService.getAllIncubationallot();
    }


    @PostMapping("/incubation/{entrepreneurId}/allocated")
    @PreAuthorize("hasRole('ADMIN')")
    IncubationAllot addAllotToEntrepreneur(@PathVariable Long entrepreneurId, @Valid @RequestBody IncubationAllot incubationAllot){
        return incubationallotService.addAllotToEntrepreneur(entrepreneurId, incubationAllot);
    }


    @GetMapping("/allAllocatedByEntrepreneurId/{entrepreneurId}")
    List<IncubationAllot> getAllAllocatedByEntrepreneurId(@PathVariable Long entrepreneurId){
        return incubationallotService.getAllByEntrepreneurId(entrepreneurId);
    }


   @DeleteMapping("/delete/{entrepreneurId}/allocated/{incubationallotId}")
   @PreAuthorize("hasRole('ADMIN')")
    public String deleteIncubationAllot(@PathVariable Long entrepreneurId, @PathVariable int incubationallotId){
        return incubationallotService.deleteIncubationAllot(entrepreneurId, incubationallotId);
    }


     @PutMapping("/update/{entrepreneurId}/allocated/{incubationallotId}")
     @PreAuthorize("hasRole('ADMIN')")
    public IncubationAllot updateIncubationAllot(@PathVariable Long entrepreneurId, @PathVariable int incubationallotId, @Valid @RequestBody IncubationAllot incubationAllot){
        return incubationallotService.updateIncubationAllot(entrepreneurId, incubationallotId, incubationAllot);
    }

}
