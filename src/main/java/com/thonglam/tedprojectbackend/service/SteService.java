package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Ste;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface SteService {

    List<Ste> getAllSte();
    ResponseEntity<Response> saveSte(MultipartFile file, String ste);
    ResponseEntity<Optional<Ste>> getSte(Long id);
    ResponseEntity<Optional<Ste>> deleteSte(Long id);
    List<Ste> getSteBySteCategoryName(String steCategoryName);
}
