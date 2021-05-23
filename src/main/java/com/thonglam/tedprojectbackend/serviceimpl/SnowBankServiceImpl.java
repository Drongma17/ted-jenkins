package com.thonglam.tedprojectbackend.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thonglam.tedprojectbackend.dao.SnowBankRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.SnowBank;
import com.thonglam.tedprojectbackend.properties.StorageProperties;
import com.thonglam.tedprojectbackend.service.SnowBankService;
import com.thonglam.tedprojectbackend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


@Service("snowBankService")
public class SnowBankServiceImpl implements SnowBankService {


    @Autowired private SnowBankRepository snowBankRepository;
    @Autowired StorageService storageService;

    private final Path location;


    @Autowired
    public SnowBankServiceImpl(StorageProperties properties) {
        this.location = Paths.get(properties.getLocation());
    }



    @Override
    public List<SnowBank> getAllSnowBank() {
        return snowBankRepository.findAll();
    }




    @Override
    public ResponseEntity<Response> saveSnowBank(MultipartFile file, String snowbank) {
        SnowBank snowBank =null;
        try {
            snowBank =new ObjectMapper().readValue(snowbank, SnowBank.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(file !=null){
            String filename=storageService.store(file);
            snowBank.setFileName(filename);
        }

        SnowBank snowBankDB =snowBankRepository.save(snowBank);
        if(snowBankDB !=null){
            return new ResponseEntity<>(new Response("Snow Bank Entity  are saved "), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Snow Bank Entity  are able to save"), HttpStatus.BAD_REQUEST);
    }





    @Override
    public ResponseEntity<Optional<SnowBank>> getSnowBank(Long id) {
        Optional<SnowBank> snowBank=snowBankRepository.findById(id);
        if(snowBank == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(snowBank);
    }



    @Override
    public ResponseEntity<Optional<SnowBank>> deleteSnowBank(Long id) {
        Optional<SnowBank> snowBank=snowBankRepository.findById(id);
        if(snowBank == null){
            return ResponseEntity.notFound().build();
        }
        snowBankRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }



    @Override
    public List<SnowBank> getSnowBankSbCategoryName(String sbCategoryName) {
        return snowBankRepository.getSnowBankBySbCategoryName(sbCategoryName);
    }



}
