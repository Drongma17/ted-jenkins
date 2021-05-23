package com.thonglam.tedprojectbackend.controller;


import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Category;
import com.thonglam.tedprojectbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;




    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories(){
     return categoryService.getAllCategories();

   }



    @PostMapping("/addCategory")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response> saveCategory(@RequestParam(name = "category") String category){
      return categoryService.saveCategory(category);
    }


    @DeleteMapping("/deleteCategory/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Category> deleteCategory(@PathVariable int id){
    return categoryService.deleteCategory(id);
    }

}
