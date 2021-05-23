package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.SnowBank;
import com.thonglam.tedprojectbackend.service.SnowBankService;
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
@RequestMapping("/snowbank")
public class SnowBankController {


    @Autowired
    SnowBankService snowBankService;
    @Autowired
    StorageService storageService;

     @GetMapping("/getAllSnowBank")
    List<SnowBank> getAllSnowBank(){
        return snowBankService.getAllSnowBank();
    }



    @PostMapping("/saveSnowBank")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Response> saveSnowBank(@RequestParam(name = "file", required = false) MultipartFile file,  @RequestParam String snowbank){
        return snowBankService.saveSnowBank(file, snowbank);
    }



     @GetMapping("/getSnowBank/{id}")
    ResponseEntity<Optional<SnowBank>> getSnowBank(@PathVariable Long id){
        return snowBankService.getSnowBank(id);
    }


   @DeleteMapping("/deleteSnowBank/{id}")
   @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Optional<SnowBank>> deleteSnowBank(@PathVariable Long id){
        return snowBankService.deleteSnowBank(id);
    }


   @GetMapping("/getSnowBankByCategory/{sbCategoryName}")
    List<SnowBank> getSnowBankSbCategoryName(@PathVariable(name = "sbCategoryName", required = false) String sbCategoryName){
        return snowBankService.getSnowBankSbCategoryName(sbCategoryName);
    }



    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }



}
