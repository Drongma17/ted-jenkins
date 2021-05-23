package com.thonglam.tedprojectbackend.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Stecategory;

public interface StecategoryService {


    public List<Stecategory> getAllSteCategories();
    public ResponseEntity<Response> saveSteCategory(String category);
    public ResponseEntity<Stecategory> getOneSteCategory(int id);
    public ResponseEntity<Stecategory> deleteSteCategory(int id);
}
