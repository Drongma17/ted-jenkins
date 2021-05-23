package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Investment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface InvestmentService {

    List<Investment> getAllInvestment();
    ResponseEntity<Response> saveInvestment(MultipartFile file, String investment);
    ResponseEntity<Optional<Investment>> getInvestment(Long id);
    ResponseEntity<Optional<Investment>> deleteInvestment(Long id);
    List<Investment> getInvestmentByInvestmentCategory(String investmentCategory);
}
