package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.domain.Response;
import com.thonglam.tedprojectbackend.dto.SnowBank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface SnowBankService {

    List<SnowBank> getAllSnowBank();
    ResponseEntity<Response> saveSnowBank(MultipartFile file, String snowbank);
    ResponseEntity<Optional<SnowBank>> getSnowBank(Long id);
    ResponseEntity<Optional<SnowBank>> deleteSnowBank(Long id);
    List<SnowBank> getSnowBankSbCategoryName(String sbCategoryName);
}
