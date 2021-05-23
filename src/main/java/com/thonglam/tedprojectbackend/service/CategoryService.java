package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();
    public ResponseEntity<Response> saveCategory(String category);
    public ResponseEntity<Category> getOneCategory(int id);
    public ResponseEntity<Category> deleteCategory(int id);

}
