package com.thonglam.tedprojectbackend.controller;


import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Ste;
import com.thonglam.tedprojectbackend.service.SteService;
import com.thonglam.tedprojectbackend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/steprofile")
public class STEController {


    @Autowired SteService steService;
    @Autowired StorageService storageService;

    @GetMapping("/getAllStes")
    List<Ste> getAllSte(){
        return steService.getAllSte();
    }


    @PostMapping("/saveSte")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response> saveSte(@RequestParam(name = "file", required = false) MultipartFile file, @RequestParam String ste){
        return steService.saveSte(file, ste);
    }


    @GetMapping("/getSte/{id}")
    public ResponseEntity<Optional<Ste>> getSte(@PathVariable Long id){
        return steService.getSte(id);
    }



    @DeleteMapping("/deleteSte/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Optional<Ste>> deleteSte(@PathVariable Long id){
        return steService.deleteSte(id);
    }



    @GetMapping("/getSteByCategoryName/{steCategoryName}")
    public List<Ste> getSteBySteCategoryName(@PathVariable(name = "steCategoryName", required = false) String steCategoryName){
        return steService.getSteBySteCategoryName(steCategoryName);
    }




    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


}
