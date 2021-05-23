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

import com.thonglam.tedprojectbackend.dto.InvestmentFinance;
import com.thonglam.tedprojectbackend.service.InvestmentFinanceService;

@RestController
@RequestMapping("/investmentfinance")
public class InvestmentFinanceController {

    @Autowired
    private InvestmentFinanceService investmentFinanceService;

    @GetMapping("/getAllInvestmentFinance")
    List<InvestmentFinance> getAllInvestmentFinance(){
        return investmentFinanceService.getAllInvestmentFinance();
    }


    @PostMapping("/addInvestmentFinance/{investmentId}/milestone")
    @PreAuthorize("hasRole('ADMIN')")
    InvestmentFinance addFinanceToInvestment(@PathVariable Long investmentId, @Valid @RequestBody InvestmentFinance finance){
        return investmentFinanceService.addFinanceToInvestment(investmentId, finance);
    }




    @GetMapping("/getTotalFinanceByInvestmentId/{investmentId}")
    public List<InvestmentFinance> getByInvestmentId(@PathVariable Long investmentId){
      return investmentFinanceService.getByInvestmentId(investmentId);
    }



    @PutMapping("/investment/{investmentId}/milestone/{investmentfinance}")
    public InvestmentFinance updateInvestmentFinance(@PathVariable Long investmentId, @PathVariable Long investmentfinance, @Valid @RequestBody InvestmentFinance investmentFinance){
        return investmentFinanceService.updateInvestmentFinance(investmentId, investmentfinance, investmentFinance);
    }





    @DeleteMapping("/deleteInvestmentFinance/{investmentId}/milestone/{investmentfinanceId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteInvestmentFinance(@PathVariable Long investmentId, @PathVariable Long investmentfinanceId){
        return investmentFinanceService.deleteInvestmentFinance(investmentId, investmentfinanceId);
    }

}
