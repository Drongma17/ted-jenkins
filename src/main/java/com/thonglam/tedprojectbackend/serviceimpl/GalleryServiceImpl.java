package com.thonglam.tedprojectbackend.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.thonglam.tedprojectbackend.dao.GalleryRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Gallery;
import com.thonglam.tedprojectbackend.properties.StorageProperties;
import com.thonglam.tedprojectbackend.service.GalleryService;
import com.thonglam.tedprojectbackend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service("galleryService")
public class GalleryServiceImpl implements GalleryService {

    private final Path rootLocation;

    @Autowired
    public GalleryServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }


    @Autowired
    GalleryRepository galleryRepository;

    @Autowired
    StorageService storageService;

    @Override
    public List<Gallery> getAllGallery() {
        return galleryRepository.findAll();
    }

    @Override
    public ResponseEntity<Response> saveGallery(MultipartFile file, String gallery) {
        Gallery gallery1 = null;
        try {
            gallery1 = new ObjectMapper().readValue(gallery, Gallery.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

            if (file != null) {
               String filename=  storageService.store(file);
                gallery1.setFileName(filename);
            }

            Gallery galleryDb = galleryRepository.save(gallery1);
            if (galleryDb != null) {
                return new ResponseEntity<Response>(new Response("File upload is successfull"), HttpStatus.OK);
            }

            return new ResponseEntity<Response>(new Response("File Upload is false"), HttpStatus.BAD_REQUEST);
        }


    @Override
    public ResponseEntity<Gallery> getGallery(int id) {
        Gallery singleGallery = galleryRepository.getOne(id);
        if (singleGallery == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(singleGallery);
    }

    @Override
    public ResponseEntity<Gallery> deleteGallery(int id) {
        Gallery gallery = galleryRepository.getOne(id);
        if (gallery == null) {
            ResponseEntity.notFound().build();
        }
        galleryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
