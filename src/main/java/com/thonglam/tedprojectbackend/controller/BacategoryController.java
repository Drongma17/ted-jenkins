package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Bacategory;
import com.thonglam.tedprojectbackend.service.BacategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bacategory")
public class BacategoryController {

    @Autowired
    private BacategoryService bacategoryService;


    @GetMapping("/getALLbacategories")
    public List<Bacategory> getAllBaCategories(){
        return bacategoryService.getAllBaCategories();
    }



    @PostMapping("/savebacategory")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response> saveBaCategory(@RequestParam(name = "bacategory") String category){
        return bacategoryService.saveBaCategory(category);
    }



    @GetMapping("/getOnebacategory/{id}")
    public ResponseEntity<Bacategory> getOneBaCategory(@PathVariable int id){
        return bacategoryService.getOneBaCategory(id);
    }



    @DeleteMapping("deleteBacategory/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Bacategory> deleteBaCategory(@PathVariable int id){
        return bacategoryService.deleteBaCategory(id);
    }
}
