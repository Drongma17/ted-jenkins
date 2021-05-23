package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Stecategory;
import com.thonglam.tedprojectbackend.service.StecategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stecategory")
public class StecategoryController {


    @Autowired
    StecategoryService stecategoryService;

    @GetMapping("/getAllSteCategories")
    public List<Stecategory> getAllSteCategories(){
        return stecategoryService.getAllSteCategories();
    }



    @PostMapping("/addStecategory")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response> saveSteCategory(@RequestParam(name = "stecategory", required = false) String stecategory){
        return stecategoryService.saveSteCategory(stecategory);
    }



    @GetMapping("/getOneSteCategory/{id}")
    public ResponseEntity<Stecategory> getOneSteCategory(@PathVariable int id){
        return stecategoryService.getOneSteCategory(id);
    }


   @DeleteMapping("/deletestecategory/{id}")
   @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Stecategory> deleteSteCategory(@PathVariable int id){
        return stecategoryService.deleteSteCategory(id);
    }
}
