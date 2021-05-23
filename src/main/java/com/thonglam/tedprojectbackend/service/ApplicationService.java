package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Application;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {


    List<Application> getAllApplications() ;
    ResponseEntity<Response> saveApplication(MultipartFile file, MultipartFile pdf, String application);
    ResponseEntity<Optional<Application>> getApplicationById(Long id);
    ResponseEntity<Optional<Application>> deleteApplication(Long id);
    List<Application> getApplicationByApplicationName(String application);
}
