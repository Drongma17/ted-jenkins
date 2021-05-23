package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.dto.SubCategory;
import com.thonglam.tedprojectbackend.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subCategory")
public class SubCategoryController {


   @Autowired
    SubCategoryService subCategoryService;


   @GetMapping("/getByChildCategory/{childCategory}")
    public List<SubCategory> getByChildCategory(@PathVariable Integer childCategory){
       if(childCategory <=0){
           return subCategoryService.getByChildCategory(null);
       }else{
           return subCategoryService.getByChildCategory(childCategory);
       }
    }


    @GetMapping("/getById/{id}")
    public SubCategory getById(@PathVariable int id){
        return subCategoryService.getById(id);
    }


    @GetMapping("/getByName/{name}")
    public List<SubCategory> getByName(@PathVariable String name){
        return subCategoryService.getByName(name);
    }


    @PostMapping("/saveSubCategory")
    public SubCategory saveSubCategory(@RequestBody SubCategory subcategory){
        return subCategoryService.saveSubCategory(subcategory);
    }
}
