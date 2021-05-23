package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.dto.ReturnMoney;
import com.thonglam.tedprojectbackend.dto.SnowBank;
import com.thonglam.tedprojectbackend.service.ReturnMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/returnmoney")
public class ReturnMoneyController {

    @Autowired
    ReturnMoneyService returnMoneyService;


    @GetMapping("/getAllReturnMoney")
    List<ReturnMoney> getAllReturnMoney(){
        return returnMoneyService.getAllReturnMoney();
    }


    @PostMapping("/addReturnMoney/{snowbankId}")
    @PreAuthorize("hasRole('ADMIN')")
    ReturnMoney addReturnmoneyToSnowbank(@PathVariable Long snowbankId, @RequestBody ReturnMoney returnMoney){
        return returnMoneyService.addReturnmoneyToSnowbank(snowbankId,returnMoney);
    }


    @GetMapping("/getReturnMoneyBySnowbankId/{snowbankId}")
    List<ReturnMoney> getReturnMoneyBySnowBankId(@PathVariable Long snowbankId){
        return returnMoneyService.getReturnMoneyBySnowBankId(snowbankId);
    }


    @GetMapping("/getOneReturnMoney/{snowbankId}")
    Optional<SnowBank> getOneSnowbank(@PathVariable Long returnmoney){
        return returnMoneyService.getOneReturnMoney(returnmoney);
    }


   @PutMapping("/updateReturnMoney/{snowbankId}/{returnmoneyId}")
   @PreAuthorize("hasRole('ADMIN')")
    public ReturnMoney updateReturnMoney(@PathVariable Long snowbankId, @PathVariable Long returnmoneyId, @RequestBody ReturnMoney returnMoney){
        return returnMoneyService.updateReturnMoney(snowbankId, returnmoneyId, returnMoney);
    }


    @DeleteMapping("/deleteReturnMoney/{snowbankId}/{returnmoneyId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteReturnMoney(@PathVariable Long snowbankId, @PathVariable Long returnmoneyId){
        return returnMoneyService.deleteReturnMoney(snowbankId, returnmoneyId);
    }
}
