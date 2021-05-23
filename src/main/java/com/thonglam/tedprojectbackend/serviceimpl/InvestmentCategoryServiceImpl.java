package com.thonglam.tedprojectbackend.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thonglam.tedprojectbackend.dao.InvestmentCategoryRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.InvestmentCategory;
import com.thonglam.tedprojectbackend.service.InvestmentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("investmentCategoryService")
public class InvestmentCategoryServiceImpl implements InvestmentCategoryService {

    @Autowired
    private InvestmentCategoryRepository investmentCategoryRepository;

    @Override
    public List<InvestmentCategory> getAllInvestmentCategories() {
        return investmentCategoryRepository.findAll();
    }


    @Override
    public ResponseEntity<Response> saveInvestmentCategory(String investmentCategory) {
        InvestmentCategory investmentCategory1=null;
        try {
            investmentCategory1=new ObjectMapper().readValue(investmentCategory, InvestmentCategory.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        InvestmentCategory investmentCategoryDb=investmentCategoryRepository.save(investmentCategory1);
        if(investmentCategoryDb ==null){
            return new ResponseEntity<>(new Response("Investment Category is not able to save"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Response("Investment Category is saved successfully "), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<InvestmentCategory> getInvestmentCategory(int id) {
        InvestmentCategory investmentCategory =investmentCategoryRepository.getOne(id);
         if(investmentCategory !=null){
             return ResponseEntity.ok().body(investmentCategory);
         }
        return ResponseEntity.notFound().build();
    }


    @Override
    public ResponseEntity<InvestmentCategory> deleteInvestmentCategory(int id) {
        InvestmentCategory investmentCategory=investmentCategoryRepository.getOne(id);
        if(investmentCategory == null){
            return ResponseEntity.notFound().build();
        }
        investmentCategoryRepository.delete(investmentCategory);
        return ResponseEntity.ok().body(investmentCategory);
    }

}
