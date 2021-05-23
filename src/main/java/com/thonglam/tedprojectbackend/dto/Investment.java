package com.thonglam.tedprojectbackend.dto;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String investmentName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String dateOfBirth;
    private String investmentCategory;
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

    @OneToMany(mappedBy = "investment", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<InvestmentFinance> investmentFinance;


    @OneToMany(mappedBy = "investment", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<InvestmentAllocate> investmentAllocates;



    public Investment() {
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

    public String getInvestmentName() {
        return investmentName;
    }

    public void setInvestmentName(String investmentName) {
        this.investmentName = investmentName;
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

    public String getInvestmentCategory() {
        return investmentCategory;
    }

    public void setInvestmentCategory(String investmentCategory) {
        this.investmentCategory = investmentCategory;
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

    public Set<InvestmentFinance> getInvestmentFinance() {
        return investmentFinance;
    }

    public void setInvestmentFinance(Set<InvestmentFinance> investmentFinance) {
        this.investmentFinance = investmentFinance;
    }

    public Set<InvestmentAllocate> getInvestmentAllocates() {
        return investmentAllocates;
    }

    public void setInvestmentAllocates(Set<InvestmentAllocate> investmentAllocates) {
        this.investmentAllocates = investmentAllocates;
    }


    @Override
    public String toString() {
        return "Investment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", investmentName='" + investmentName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", investmentCategory='" + investmentCategory + '\'' +
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
