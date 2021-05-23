package com.thonglam.tedprojectbackend.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;



import com.thonglam.tedprojectbackend.dao.EntrepreneursDao;
import com.thonglam.tedprojectbackend.dao.FinanceRepository;
import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.Entrepreneurs;
import com.thonglam.tedprojectbackend.exception.StorageException;
import com.thonglam.tedprojectbackend.properties.StorageProperties;
import com.thonglam.tedprojectbackend.service.EntrepreneurService;
import com.thonglam.tedprojectbackend.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.*;

@Service("entrepreneurService")
public class EntrepreneurServiceImp implements EntrepreneurService {

    private static Logger LOGGER = LoggerFactory.getLogger(EntrepreneurServiceImp.class);

    @Autowired EntrepreneursDao entrepreneursDao;
    @Autowired StorageService storageService;
    @Autowired FinanceRepository financeRepository;


    private final Path rootLocation;

    @Autowired
    public EntrepreneurServiceImp(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }




    @Override
    public List<Entrepreneurs> getEntrepreneurs() {
        return entrepreneursDao.findAll();
    }


    @Override
    public ResponseEntity<Response> saveEntrepreneur(MultipartFile file, String entrepre) {
        Entrepreneurs entrepreneurs = null;
        try {
            entrepreneurs = new ObjectMapper().readValue(entrepre, Entrepreneurs.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (file != null) {
            String filename=  storageService.store(file);
            entrepreneurs.setFileName(filename);
        }

        Entrepreneurs entrepreneurDb = entrepreneursDao.save(entrepreneurs);
        if (entrepreneurDb != null) {
            return new ResponseEntity<Response>(new Response("File upload is successfull"), HttpStatus.OK);
        }
        return new ResponseEntity<Response>(new Response("File Upload is false"), HttpStatus.BAD_REQUEST);
    }



    @Override
    public void entrepreneurStorage(MultipartFile file) {
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
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }




    @Override
    public ResponseEntity<Optional<Entrepreneurs>> getEntrepreneur(Long id) {
        Optional<Entrepreneurs> singleEntrepreneur = entrepreneursDao.findById(id);
        if (singleEntrepreneur == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(singleEntrepreneur);
    }


    @Override
    public ResponseEntity<Entrepreneurs> deleteEntrepreneur(Long id) {
        Optional<Entrepreneurs> emp = entrepreneursDao.findById(id);
        if (emp == null) {
            ResponseEntity.notFound().build();
        }
        entrepreneursDao.deleteById(id);
        return ResponseEntity.ok().build();
    }



    @Override
    public List<Entrepreneurs> listEntrepreneurByCategoryName(String categoryName) {
        return entrepreneursDao.getEntrepreneursByCategoryName(categoryName);
    }

}