package com.thonglam.tedprojectbackend.serviceimpl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thonglam.tedprojectbackend.dao.ApplicationRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Application;
import com.thonglam.tedprojectbackend.properties.StorageProperties;
import com.thonglam.tedprojectbackend.service.ApplicationService;
import com.thonglam.tedprojectbackend.service.StorageService;


@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {


    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    StorageService storageService;


    private final Path location;

    @Autowired
    public ApplicationServiceImpl(StorageProperties properties) {
        this.location = Paths.get(properties.getLocation());
    }


    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }



    @Override
    public ResponseEntity<Response> saveApplication(MultipartFile file, MultipartFile pdf, String application) {
        Application application1 =null;
        try {
            application1 =new ObjectMapper().readValue(application, Application.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(file !=null){
           String fileName = storageService.store(file);
           application1.setFileName(fileName);
        }

        if(pdf !=pdf){
            String pdfName=storageService.store(pdf);
        }


        Application applicationDb=applicationRepository.save(application1);
        if(applicationDb !=null) {
            return new ResponseEntity(new Response("Application is saved successfully"), HttpStatus.OK);
        }
        return new ResponseEntity(new Response("Application is not able to save"), HttpStatus.BAD_REQUEST);
    }





    @Override
    public ResponseEntity<Optional<Application>> getApplicationById(Long id) {
        Optional<Application> application= applicationRepository.findById(id);
        if(application ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(application);
    }





    @Override
    public ResponseEntity<Optional<Application>> deleteApplication(Long id) {
        Optional<Application> application  =  applicationRepository.findById(id);
        if(application ==null){
            return ResponseEntity.notFound().build();
        }
        applicationRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }




    @Override
    public List<Application> getApplicationByApplicationName(String application) {
        return applicationRepository.getApplicationByCategoryName(application);
    }
}
