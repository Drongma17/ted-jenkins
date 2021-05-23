package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Businessac;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface BusinessacService {

    List<Businessac> getAllBusinessac() ;
    ResponseEntity<Response> saveBusinessac(MultipartFile file, String businessac);
    ResponseEntity<Optional<Businessac>> getBusinessaById(Long id);
    ResponseEntity<Optional<Businessac>> deleteBusinessac(Long id);
    List<Businessac> getBusinessacBybaCategoryName(String baCategoryName);
}
