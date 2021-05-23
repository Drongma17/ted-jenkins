package com.thonglam.tedprojectbackend.controller;


import com.thonglam.tedprojectbackend.dto.BAAllocate;
import com.thonglam.tedprojectbackend.service.BAAllocateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/baallocate")
public class BAAllocateController {


   @Autowired BAAllocateService baAllocateService;


   @GetMapping("/getAllBAAlocates")
    List<BAAllocate> getAllBAAllocates(){
        return baAllocateService.getAllBAAllocates();
    }


    @PostMapping("/addBAAllocateToBusinessac/{businessacId}/allocated")
    @PreAuthorize("hasRole('ADMIN')")
    BAAllocate addBAAllocateToBusinessac(@PathVariable Long businessacId, @Valid @RequestBody BAAllocate baAllocate){
       return baAllocateService.addBAAllocateToBusinessac(businessacId, baAllocate);
    }


    @DeleteMapping("/deleteBAAllocate/{businessacId}/{bAAllocateId}")
    @PreAuthorize("hasRole('ADMIN')")
    String deleteBAAllocate(@PathVariable Long businessacId, @PathVariable int bAAllocateId){
       return baAllocateService.deleteBAAllocate(businessacId, bAAllocateId);
    }



    @GetMapping("/getALLBAAllocateByBusinessacId/{businessacId}")
    List<BAAllocate> getALLBAAllocateByBusinessacId(@PathVariable Long businessacId){
       return baAllocateService.getALLBAAllocateByBusinessacId(businessacId);
    }



    @PutMapping("/updateBAAllocateOfBusinessac/{businessacId}/allocated/{bAAlocateId}")
    @PreAuthorize("hasRole('ADMIN')")
    BAAllocate updateBAAllocateOfBusinessac(@PathVariable Long businessacId, @PathVariable int bAAlocateId, @Valid @RequestBody BAAllocate baAllocate){
       return baAllocateService.updateBAAllocateOfBusinessac(businessacId, bAAlocateId, baAllocate);
    }


}
