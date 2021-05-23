package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.dto.EhubFinance;
import com.thonglam.tedprojectbackend.service.EhubFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/ehubFinance")
public class EhubFinanceController {


    @Autowired
    EhubFinanceService ehubFinanceService;

    @GetMapping("/getAllEhubFinances")
    List<EhubFinance> getAllEhubFinance(){
        return ehubFinanceService.getAllEhubFinance();
    }


    @PostMapping("/addEhubFinance/{ehubId}/milestone")
    @PreAuthorize("hasRole('ADMIN')")
    EhubFinance addEhubFinanceToEhub(@PathVariable Long ehubId, @Valid @RequestBody EhubFinance ehubFinance){
        return ehubFinanceService.addEhubFinanceToEhub(ehubId, ehubFinance);
    }


    @GetMapping("/getAllEhubFinanceOfEhub/{ehubId}")
    List<EhubFinance> getAllEhubFinanceByEhubId(@PathVariable Long ehubId){
        return ehubFinanceService.getAllEhubFinanceByEhubId(ehubId);
    }


    @DeleteMapping("/deleteehub/{ehubId}/milestone/{ehubfinanceId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteEhubFinance(@PathVariable Long ehubId, @PathVariable Long ehubfinanceId){
        return ehubFinanceService.deleteEhubFinance(ehubId, ehubfinanceId);
    }




    @PutMapping("/ehub/{ehubId}/financial/{ehubfinanceIf}")
    @PreAuthorize("hasRole('ADMIN')")
    public EhubFinance updateEhubFinance(@PathVariable Long ehubId, @PathVariable Long ehubfinanceIf, @Valid @RequestBody EhubFinance ehubFinance){
        return ehubFinanceService.updateEhubFinance(ehubId, ehubfinanceIf, ehubFinance);
    }

}
