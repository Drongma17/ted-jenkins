package com.thonglam.tedprojectbackend.service;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Announce;

public interface AnnounceService {


    public List<Announce> getAnnounces();

    public ResponseEntity<Response> saveAnnounce(MultipartFile file, String announce);

    public ResponseEntity<Announce> getAnnounce(int id);

    public ResponseEntity<Announce> deleteAnnounce(int id);


}
