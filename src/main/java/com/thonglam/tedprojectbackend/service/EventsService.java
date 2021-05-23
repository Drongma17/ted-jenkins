package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Events;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EventsService {


    public List<Events> getAllEvents();
    public ResponseEntity<Response> saveEvent(MultipartFile file, String event);
    public ResponseEntity<Events> getOneEvent(Long id);
    public ResponseEntity<Events> deleteEvent(Long id);
    String eventStorage(MultipartFile file);


}
