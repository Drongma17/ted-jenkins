package com.thonglam.tedprojectbackend.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Announce;
import com.thonglam.tedprojectbackend.service.AnnounceService;
import com.thonglam.tedprojectbackend.service.StorageService;

@RestController
@RequestMapping(value = "/announcement")
public class AnnounceController {



    @Autowired
    private AnnounceService announceService;


    @Autowired
    private StorageService storageService;


    @GetMapping("/getAllAnnouncement")
    public List<Announce> getAnnounces(){
       return announceService.getAnnounces();
    }

    @PostMapping("/saveAnnouncement")
    public ResponseEntity<Response> saveAnnounce(@RequestParam(name = "file",required = false) MultipartFile file,
                                                 @RequestParam("announce") String announce){
        return announceService.saveAnnounce(file, announce);

    }


    @GetMapping("/getSingleAnnounce/{id}")
    public ResponseEntity<Announce> getAnnounce(@PathVariable int id){
       return announceService.getAnnounce(id);
    }




    @DeleteMapping("/deleteAnnounce/{id}")
    public ResponseEntity<Announce> deleteAnnounce(@PathVariable int id){
       return announceService.deleteAnnounce(id);
    }



    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }



}
