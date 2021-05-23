package com.thonglam.tedprojectbackend.controller;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Events;
import com.thonglam.tedprojectbackend.service.EventsService;
import com.thonglam.tedprojectbackend.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/events")
public class EventsController {

    private static final Logger LOGGER=LoggerFactory.getLogger(EventsController.class);

    @Autowired
    private StorageService storageService;

    @Autowired
    private EventsService eventsService;


    @GetMapping("/allEvents")
    public List<Events> getAllEvents(){
        return eventsService.getAllEvents();
    }



    @PostMapping("/saveEvent")
    @PreAuthorize("hasRole('ADMIN')")
   public ResponseEntity<Response> saveEvent(@RequestParam(value = "file", required = false) MultipartFile file,
                                             @RequestParam(value = "event") String event)throws Exception{
        LOGGER.info("POSTING INTO DATABASES"+event);
        return eventsService.saveEvent(file, event);
   }



   @GetMapping("getOneEvent/{id}")
    public ResponseEntity<Events> getOneEvent(@PathVariable Long id){
          return eventsService.getOneEvent(id);
    }


    @DeleteMapping("/deleteEvent/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Events> deleteEvent(@PathVariable Long id){
     return eventsService.deleteEvent(id);
    }




    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


}
