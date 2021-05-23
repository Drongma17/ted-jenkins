package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.SnowbankCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SnowbankCategoryService {

     List<SnowbankCategory> getAllSnowbankCategories();
     ResponseEntity<Response> saveSnowbankCategory(String snowbankCategory);
     ResponseEntity<SnowbankCategory> getSnowbankCategory(int id);
     ResponseEntity<SnowbankCategory> deleteSnowbankCategory(int id);

}
