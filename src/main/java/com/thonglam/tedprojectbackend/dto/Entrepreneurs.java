package com.thonglam.tedprojectbackend.dto;


import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name="Entrepreneur")
public class Entrepreneurs  implements Serializable {

    private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String entrepreneurName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String dateOfBirth;
    private String categoryName;
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


    @OneToMany(mappedBy = "entrepreneur", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    public Set<Finance> finances;


    @OneToMany(mappedBy = "entrepreneur", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    public Set<IncubationAllot> incubationAllots;

    public Entrepreneurs() {
    }

    public Entrepreneurs(String title, String entrepreneurName, String email, String phoneNumber, String gender, String dateOfBirth, String categoryName, String batch, Double allocatedAmount, String allocateDate, Double totalDisbursed, String businessName, String address, String about, String fileName) {
        this.title = title;
        this.entrepreneurName = entrepreneurName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.categoryName = categoryName;
        this.batch = batch;
        this.allocatedAmount = allocatedAmount;
        this.allocateDate = allocateDate;
        this.totalDisbursed = totalDisbursed;
        this.businessName = businessName;
        this.address = address;
        this.about = about;
        this.fileName = fileName;
    }


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

    public String getEntrepreneurName() {
        return entrepreneurName;
    }

    public void setEntrepreneurName(String entrepreneurName) {
        this.entrepreneurName = entrepreneurName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public Set<Finance> getFinances() {
        return finances;
    }

    public void setFinances(Set<Finance> finances) {
        this.finances = finances;
    }

    public Set<IncubationAllot> getIncubationAllots() {
        return incubationAllots;
    }

    public void setIncubationAllots(Set<IncubationAllot> incubationAllots) {
        this.incubationAllots = incubationAllots;
    }


    @Override
    public String toString() {
        return "Entrepreneurs{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", entrepreneurName='" + entrepreneurName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", batch='" + batch + '\'' +
                ", allocatedAmount=" + allocatedAmount +
                ", allocateDate='" + allocateDate + '\'' +
                ", totalDisbursed=" + totalDisbursed +
                ", businessName='" + businessName + '\'' +
                ", address='" + address + '\'' +
                ", briefIntroduction='" + briefIntroduction + '\'' +
                ", about='" + about + '\'' +
                ", fileName='" + fileName + '\'' +
                ", finances=" + finances +
                '}';
    }
}