package com.thonglam.tedprojectbackend.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Gallery;

public interface GalleryService {

    public List<Gallery> getAllGallery();
    public ResponseEntity<Response> saveGallery(MultipartFile files, String gallery);
    public ResponseEntity<Gallery> getGallery(int id);
    public ResponseEntity<Gallery> deleteGallery(int id);

}
