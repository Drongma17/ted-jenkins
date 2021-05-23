package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.dto.InvestmentAllocate;
import com.thonglam.tedprojectbackend.service.InvestmentAllocateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/investmentallocate")
public class InvestmentAllocateController {



    @Autowired
    InvestmentAllocateService investmentAllocateService;



   @GetMapping("/getAllInvestmentAllocates")
    List<InvestmentAllocate> getAllInvestmentAllocate(){
        return investmentAllocateService.getAllInvestmentAllocate();
    }


    @PostMapping("/addInvestmentAllocate/{investmentId}")
    @PreAuthorize("hasRole('ADMIN')")
    InvestmentAllocate addAllotToInvest(@PathVariable Long investmentId, @Valid @RequestBody InvestmentAllocate investmentAllocate){
       return investmentAllocateService.addAllotToInvest(investmentId, investmentAllocate);
    }


    @GetMapping("/getAllByInvestmentId/{investmentId}")
    List<InvestmentAllocate> getAllByInvestmentId(@PathVariable Long investmentId){
       return investmentAllocateService.getAllByInvestmentId(investmentId);
    }


    @DeleteMapping("delete/{investmentId}/allocate/{investmentallocateId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteInvestmentAllot(@PathVariable Long investmentId, @PathVariable int investmentallocateId){
       return investmentAllocateService.deleteInvestmentAllot(investmentId, investmentallocateId);
    }


    @PutMapping("/updateInvestAllocate/{investmentId}/allocate/{investmentAllocateId}")
    @PreAuthorize("hasRole('ADMIN')")
    public InvestmentAllocate updateInvestmentAllot(@PathVariable Long investmentId, @PathVariable int investmentAllocateId, @Valid @RequestBody InvestmentAllocate investmentAllocate){
       return investmentAllocateService.updateInvestmentAllot(investmentId, investmentAllocateId, investmentAllocate);
    }
}
