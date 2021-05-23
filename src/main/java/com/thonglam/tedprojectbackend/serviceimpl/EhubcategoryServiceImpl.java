package com.thonglam.tedprojectbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thonglam.tedprojectbackend.dao.EhubcategoryRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Ehubcategory;
import com.thonglam.tedprojectbackend.service.EhubcategoryService;

@Service("ehubcategoryService")
public class EhubcategoryServiceImpl implements EhubcategoryService {

    @Autowired
    EhubcategoryRepository ehubcategoryRepository;


    @Override
    public List<Ehubcategory> getAllEhubcategories() {
        return ehubcategoryRepository.findAll();
    }



    @Override
    public ResponseEntity<Response> saveEhubCategory(String ehubcategory) {
        Ehubcategory category=null;
        try {
            category =new ObjectMapper().readValue(ehubcategory, Ehubcategory.class);
        }catch (Exception e){
            e.printStackTrace();
        }


        Ehubcategory categoryDb=ehubcategoryRepository.save(category);
        if(categoryDb !=null){
            return new ResponseEntity<>(new Response("Ehub category added successfully"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new Response("Ehub category not able to add so checke again"), HttpStatus.BAD_REQUEST);
    }




    @Override
    public ResponseEntity<Ehubcategory> getOneEhubCategory(int id) {
        Ehubcategory category=ehubcategoryRepository.getOne(id);
        if(category ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(category);
    }




    @Override
    public ResponseEntity<Ehubcategory> deleteEhubCategory(int id) {
        Ehubcategory category=ehubcategoryRepository.getOne(id);
        if(category == null){
            return ResponseEntity.notFound().build();
        }
        ehubcategoryRepository.delete(category);
        return ResponseEntity.ok().build();
    }
}
