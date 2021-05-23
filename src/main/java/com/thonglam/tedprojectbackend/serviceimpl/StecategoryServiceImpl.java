package com.thonglam.tedprojectbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thonglam.tedprojectbackend.dao.StecategoryRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Stecategory;
import com.thonglam.tedprojectbackend.service.StecategoryService;

@Service("stecategoryService")
public class StecategoryServiceImpl implements StecategoryService {

    @Autowired
    StecategoryRepository stecategoryRepository;


    @Override
    public List<Stecategory> getAllSteCategories() {
        return stecategoryRepository.findAll();
    }



    @Override
    public ResponseEntity<Response> saveSteCategory(String stecategory) {
        Stecategory category=null;
        try {
            category =new ObjectMapper().readValue(stecategory, Stecategory.class);
        }catch (Exception e){
            e.printStackTrace();
        }


        Stecategory stecategoryDb=stecategoryRepository.save(category);
        if(stecategoryDb !=null){
            return new ResponseEntity<>(new Response("STE category added successfully"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new Response("STE category not able to add so checke again"), HttpStatus.BAD_REQUEST);
    }




    @Override
    public ResponseEntity<Stecategory> getOneSteCategory(int id) {
        Stecategory category=stecategoryRepository.getOne(id);
        if(category ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(category);
    }



    @Override
    public ResponseEntity<Stecategory> deleteSteCategory(int id) {
        Stecategory category=stecategoryRepository.getOne(id);
        if(category == null){
            return ResponseEntity.notFound().build();
        }
        stecategoryRepository.delete(category);
        return ResponseEntity.ok().build();
    }
}
