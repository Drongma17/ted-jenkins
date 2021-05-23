package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Ehub;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface EhubService {

    List<Ehub> getAllEhub();
    ResponseEntity<Response> saveEhub(MultipartFile file, String ehub);
    ResponseEntity<Optional<Ehub>> getEhub(Long id);
    ResponseEntity<Optional<Ehub>> deleteEhub(Long id);
    List<Ehub> getEhubByehubCategoryName(String ehubCategoryName);


}
