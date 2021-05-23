package com.thonglam.tedprojectbackend.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Ehubcategory;

public interface EhubcategoryService {

    public List<Ehubcategory> getAllEhubcategories();
    public ResponseEntity<Response> saveEhubCategory(String ehubcategory);
    public ResponseEntity<Ehubcategory> getOneEhubCategory(int id);
    public ResponseEntity<Ehubcategory> deleteEhubCategory(int id);

}
