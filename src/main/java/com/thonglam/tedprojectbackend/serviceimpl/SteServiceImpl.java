package com.thonglam.tedprojectbackend.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thonglam.tedprojectbackend.dao.SteRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Ste;
import com.thonglam.tedprojectbackend.properties.StorageProperties;
import com.thonglam.tedprojectbackend.service.SteService;
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


@Service("steService")
public class SteServiceImpl implements SteService {

    @Autowired SteRepository steRepository;
    @Autowired StorageService storageService;

    private final Path location;



    @Autowired
    public SteServiceImpl(StorageProperties properties){
        this.location = Paths.get(properties.getLocation());
    }


    @Override
    public List<Ste> getAllSte() {
        return steRepository.findAll();
    }

    @Override
    public ResponseEntity<Response> saveSte(MultipartFile file, String ste) {
        Ste ste1 =null;
        try {
            ste1 =new ObjectMapper().readValue(ste, Ste.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(file !=null){
            String filename=storageService.store(file);
            ste1.setFileName(filename);
        }
        Ste steDb =steRepository.save(ste1);
        if(steDb !=null){
            return new ResponseEntity<>(new Response("Skill to Enterprice is saved "), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Response("Skill to Enterprice is not able to save"), HttpStatus.BAD_REQUEST);
    }



    @Override
    public ResponseEntity<Optional<Ste>> getSte(Long id) {
       Optional<Ste> ste= steRepository.findById(id);
       if(ste == null){
           return ResponseEntity.notFound().build();
       }
        return ResponseEntity.ok().body(ste);
    }


    @Override
    public ResponseEntity<Optional<Ste>> deleteSte(Long id) {
        Optional<Ste> ste =steRepository.findById(id);
        if(ste == null){
            return ResponseEntity.notFound().build();
        }
         steRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }



    @Override
    public List<Ste> getSteBySteCategoryName(String steCategoryName) {
        return steRepository.getSteBySteCategoryName(steCategoryName);
    }
}
