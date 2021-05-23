package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.dto.Entrepreneurs;
import org.springframework.web.multipart.MultipartFile;

public interface PreneurSerivice {


    public Entrepreneurs createEntrepreneur(MultipartFile file, Entrepreneurs entrepreneurs);
}
