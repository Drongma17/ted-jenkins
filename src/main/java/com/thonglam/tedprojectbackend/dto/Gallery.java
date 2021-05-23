package com.thonglam.tedprojectbackend.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String photoName;
    private String subDescription;
    private String imageDate;
    private String galleryDescription;
    private String fileName;


    public int getId() {
        return id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }


    public String getSubDescription() {
        return subDescription;
    }

    public void setSubDescription(String subDescription) {
        this.subDescription = subDescription;
    }

    public String getGalleryDescription() {
        return galleryDescription;
    }

    public void setGalleryDescription(String galleryDescription) {
        this.galleryDescription = galleryDescription;
    }

    public String getImageDate() {
        return imageDate;
    }

    public void setImageDate(String imageDate) {
        this.imageDate = imageDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public String toString() {
        return "Gallery{" +
                "id=" + id +
                ", photoName='" + photoName + '\'' +
                ", subDescription='" + subDescription + '\'' +
                ", imageDate='" + imageDate + '\'' +
                ", galleryDescription='" + galleryDescription + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}