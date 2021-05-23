package com.thonglam.tedprojectbackend.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Bacategory;

public interface BacategoryService {


    public List<Bacategory> getAllBaCategories();
    public ResponseEntity<Response> saveBaCategory(String category);
    public ResponseEntity<Bacategory> getOneBaCategory(int id);
    public ResponseEntity<Bacategory> deleteBaCategory(int id);
}
