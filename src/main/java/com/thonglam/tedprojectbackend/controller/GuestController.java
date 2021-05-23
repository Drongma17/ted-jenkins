package com.thonglam.tedprojectbackend.controller;


import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Guest;
import com.thonglam.tedprojectbackend.service.GuestService;
import com.thonglam.tedprojectbackend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/guestProfile")
public class GuestController {


    @Autowired
    private GuestService guestService;

    @Autowired
    private StorageService storageService;


    @GetMapping("/getAllGuests")
    public List<Guest> getAllGuest(){
        return guestService.getAllGuest();
    }


    @PostMapping("/saveGuest")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response> saveGuest(@RequestParam(name = "file", required = false) MultipartFile file,
                                              @RequestParam(name = "guest") String guest){
        return guestService.saveGuest(file, guest);
    }



    @GetMapping("/getSingleGuest/{id}")
    public ResponseEntity<Guest>  getOneGuest(@PathVariable int id){
        return guestService.getOneGuest(id);
    }

    @DeleteMapping("/deleteParticularGuest/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Guest> deleteGuest(@PathVariable int id){
        return guestService.deleteGuest(id);
    }




    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }



}
