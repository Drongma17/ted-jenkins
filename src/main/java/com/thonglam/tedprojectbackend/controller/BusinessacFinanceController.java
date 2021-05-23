package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.dto.Businessacfinance;
import com.thonglam.tedprojectbackend.service.BusinessacfinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/BusinessacFinance")
public class BusinessacFinanceController {


    @Autowired BusinessacfinanceService businessacfinanceService;

    @GetMapping("/getAllBusinessacfinances")
    List<Businessacfinance> getAllBusinessacfinance(){
        return businessacfinanceService.getAllBusinessacfinance();
    }


    @PostMapping("/addbusinessacfinance/{businessacId}/milestone")
    @PreAuthorize("hasRole('ADMIN')")
    Businessacfinance addFinanceToBusinessac(@PathVariable Long businessacId, @Valid @RequestBody Businessacfinance businessacfinance){
        return businessacfinanceService.addFinanceToBusinessac(businessacId, businessacfinance);
    }


    @GetMapping("/getAllFinanceOfBusinessac/{businessacId}")
    List<Businessacfinance> getByBusinessacId(@PathVariable Long businessacId){
        return businessacfinanceService.getByBusinessacId(businessacId);
    }



    @PutMapping("/bafinance/{businessacId}/milestone/{businessacfinanceId}")
    @PreAuthorize("hasRole('ADMIN')")
    public Businessacfinance updateBusinessacFinance(@PathVariable Long businessacId, @PathVariable  Long businessacfinanceId, @Valid @RequestBody Businessacfinance businessacfinance){
        return businessacfinanceService.updateBusinessacFinance(businessacId, businessacfinanceId, businessacfinance);
    }




    @DeleteMapping("/businessac/{businessacId}/financial/{businessacfinanceId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBusinessacfinance(@PathVariable Long businessacId, @PathVariable Long businessacfinanceId){
        return businessacfinanceService.deleteBusinessacfinance(businessacId, businessacfinanceId);
    }

}
