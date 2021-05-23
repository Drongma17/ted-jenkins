package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Application;
import com.thonglam.tedprojectbackend.service.ApplicationService;
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
@RequestMapping("/applications")
public class ApplicationController {


   @Autowired
    ApplicationService applicationService;
    @Autowired
    StorageService storageService;



    @GetMapping("/getAllApplication")
    List<Application> getAllApplications(){
        return applicationService.getAllApplications();
    }



    @PostMapping("/saveApplication")
    ResponseEntity<Response> saveApplication(@RequestParam(name = "file", required = false) MultipartFile file, @RequestParam(name = "file", required = false) MultipartFile pdf, @RequestParam String application){
        return applicationService.saveApplication(file,pdf, application);
    }


    @GetMapping("/getApplicationById/{id}")
    ResponseEntity<Optional<Application>> getApplicationById(@PathVariable Long id){
        return applicationService.getApplicationById(id);
    }


    @DeleteMapping("/deleteApplication/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Optional<Application>> deleteApplication(@PathVariable Long id){
        return applicationService.deleteApplication(id);
    }



   @GetMapping("/getApplicationByCategoryName/{application}")
    List<Application> getApplicationByApplicationName(@PathVariable String application){
        return applicationService.getApplicationByApplicationName(application);
    }



    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
