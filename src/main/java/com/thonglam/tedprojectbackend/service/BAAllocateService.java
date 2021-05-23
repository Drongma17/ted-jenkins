package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.dto.BAAllocate;

import java.util.List;

public interface BAAllocateService {


    List<BAAllocate> getAllBAAllocates();
    BAAllocate addBAAllocateToBusinessac(Long businessacId, BAAllocate baAllocate);
    String deleteBAAllocate(Long businessacId, int bAAllocateId);
    List<BAAllocate> getALLBAAllocateByBusinessacId(Long businessacId);
    BAAllocate updateBAAllocateOfBusinessac(Long businessacId, int bAAlocateId, BAAllocate baAllocate);



}
