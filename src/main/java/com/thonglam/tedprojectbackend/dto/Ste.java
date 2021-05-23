package com.thonglam.tedprojectbackend.dto;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Ste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String steName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String dateOfBirth;
    private String steCategoryName;
    private String batch;
    private Double allocatedAmount;
    private String allocateDate;
    private Double totalDisbursed;
    private String businessName;

    @Lob
    private String briefIntroduction;

    @Lob
    private String address;

    @Lob
    private String about;
    private String fileName;


    @OneToMany(mappedBy = "ste", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    public Set<Stefinance> stefinances;


    @OneToMany(mappedBy = "ste", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    public Set<SteAllocate> steAllocates;


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

    public String getSteName() {
        return steName;
    }

    public void setSteName(String steName) {
        this.steName = steName;
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

    public String getSteCategoryName() {
        return steCategoryName;
    }

    public void setSteCategoryName(String steCategoryName) {
        this.steCategoryName = steCategoryName;
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

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Set<Stefinance> getStefinances() {
        return stefinances;
    }

    public void setStefinances(Set<Stefinance> stefinances) {
        this.stefinances = stefinances;
    }

    public Set<SteAllocate> getSteAllocates() {
        return steAllocates;
    }

    public void setSteAllocates(Set<SteAllocate> steAllocates) {
        this.steAllocates = steAllocates;
    }


    @Override
    public String toString() {
        return "Ste{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", steName='" + steName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", steCategoryName='" + steCategoryName + '\'' +
                ", batch='" + batch + '\'' +
                ", allocatedAmount=" + allocatedAmount +
                ", allocateDate='" + allocateDate + '\'' +
                ", totalDisbursed=" + totalDisbursed +
                ", businessName='" + businessName + '\'' +
                ", briefIntroduction='" + briefIntroduction + '\'' +
                ", address='" + address + '\'' +
                ", about='" + about + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
