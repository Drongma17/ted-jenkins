package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.dto.EhubAllocate;

import java.util.List;

public interface EhubAllocateService {


    List<EhubAllocate> getAllEhubAllocates();
    EhubAllocate addEhubAllocate(Long ehubId, EhubAllocate ehubAllocate);
    List<EhubAllocate> getEhubAllocatesByEhubId(Long ehubId);
    String deleteEhubAllocate(Long ehubId, int ehuballocateId);
    EhubAllocate updateEhubAllocate(Long ehubId, int ehuballocateId, EhubAllocate ehubAllocate);

}
