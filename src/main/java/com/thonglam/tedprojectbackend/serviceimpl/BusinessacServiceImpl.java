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
import com.thonglam.tedprojectbackend.dao.BusinessacRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Businessac;
import com.thonglam.tedprojectbackend.properties.StorageProperties;
import com.thonglam.tedprojectbackend.service.BusinessacService;
import com.thonglam.tedprojectbackend.service.StorageService;

@Service("businessacService")
public class BusinessacServiceImpl implements BusinessacService {

    @Autowired BusinessacRepository businessacRepository;
    @Autowired StorageService storageService;

    private final Path location;

    @Autowired
    public BusinessacServiceImpl(StorageProperties properties){
        this.location= Paths.get(properties.getLocation());
    }

    @Override
    public List<Businessac> getAllBusinessac() {
        return businessacRepository.findAll();
    }


    @Override
    public ResponseEntity<Response> saveBusinessac(MultipartFile file, String businessac) {
        Businessac businessac1 =null;
        try {
            businessac1=new ObjectMapper().readValue(businessac, Businessac.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(file !=null){
            String filename=  storageService.store(file);
            businessac1.setFileName(filename);
        }

        Businessac businessacDb= businessacRepository.save(businessac1);
        if(businessacDb !=null) {
            return new ResponseEntity(new Response("businessac is saved successfully"), HttpStatus.OK);
        }
        return new ResponseEntity(new Response("businessac is not able to save"), HttpStatus.BAD_REQUEST);
    }



    @Override
    public ResponseEntity<Optional<Businessac>> getBusinessaById(Long id) {
        Optional<Businessac> businessacId= businessacRepository.findById(id);
        if(businessacId ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(businessacId);
    }




    @Override
    public ResponseEntity<Optional<Businessac>> deleteBusinessac(Long id) {
            Optional<Businessac> business  =  businessacRepository.findById(id);
            if(business ==null){
                return ResponseEntity.notFound().build();
            }
            businessacRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @Override
    public List<Businessac> getBusinessacBybaCategoryName(String baCategoryName) {
        return businessacRepository.getBusinessacBybaCategoryName(baCategoryName);
    }


}
