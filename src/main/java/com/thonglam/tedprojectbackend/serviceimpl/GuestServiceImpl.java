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
import com.thonglam.tedprojectbackend.dao.GuestRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Guest;
import com.thonglam.tedprojectbackend.properties.StorageProperties;
import com.thonglam.tedprojectbackend.service.GuestService;
import com.thonglam.tedprojectbackend.service.StorageService;



@Service("guestService")
public class GuestServiceImpl implements GuestService {


    @Autowired private GuestRepository repository;
    @Autowired StorageService storageService;

    private final Path rootLocation;

    @Autowired
    public GuestServiceImpl(StorageProperties properties) {

        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public List<Guest> getAllGuest() {
        return repository.findAll();
    }



    @Override
    public ResponseEntity<Response> saveGuest(MultipartFile file, String guest) {
        Guest guest1 =null;
        try {
         guest1 =new ObjectMapper().readValue(guest, Guest.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        if (file != null) {
            String filename=  storageService.store(file);
            guest1.setFileName(filename);
        }

        Guest guestDb=repository.save(guest1);
        if(guestDb != null){
            return new ResponseEntity<Response>(new Response("Guest Details are upload successfully "), HttpStatus.OK);
        }
        return new ResponseEntity<Response>(new Response("Guest Details are not able to uploaded "), HttpStatus.BAD_REQUEST);
    }



    @Override
    public ResponseEntity<Guest> getOneGuest(int id) {
        Guest guest=repository.getOne(id);
        if(guest ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(guest);
    }

    @Override
    public ResponseEntity<Guest> deleteGuest(int id) {
        Guest guest=repository.getOne(id);
        if(guest ==null){
            return ResponseEntity.notFound().build();
        }
          repository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
