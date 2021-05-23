package com.thonglam.tedprojectbackend.dto;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Ehub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String ehubName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String dateOfBirth;
    private String ehubCategoryName;
    private String batch;
    private Double allocatedAmount;
    private String allocateDate;
    private Double totalDisbursed;
    private String businessName;

    @Lob
    private String address;
    @Lob
    private String about;
    private String fileName;

    public Ehub() {
    }


    @OneToMany(mappedBy = "ehub", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    public Set<EhubFinance> ehubFinance;


    @OneToMany(mappedBy = "ehub", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    public Set<EhubAllocate> ehubAllocates;


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

    public String getEhubName() {
        return ehubName;
    }

    public void setEhubName(String ehubName) {
        this.ehubName = ehubName;
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

    public String getEhubCategoryName() {
        return ehubCategoryName;
    }

    public void setEhubCategoryName(String ehubCategoryName) {
        this.ehubCategoryName = ehubCategoryName;
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

    public Set<EhubFinance> getEhubFinance() {
        return ehubFinance;
    }

    public void setEhubFinance(Set<EhubFinance> ehubFinance) {
        this.ehubFinance = ehubFinance;
    }

    public Set<EhubAllocate> getEhubAllocates() {
        return ehubAllocates;
    }

    public void setEhubAllocates(Set<EhubAllocate> ehubAllocates) {
        this.ehubAllocates = ehubAllocates;
    }

    @Override
    public String toString() {
        return "Ehub{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ehubName='" + ehubName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", ehubCategoryName='" + ehubCategoryName + '\'' +
                ", batch='" + batch + '\'' +
                ", allocatedAmount=" + allocatedAmount +
                ", allocateDate='" + allocateDate + '\'' +
                ", totalDisbursed=" + totalDisbursed +
                ", businessName='" + businessName + '\'' +
                ", address='" + address + '\'' +
                ", about='" + about + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
