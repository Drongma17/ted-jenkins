package com.thonglam.tedprojectbackend.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thonglam.tedprojectbackend.dao.EhubRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Ehub;
import com.thonglam.tedprojectbackend.properties.StorageProperties;
import com.thonglam.tedprojectbackend.service.EhubService;
import com.thonglam.tedprojectbackend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service("ehubService")
@Transactional
public class EhubServiceImpl implements EhubService {

    @Autowired private EhubRepository ehubRepository;
    @Autowired StorageService storageService;

    private final Path rootLocation;

    @Autowired
    public EhubServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public List<Ehub> getAllEhub() {
        return ehubRepository.findAll();
    }





    @Override
    public ResponseEntity<Response> saveEhub(MultipartFile file, String ehub) {
        Ehub ehub1 =null;
        try {
            ehub1=new ObjectMapper().readValue(ehub, Ehub.class);
        }catch (Exception e){
            e.getMessage();
        }

        if(file !=null){
          String fileName=  storageService.store(file);
            ehub1.setFileName(fileName);
        }

        Ehub ehubDb=ehubRepository.save(ehub1);
        if(ehubDb !=null){
          return   new  ResponseEntity<>(new Response("ehub is saved successfully"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new Response(" ehub not able to save "), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Optional<Ehub>> getEhub(Long id) {
      Optional<Ehub> ehubId= ehubRepository.findById(id);
      if(ehubId ==null){
         return ResponseEntity.notFound().build();
      }
        return ResponseEntity.ok().body(ehubId);
    }




    @Override
    public ResponseEntity<Optional<Ehub>> deleteEhub(Long id) {
        Optional<Ehub> ehubId= ehubRepository.findById(id);
        if(ehubId ==null) {
            return ResponseEntity.notFound().build();
        }
        ehubRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @Override
    public List<Ehub> getEhubByehubCategoryName(String ehubCategoryName) {
        return ehubRepository.getEhubByehubCategoryName(ehubCategoryName);
    }
}
