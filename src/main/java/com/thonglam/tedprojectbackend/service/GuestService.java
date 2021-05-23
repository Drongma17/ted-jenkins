package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Guest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GuestService {


    public List<Guest> getAllGuest();

    public ResponseEntity<Response> saveGuest(MultipartFile file, String guest);

    public ResponseEntity<Guest>  getOneGuest(int id);

    public ResponseEntity<Guest> deleteGuest(int id);

}
