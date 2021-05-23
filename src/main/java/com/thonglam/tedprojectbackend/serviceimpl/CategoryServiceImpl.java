package com.thonglam.tedprojectbackend.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thonglam.tedprojectbackend.dao.CategoryRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Announce;
import com.thonglam.tedprojectbackend.dto.Category;
import com.thonglam.tedprojectbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    @Override
    public ResponseEntity<Response> saveCategory(String categor) {
        Category category=null;
        try {
            category =new ObjectMapper().readValue(categor, Category.class);
        }catch (Exception e){
            e.printStackTrace();
        }


        Category categoryDb=categoryRepository.save(category);
        if(categoryDb !=null){
            return new ResponseEntity<>(new Response("category added successfully"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new Response("category not able to add so checke again"), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Category> getOneCategory(int id) {
        Category category=categoryRepository.getOne(id);
        if(category ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(category);
    }



    @Override
    public ResponseEntity<Category> deleteCategory(int id) {
        Category category=categoryRepository.getOne(id);
        if(category == null){
            return ResponseEntity.notFound().build();
        }
        categoryRepository.delete(category);
        return ResponseEntity.ok().build();
    }
}
