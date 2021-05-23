package com.thonglam.tedprojectbackend.serviceimpl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thonglam.tedprojectbackend.dao.AnnounceRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Announce;
import com.thonglam.tedprojectbackend.properties.StorageProperties;
import com.thonglam.tedprojectbackend.service.AnnounceService;


@Service("announceService")
public class AnnounceServiceImpl implements AnnounceService {


    @Autowired
    private AnnounceRepository announceRepository;

    private final Path rootLocation;


    @Autowired
    private FileSystemStorageService storageService;

    public AnnounceServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }


    @Override
    public List<Announce> getAnnounces() {
        return announceRepository.findAll();
    }

    @Override
    public ResponseEntity<Response> saveAnnounce(MultipartFile file, String announce) {
     Announce announce1=null;
     try {
         announce1 =new ObjectMapper().readValue(announce, Announce.class);
     }catch (Exception e){
         e.printStackTrace();
     }

   if(file !=null){
       String filename=  storageService.store(file);
         announce1.setFileName(filename);
   }

   Announce announceDb=announceRepository.save(announce1);
     if(announceDb !=null){
         return new ResponseEntity<>(new Response("announcement added successfully"), HttpStatus.OK);
     }

        return new ResponseEntity<>(new Response("announcement not able to add so checke again"), HttpStatus.BAD_REQUEST);
    }




    @Override
    public ResponseEntity<Announce> getAnnounce(int id) {
        Announce announce=announceRepository.getOne(id);
        if(announce ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(announce);
    }




    @Override
    public ResponseEntity<Announce> deleteAnnounce(int id) {
        Announce announce=announceRepository.getOne(id);
        if(announce == null){
            return ResponseEntity.notFound().build();
        }
         announceRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
