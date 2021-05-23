package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.InvestmentCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InvestmentCategoryService {


    public List<InvestmentCategory> getAllInvestmentCategories();
    public ResponseEntity<Response> saveInvestmentCategory(String investmentCategory);
    public ResponseEntity<InvestmentCategory> getInvestmentCategory(int id);
    public ResponseEntity<InvestmentCategory> deleteInvestmentCategory(int id);
}
