package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Gallery;
import com.thonglam.tedprojectbackend.service.GalleryService;
import com.thonglam.tedprojectbackend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RequestMapping("/galleryProfile")
@RestController
public class GalleryController {


  @Autowired
  private GalleryService galleryService;

    @Autowired
    private StorageService storageService;

   @GetMapping("/getAllImages")
    public List<Gallery> getAllGallery(){
      return galleryService.getAllGallery();
    }

    @PostMapping("/saveImage")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response> saveGallery(@RequestParam(name = "file", required = false)  MultipartFile file, String gallery){
        return galleryService.saveGallery(file, gallery);
    }

     @GetMapping("/getOnePhoto")
    public ResponseEntity<Gallery> getGallery(int id){
     return galleryService.getGallery(id);
    }


    @DeleteMapping("/deleteImage/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Gallery> deleteGallery(@PathVariable int id){
    return galleryService.deleteGallery(id);
    }



    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}