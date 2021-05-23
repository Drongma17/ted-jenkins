package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.dto.Businessac;
import com.thonglam.tedprojectbackend.service.BusinessacService;
import com.thonglam.tedprojectbackend.domain.Response;
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
@RequestMapping("/businessac")
public class BusinessacController {


    @Autowired BusinessacService businessacService;
    @Autowired StorageService storageService;

    @GetMapping("/getAllBusinessac")
    public List<Businessac> getAllBusinessac(){
        return businessacService.getAllBusinessac();
    }



    @PostMapping("/saveBusinessac")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Response> saveBusinessac(@RequestParam(name = "file", required = false)MultipartFile file, @RequestParam String businessac){
        return businessacService.saveBusinessac(file, businessac);
    }


    @DeleteMapping("/deleteBusiness/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Optional<Businessac>> deleteBusinessac(@PathVariable(value ="id") Long id){
        return businessacService.deleteBusinessac(id);
    }


    @GetMapping("/getBusinessacById/{id}")
    ResponseEntity<Optional<Businessac>> getBusinessaById(@PathVariable Long id){
        return businessacService.getBusinessaById(id);
    }


    @GetMapping("/getBusinessacByCategory/{baCategoryName}")
    List<Businessac> getBusinessacBybaCategoryName(@PathVariable(name = "baCategoryName") String baCategoryName){
        return businessacService.getBusinessacBybaCategoryName(baCategoryName);
    }


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }






}
