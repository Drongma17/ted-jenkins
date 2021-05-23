package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.InvestmentCategory;
import com.thonglam.tedprojectbackend.service.InvestmentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investment_category")
public class InvestmentCategoryController {

    @Autowired
    InvestmentCategoryService investmentCategoryService;

     @GetMapping("/getAllInvestmentCategories")
    public List<InvestmentCategory> getAllInvestmentCategories(){
        return investmentCategoryService.getAllInvestmentCategories();
    }


    @PostMapping("/saveInvestmentCategory")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response> saveInvestmentCategory(@RequestParam(name = "investmentCategory") String investmentCategory){
         return investmentCategoryService.saveInvestmentCategory(investmentCategory);
    }


    @GetMapping("/getOneInvestmentCategory/{id}")
    public ResponseEntity<InvestmentCategory> getInvestmentCategory(@PathVariable int id){
         return investmentCategoryService.getInvestmentCategory(id);
    }


    @DeleteMapping("/deleteInvestmentCategory/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<InvestmentCategory> deleteInvestmentCategory(int id){
         return investmentCategoryService.deleteInvestmentCategory(id);
    }
}
