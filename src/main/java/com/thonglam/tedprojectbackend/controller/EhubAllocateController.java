package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.dto.EhubAllocate;
import com.thonglam.tedprojectbackend.service.EhubAllocateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ehuballocates")
public class EhubAllocateController {


    @Autowired
    EhubAllocateService ehubAllocateService;

    @GetMapping("/getAllEhubAllocates")
    List<EhubAllocate> getAllEhubAllocates(){
        return ehubAllocateService.getAllEhubAllocates();
    }


    @PostMapping("/addEhubAllocate/{ehubId}/allocated")
    @PreAuthorize("hasRole('ADMIN')")
    EhubAllocate addEhubAllocate(@PathVariable Long ehubId, @Valid @RequestBody EhubAllocate ehubAllocate){
        return ehubAllocateService.addEhubAllocate(ehubId, ehubAllocate);
    }


    @GetMapping("/getEhubAllocatedByEhubId/{ehubId}")
    List<EhubAllocate> getAllEhubAllocatesByEhubId(@PathVariable Long ehubId){
        return ehubAllocateService.getEhubAllocatesByEhubId(ehubId);
    }


    @DeleteMapping("/deleteEhubAllocate/{ehubId}/allocate/{ehuballocateId}")
    @PreAuthorize("hasRole('ADMIN')")
    String deleteEhubAllocate(@PathVariable Long ehubId, @PathVariable int ehuballocateId){
        return ehubAllocateService.deleteEhubAllocate(ehubId, ehuballocateId);
    }


    @PutMapping("/update/{ehubId}/allocate/{ehuballocateId}")
    @PreAuthorize("hasRole('ADMIN')")
    public EhubAllocate updateEhubAllocate(@PathVariable Long ehubId, @PathVariable int ehuballocateId, @Valid @RequestBody  EhubAllocate ehubAllocate){
        return ehubAllocateService.updateEhubAllocate(ehubId, ehuballocateId, ehubAllocate);
    }


}
