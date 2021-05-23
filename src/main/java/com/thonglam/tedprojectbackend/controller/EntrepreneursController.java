package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Entrepreneurs;
import com.thonglam.tedprojectbackend.service.EntrepreneurService;
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
@CrossOrigin
@RequestMapping("/entrepreneurship")
public class EntrepreneursController {


    @Autowired private EntrepreneurService entrepreneurService;
    @Autowired private StorageService storageService;


    @PostMapping("/saveEntrepreneurProfile")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Response> saveEntrepreneurProfile(@RequestParam(name = "file",required = false) MultipartFile file,
                                                     @RequestParam("entrepre") String entrepre) {
       return entrepreneurService.saveEntrepreneur(file, entrepre);
    }


    @CrossOrigin
    @GetMapping("/entrepreneurs")
    public List<Entrepreneurs> findAll() {
        return entrepreneurService.getEntrepreneurs();
    }



    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Entrepreneurs> deleteEntrepreneur(@PathVariable(value = "id") Long Id) {
        return entrepreneurService.deleteEntrepreneur(Id);
    }


    @GetMapping("/getEntrepreneur/{id}")
    public ResponseEntity<Optional<Entrepreneurs>> getEntrepreneur(@PathVariable Long id) {
       return entrepreneurService.getEntrepreneur(id);
    }




    @GetMapping("/getByCategory/{categoryName}")
    public List<Entrepreneurs> listEntrepreneurByCategoryName(@PathVariable(name = "categoryName") String categoryName){
        return entrepreneurService.listEntrepreneurByCategoryName(categoryName);
    }


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }



}



