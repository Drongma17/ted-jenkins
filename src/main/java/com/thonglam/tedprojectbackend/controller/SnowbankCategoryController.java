package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.SnowbankCategory;
import com.thonglam.tedprojectbackend.service.SnowbankCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snowbankCategory")
public class SnowbankCategoryController {

    @Autowired
    SnowbankCategoryService snowbankCategoryService;

    @GetMapping("/getAllSnowbankCategories")
    List<SnowbankCategory> getAllSnowbankCategories(){
        return snowbankCategoryService.getAllSnowbankCategories();
    }


    @PostMapping("/saveSnowbankCategory")
//    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Response> saveSnowbankCategory(@RequestParam(name = "category", required = false) String category){
        return snowbankCategoryService.saveSnowbankCategory(category);
    }


    @GetMapping("/getSnowbankCategory/{id}")
    ResponseEntity<SnowbankCategory> getSnowbankCategory(@PathVariable int id){
        return snowbankCategoryService.getSnowbankCategory(id);
    }


    @DeleteMapping("/deleteSnowbankCategory/{id}")
    ResponseEntity<SnowbankCategory> deleteSnowbankCategory(@PathVariable int id){
        return snowbankCategoryService.deleteSnowbankCategory(id);
    }
}
