package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Ehub;
import com.thonglam.tedprojectbackend.service.EhubService;
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
@RequestMapping("/ehubProfile")
public class EhubController {


    @Autowired private EhubService ehubService;
    @Autowired private StorageService storageService;

    @GetMapping("/getAllEhubs")
    public List<Ehub> getAllEhub(){
        return ehubService.getAllEhub();
    }

    @PostMapping("/saveEhub")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response> saveEhub(@RequestParam(name = "file", required = false) MultipartFile file,  @RequestParam String ehub){
        return  ehubService.saveEhub(file, ehub);
    }



    @GetMapping("/getEhubById/{id}")
    public ResponseEntity<Optional<Ehub>> getEhub(@PathVariable Long id){
        return ehubService.getEhub(id);
    }


    @DeleteMapping("/deleteEhub/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Optional<Ehub>> deleteEhub(@PathVariable Long id){
        return ehubService.deleteEhub(id);
    }


    @GetMapping("/getEhubByCategoryName/{ehubCategoryName}")
    public List<Ehub> getEhubByehubCategoryName(@PathVariable(name ="ehubCategoryName", required = false) String ehubCategoryName){
        return ehubService.getEhubByehubCategoryName(ehubCategoryName);
    }


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
