package com.thonglam.tedprojectbackend.controller;


import com.thonglam.tedprojectbackend.dto.LendMoney;
import com.thonglam.tedprojectbackend.service.LendMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lendmoney")
public class LendMoneyController {


     @Autowired
    LendMoneyService lendMoneyService;

     @GetMapping("/getAllLendMoney")
    List<LendMoney> getAllLendMoney(){
        return lendMoneyService.getAllLendMoney();
    }



    @PostMapping("/addlendMoney/{customerId}")
    @PreAuthorize("hasRole('ADMIN')")
    LendMoney addLendMoney(@PathVariable Long customerId, @Valid @RequestBody LendMoney lendMoney){
        return lendMoneyService.addLendMoney(customerId, lendMoney);
    }


    @GetMapping("/getMoneyBySnowbankId/{customerId}")
    List<LendMoney> getLendMoneyBySnowBankId(@PathVariable Long customerId){
        return lendMoneyService.getLendMoneyBySnowBankId(customerId);
    }


    @DeleteMapping("/deleteLendMoney/{customerId}/showbank/{lendmoneyId}")
    @PreAuthorize("hasRole('ADMIN')")
    String deleteLendMoney(@PathVariable Long customerId, @PathVariable int lendmoneyId){
        return lendMoneyService.deleteLendMoney(customerId, lendmoneyId);
    }




    @PutMapping("/updateLendMoney/{customerId}/{lendmoneyId}")
    @PreAuthorize("hasRole('ADMIN')")
    LendMoney updateLendMoney(@PathVariable Long customerId, @PathVariable int lendmoneyId, @RequestBody LendMoney lendMoney){
        return lendMoneyService.updateLendMoney(customerId, lendmoneyId, lendMoney);
    }


}
