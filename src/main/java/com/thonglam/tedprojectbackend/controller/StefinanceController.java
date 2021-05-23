package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.dto.Stefinance;
import com.thonglam.tedprojectbackend.service.StefinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stefinance")
public class StefinanceController {

   @Autowired StefinanceService stefinanceService;


   @GetMapping("/getAllStefinance")
    List<Stefinance> getAllSteFinance() {
        return stefinanceService.getAllSteFinance();
    }


    @PostMapping("/addfinancetoSte/{steId}/milestone")
    @PreAuthorize("hasRole('ADMIN')")
    Stefinance addFinanceToSte(@PathVariable Long steId,  @Valid @RequestBody Stefinance finance){
       return stefinanceService.addFinanceToSte(steId, finance);
    }


    @DeleteMapping("/deleteStefinance/{steId}/milestone/{steFinanceId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteStfinance(@PathVariable Long steId, @PathVariable Long steFinanceId){
       return stefinanceService.deleteStfinance(steId, steFinanceId);
    }



    @GetMapping("/getAllBySteId/{steId}")
    public List<Stefinance> getBySteId(@PathVariable Long steId){
       return stefinanceService.getBySteId(steId);
    }



   @PutMapping("/updatestefinance/{steId}/milestone/{stefinanceId}")
   @PreAuthorize("hasRole('ADMIN')")
    Stefinance updateStefinance(@PathVariable Long steId, @PathVariable Long stefinanceId, @Valid @RequestBody Stefinance stefinance){
     return stefinanceService.updateStefinance(steId, stefinanceId, stefinance);
    }

}
