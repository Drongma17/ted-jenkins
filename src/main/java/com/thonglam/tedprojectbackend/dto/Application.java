package com.thonglam.tedprojectbackend.dto;


import javax.persistence.*;

@Entity
@Table(name = "application_form")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String applicantName;
    private String email;
    private String phoneNumber;
    private String categoryName;
    private String gender;
    private String dateOfBirth;
    private String purpose;
    private String businessName;
    private String greenbook;
    @Lob
    private String pdf;
    @Lob
    private String address;
    @Lob
    private String about;
    private String fileName;


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

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getGreenbook() {
        return greenbook;
    }

    public void setGreenbook(String greenbook) {
        this.greenbook = greenbook;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", applicantName='" + applicantName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", purpose='" + purpose + '\'' +
                ", businessName='" + businessName + '\'' +
                ", greenbook='" + greenbook + '\'' +
                ", address='" + address + '\'' +
                ", about='" + about + '\'' +
                ", pdf='" + pdf + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
