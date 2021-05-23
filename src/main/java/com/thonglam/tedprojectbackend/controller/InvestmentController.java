package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Investment;
import com.thonglam.tedprojectbackend.service.InvestmentService;
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
@RequestMapping("/investment")
public class InvestmentController {

    @Autowired InvestmentService investmentService;
    @Autowired StorageService storageService;

    @GetMapping("/getAllInvestment")
    List<Investment> getAllInvestment(){
         return investmentService.getAllInvestment();
    }


    @PostMapping("/saveInvestment")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Response> saveInvestment(@RequestParam(name = "file", required = false) MultipartFile file, @RequestParam String investment){
        return investmentService.saveInvestment(file, investment);
    }



    @GetMapping("/getInvestment/{id}")
    public ResponseEntity<Optional<Investment>> getInvestment(@PathVariable Long id) {
        return investmentService.getInvestment(id);
    }


    @DeleteMapping("/deleteInvestement/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Optional<Investment>> deleteInvestment(@PathVariable Long id){
        return investmentService.deleteInvestment(id);
    }


    @GetMapping("/getInvestmentByCategory/{investmentCategory}")
    public List<Investment> getInvestmentByInvestmentCategory(@PathVariable(name = "investmentCategory", required = false) String investmentCategory){
        return investmentService.getInvestmentByInvestmentCategory(investmentCategory);
    }



    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

}
