package com.thonglam.tedprojectbackend.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thonglam.tedprojectbackend.dao.SnowbankCategoryRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.SnowbankCategory;
import com.thonglam.tedprojectbackend.service.SnowbankCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("snowbankCategoryService")
public class SnowbankCategoryServiceImpl implements SnowbankCategoryService {


    @Autowired
    SnowbankCategoryRepository snowbankCategoryRepository;


    @Override
    public List<SnowbankCategory> getAllSnowbankCategories() {
        return snowbankCategoryRepository.findAll();
    }


    @Override
    public ResponseEntity<Response> saveSnowbankCategory(String snowbankCategory) {
        SnowbankCategory snowbankCategory1 = null;
        try {
            snowbankCategory1 = new ObjectMapper().readValue(snowbankCategory, SnowbankCategory.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SnowbankCategory snowbankCategoryDb = snowbankCategoryRepository.save(snowbankCategory1);

        if (snowbankCategoryDb == null) {
            return new ResponseEntity<>(new Response("snow bank category is not able to save"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Response("snow bank category is saved successfully"), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<SnowbankCategory> getSnowbankCategory(int id) {
        SnowbankCategory snowbankCategory = snowbankCategoryRepository.getOne(id);
        if (snowbankCategory != null) {
            return ResponseEntity.ok().body(snowbankCategory);
        }
        return ResponseEntity.notFound().build();
    }


    @Override
    public ResponseEntity<SnowbankCategory> deleteSnowbankCategory(int id) {
        SnowbankCategory snowbankCategory = snowbankCategoryRepository.getOne(id);
        if (snowbankCategory == null) {
            return ResponseEntity.notFound().build();
        }
        snowbankCategoryRepository.delete(snowbankCategory);
        return ResponseEntity.ok().body(snowbankCategory);
    }


}