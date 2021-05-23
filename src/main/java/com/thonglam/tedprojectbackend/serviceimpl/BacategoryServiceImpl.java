package com.thonglam.tedprojectbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thonglam.tedprojectbackend.dao.BacategoryRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Bacategory;
import com.thonglam.tedprojectbackend.service.BacategoryService;


@Service("bacategoryService")
public class BacategoryServiceImpl implements BacategoryService {


    @Autowired
    private BacategoryRepository bacategoryRepository;



    @Override
    public List<Bacategory> getAllBaCategories() {
        return bacategoryRepository.findAll();
    }



    @Override
    public ResponseEntity<Response> saveBaCategory(String bacategory) {
        Bacategory category=null;
        try {
            category =new ObjectMapper().readValue(bacategory, Bacategory.class);
        }catch (Exception e){
            e.printStackTrace();
        }


        Bacategory bacategoryDb=bacategoryRepository.save(category);
        if(bacategoryDb !=null){
            return new ResponseEntity<>(new Response("BA category added successfully"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new Response("BA category not able to add so checke again"), HttpStatus.BAD_REQUEST);
    }



    @Override
    public ResponseEntity<Bacategory> getOneBaCategory(int id) {
        Bacategory category=bacategoryRepository.getOne(id);
        if(category ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(category);
    }



    @Override
    public ResponseEntity<Bacategory> deleteBaCategory(int id) {
        Bacategory category=bacategoryRepository.getOne(id);
        if(category == null){
            return ResponseEntity.notFound().build();
        }
        bacategoryRepository.delete(category);
        return ResponseEntity.ok().build();
    }


}
