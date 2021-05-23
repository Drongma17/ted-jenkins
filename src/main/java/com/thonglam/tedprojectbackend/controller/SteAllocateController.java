package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.dto.SteAllocate;
import com.thonglam.tedprojectbackend.service.SteAllocateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/steallocate")
public class SteAllocateController {

   @Autowired
    SteAllocateService steAllocateService;

    @GetMapping("/getAllSteAllocates")
    List<SteAllocate> getAllSteAllocates(){
        return steAllocateService.getAllSteAllocates();
    }


    @PostMapping("/addSteAllocate/{steId}")
    @PreAuthorize("hasRole('ADMIN')")
    SteAllocate addSteAllocate(@PathVariable Long steId, @Valid @RequestBody SteAllocate steAllocate){
        return steAllocateService.addSteAllocate(steId, steAllocate);
    }


    @GetMapping("/getSteAllocateBySteId/{steId}")
    List<SteAllocate> getSteAllocatesBySteId(@PathVariable Long steId){
        return steAllocateService.getSteAllocatesBySteId(steId);
    }


    @DeleteMapping("/deleteSteallocate/{steId}/{steallocateId}")
    @PreAuthorize("hasRole('ADMIN')")
    String deleteSteAllocate(@PathVariable Long steId, @PathVariable int steallocateId){
        return steAllocateService.deleteSteAllocate(steId, steallocateId);
    }


    @PutMapping("/updateSteAllocate/{steId}/allocate/{steallocateId}")
    @PreAuthorize("hasRole('ADMIN')")
    SteAllocate updateSteAllocate(@PathVariable Long steId, @PathVariable int steallocateId, @Valid @RequestBody SteAllocate steAllocate){
        return steAllocateService.updateSteAllocate(steId, steallocateId, steAllocate);
    }


}
