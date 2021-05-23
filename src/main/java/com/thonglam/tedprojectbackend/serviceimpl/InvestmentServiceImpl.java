package com.thonglam.tedprojectbackend.serviceimpl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thonglam.tedprojectbackend.dao.InvestmentRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Investment;
import com.thonglam.tedprojectbackend.properties.StorageProperties;
import com.thonglam.tedprojectbackend.service.InvestmentService;
import com.thonglam.tedprojectbackend.service.StorageService;


@Service("investmentService")
public class InvestmentServiceImpl implements InvestmentService {

    @Autowired InvestmentRepository investmentRepository;
    @Autowired StorageService storageService;

    private final Path location;

    @Autowired
    public InvestmentServiceImpl(StorageProperties properties){
        this.location= Paths.get(properties.getLocation());
    }


    @Override
    public List<Investment> getAllInvestment() {
        return investmentRepository.findAll();
    }

    @Override
    public ResponseEntity<Response> saveInvestment(MultipartFile file, String investment) {
        Investment investment1 =null;
        try {
            investment1 =new ObjectMapper().readValue(investment, Investment.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(file !=null){
            String filename=storageService.store(file);
            investment1.setFileName(filename);
        }
          Investment investmentDb=   investmentRepository.save(investment1);
        if(investmentDb !=null){
            return new ResponseEntity<>(new Response("Investment properties are saved successfully"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Investment properties are not able to save"), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Optional<Investment>> getInvestment(Long id) {
        Optional<Investment> singleInvestment = investmentRepository.findById(id);
        if (singleInvestment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(singleInvestment);
    }




    @Override
    public ResponseEntity<Optional<Investment>> deleteInvestment(Long id) {
        Optional<Investment> investment= investmentRepository.findById(id);
        if(investment == null){
            return ResponseEntity.notFound().build();
        }
         investmentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @Override
    public List<Investment> getInvestmentByInvestmentCategory(String investmentCategory) {
        return investmentRepository.getInvestmentByInvestmentCategory(investmentCategory);
    }
}
