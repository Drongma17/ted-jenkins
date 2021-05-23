package com.thonglam.tedprojectbackend.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "snow_bank")
public class SnowBank {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String customerName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String dateOfBirth;
    private String accountHolderName;
    private String accountNumber;
    private String ifscCode;
    private String sbCategoryName;
    private String batch;
    private Double lendAmount;
    private String lendDate;
    private Double totalReturned;
    private String returnDate;
    private String businessName;

    @Lob
    private String address;
    @Lob
    private String briefIntroduction;
    @Lob
    private String about;
    private String fileName;

    @OneToMany(mappedBy = "snowBank", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    Set<LendMoney> lendMonies;

    @OneToMany(mappedBy = "snowBank", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    Set<ReturnMoney> returnMonies;



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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getSbCategoryName() {
        return sbCategoryName;
    }

    public void setSbCategoryName(String sbCategoryName) {
        this.sbCategoryName = sbCategoryName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Double getLendAmount() {
        return lendAmount;
    }

    public void setLendAmount(Double lendAmount) {
        this.lendAmount = lendAmount;
    }

    public String getLendDate() {
        return lendDate;
    }

    public void setLendDate(String lendDate) {
        this.lendDate = lendDate;
    }

    public Double getTotalReturned() {
        return totalReturned;
    }

    public void setTotalReturned(Double totalReturned) {
        this.totalReturned = totalReturned;
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

    public Set<LendMoney> getLendMonies() {
        return lendMonies;
    }

    public void setLendMonies(Set<LendMoney> lendMonies) {
        this.lendMonies = lendMonies;
    }

    public Set<ReturnMoney> getReturnMonies() {
        return returnMonies;
    }

    public void setReturnMonies(Set<ReturnMoney> returnMonies) {
        this.returnMonies = returnMonies;
    }


    @Override
    public String toString() {
        return "SnowBank{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", sbCategoryName='" + sbCategoryName + '\'' +
                ", batch='" + batch + '\'' +
                ", lendAmount=" + lendAmount +
                ", lendDate='" + lendDate + '\'' +
                ", totalReturned=" + totalReturned +
                ", returnDate='" + returnDate + '\'' +
                ", businessName='" + businessName + '\'' +
                ", address='" + address + '\'' +
                ", briefIntroduction='" + briefIntroduction + '\'' +
                ", about='" + about + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
