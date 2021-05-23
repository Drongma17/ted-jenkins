package com.thonglam.tedprojectbackend.serviceimpl;


import com.thonglam.tedprojectbackend.dao.EntrepreneursDao;
import com.thonglam.tedprojectbackend.dto.Entrepreneurs;
import com.thonglam.tedprojectbackend.properties.StorageProperties;
import com.thonglam.tedprojectbackend.service.PreneurSerivice;
import com.thonglam.tedprojectbackend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PreneurImplimentation implements PreneurSerivice {


  @Autowired private EntrepreneursDao entrepreneursDao;
  @Autowired StorageService storageService;

  private final Path rootLocation;

    @Autowired
    public PreneurImplimentation(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public Entrepreneurs createEntrepreneur(MultipartFile file, Entrepreneurs entrepreneurs){

        if (file != null) {
            String filename=  storageService.store(file);
            entrepreneurs.setFileName(filename);
        }
        return entrepreneursDao.save(entrepreneurs);
    }
}
