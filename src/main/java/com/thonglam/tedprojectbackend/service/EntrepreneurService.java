package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Entrepreneurs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Optional;

public interface EntrepreneurService {


    public List<Entrepreneurs> getEntrepreneurs();

    public ResponseEntity<Response> saveEntrepreneur(MultipartFile file, String entre);

    public ResponseEntity<Optional<Entrepreneurs>> getEntrepreneur(Long id);

    public ResponseEntity<Entrepreneurs> deleteEntrepreneur(Long id);

    public void entrepreneurStorage(MultipartFile file);

    public List<Entrepreneurs> listEntrepreneurByCategoryName(String categoryName);

}
