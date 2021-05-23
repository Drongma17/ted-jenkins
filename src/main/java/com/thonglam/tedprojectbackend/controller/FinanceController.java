package com.thonglam.tedprojectbackend.controller;


import com.thonglam.tedprojectbackend.dto.Finance;
import com.thonglam.tedprojectbackend.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceController {


    @Autowired private FinanceService financeService;


    @GetMapping("/getAllFinance")
    List<Finance> getAllFinance(){
        return financeService.getAllFinance();
    }



    @PostMapping("/addFinance/{entrepreneurId}/milestone")
    @PreAuthorize("hasRole('ADMIN')")
    public Finance addFinanceToEntrepreneur(@PathVariable Long entrepreneurId, @Valid @RequestBody Finance finance){
         return financeService.addFinanceToEntrepreneur(entrepreneurId, finance);
    }



    @GetMapping("/getAllFinanceOfEntrepreneur/{entrepreneurId}")
    public List<Finance> getByEntrepreneurId(@PathVariable Long entrepreneurId){
          return financeService.getByEntrepreneurId(entrepreneurId);
    }


    @DeleteMapping("/preincubation/{entrepreneurId}/milestone/{financeId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteFinance(@PathVariable Long entrepreneurId, @PathVariable Long financeId){
      return financeService.deleteFinance(entrepreneurId, financeId);
    }


    @PutMapping("/entrepreneur/{entrepreneurId}/financial/{financeId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Finance updateFinance(@PathVariable Long entrepreneurId, @PathVariable Long financeId, @Valid @RequestBody Finance financee){
     return financeService.updateFinance(entrepreneurId, financeId, financee);
    }

}
