package com.thonglam.tedprojectbackend.service;

import java.util.List;

import com.thonglam.tedprojectbackend.dto.IncubationAllot;

public interface IncubationallotService  {


    List<IncubationAllot> getAllIncubationallot();
    IncubationAllot addAllotToEntrepreneur(Long entrepreneurId, IncubationAllot incubationAllot);
    List<IncubationAllot> getAllByEntrepreneurId(Long entrepreneurId);
    public String deleteIncubationAllot(Long entrepreneurId, int incubationallotId);
    public IncubationAllot updateIncubationAllot(Long entrepreneurId, int incubationallotId, IncubationAllot incubationAllot);
}
