package com.thonglam.tedprojectbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Ehubcategory;
import com.thonglam.tedprojectbackend.service.EhubcategoryService;

@RestController
@RequestMapping("/ehubcategory")
public class EhubcategoryController {


    @Autowired
    EhubcategoryService ehubcategoryService;


    @GetMapping("/getAllEhubCategories")
    public List<Ehubcategory> getAllEhubcategories(){
        return ehubcategoryService.getAllEhubcategories();
    }


    @PostMapping("/addEhubCategory")
    public ResponseEntity<Response> saveEhubCategory(@RequestParam(name = "ehubcategory")  String ehubcategory){
        return ehubcategoryService.saveEhubCategory(ehubcategory);
    }


    @GetMapping("/getOneEhubCategory/{id}")
    public ResponseEntity<Ehubcategory> getOneEhubCategory(@PathVariable int id){
        return ehubcategoryService.getOneEhubCategory(id);
    }


    @DeleteMapping("/deleteEhubCategory/{id}")
    public ResponseEntity<Ehubcategory> deleteEhubCategory(@PathVariable int id){
        return ehubcategoryService.deleteEhubCategory(id);
    }

}
