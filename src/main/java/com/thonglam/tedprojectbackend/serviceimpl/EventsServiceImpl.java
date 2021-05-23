package com.thonglam.tedprojectbackend.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.thonglam.tedprojectbackend.dao.EventRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Events;
import com.thonglam.tedprojectbackend.exception.StorageException;
import com.thonglam.tedprojectbackend.properties.StorageProperties;
import com.thonglam.tedprojectbackend.service.EventsService;
import com.thonglam.tedprojectbackend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;


@Service("eventsService")
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    StorageService storageService;

    private final Path rootLocation;

    @Autowired
    public EventsServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }


    @Override
    public List<Events> getAllEvents() {
        return eventRepository.findAll();
    }


    @Override
    public ResponseEntity<Response> saveEvent(MultipartFile file, String event) {
        Events events=null;
        try {
            events = new ObjectMapper().readValue(event, Events.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (file != null) {
            String filename=  storageService.store(file);
            events.setFileName(filename);
        }


        Events eventsDB = eventRepository.save(events);
        if (eventsDB != null) {
            return new ResponseEntity<Response>(new Response("File upload is successfull"), HttpStatus.OK);
        }
        return new ResponseEntity<Response>(new Response("File Upload is false"), HttpStatus.BAD_REQUEST);
    }




    @Override
    public ResponseEntity<Events> getOneEvent(Long id) {
        Events event =eventRepository.getOne(id);
        if(event ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(event);
    }

    @Override
    public ResponseEntity<Events> deleteEvent(Long id) {
        Events event =eventRepository.getOne(id);
        if(event ==null){
            return ResponseEntity.notFound().build();
        }
        eventRepository.delete(event);
        return ResponseEntity.ok().build();
    }



    @Override
    public String eventStorage(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                filename = "EVN" + UUID.randomUUID().toString();
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
        return filename;
    }
}
