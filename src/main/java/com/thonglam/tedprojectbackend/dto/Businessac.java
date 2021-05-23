package com.thonglam.tedprojectbackend.dto;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Businessac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String businessacName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String dateOfBirth;
    private String baCategoryName;
    private String batch;
    private Double allocatedAmount;
    private String allocateDate;
    private Double totalDisbursed;
    private String businessName;

    @Lob
    private String address;
    @Lob
    private String briefIntroduction;
    @Lob
    private String about;
    private String fileName;


    @OneToMany(mappedBy = "businessac", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    public Set<Businessacfinance> businessacfinances;

    @OneToMany(mappedBy = "businessac", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    public Set<BAAllocate> baAllocates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBusinessacName() {
        return businessacName;
    }

    public void setBusinessacName(String businessacName) {
        this.businessacName = businessacName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBaCategoryName() {
        return baCategoryName;
    }

    public void setBaCategoryName(String baCategoryName) {
        this.baCategoryName = baCategoryName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Double getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(Double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public String getAllocateDate() {
        return allocateDate;
    }

    public void setAllocateDate(String allocateDate) {
        this.allocateDate = allocateDate;
    }

    public Double getTotalDisbursed() {
        return totalDisbursed;
    }

    public void setTotalDisbursed(Double totalDisbursed) {
        this.totalDisbursed = totalDisbursed;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Set<Businessacfinance> getBusinessacfinances() {
        return businessacfinances;
    }

    public void setBusinessacfinances(Set<Businessacfinance> businessacfinances) {
        this.businessacfinances = businessacfinances;
    }

    public Set<BAAllocate> getBaAllocates() {
        return baAllocates;
    }

    public void setBaAllocates(Set<BAAllocate> baAllocates) {
        this.baAllocates = baAllocates;
    }


    @Override
    public String toString() {
        return "Businessac{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", businessacName='" + businessacName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", baCategoryName='" + baCategoryName + '\'' +
                ", batch='" + batch + '\'' +
                ", allocatedAmount=" + allocatedAmount +
                ", allocateDate='" + allocateDate + '\'' +
                ", totalDisbursed=" + totalDisbursed +
                ", businessName='" + businessName + '\'' +
                ", address='" + address + '\'' +
                ", briefIntroduction='" + briefIntroduction + '\'' +
                ", about='" + about + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
