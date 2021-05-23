package com.thonglam.tedprojectbackend.service;


import com.thonglam.tedprojectbackend.dto.SteAllocate;

import java.util.List;

public interface SteAllocateService {

    List<SteAllocate> getAllSteAllocates();
    SteAllocate addSteAllocate(Long steId, SteAllocate steAllocate);
    List<SteAllocate> getSteAllocatesBySteId(Long steId);
    String deleteSteAllocate(Long steId, int steallocateId);
    SteAllocate updateSteAllocate(Long steId, int steallocateId, SteAllocate steAllocate);


}
