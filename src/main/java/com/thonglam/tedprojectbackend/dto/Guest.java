package com.thonglam.tedprojectbackend.dto;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Guest implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String highestDegree;
    private String topicToSpeck;
    private String speakingDate;

    @Lob
    private String bioData;
    private String fileName;



    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getTopicToSpeck() {
        return topicToSpeck;
    }

    public void setTopicToSpeck(String topicToSpeck) {
        this.topicToSpeck = topicToSpeck;
    }

    public String getSpeakingDate() {
        return speakingDate;
    }

    public void setSpeakingDate(String speakingDate) {
        this.speakingDate = speakingDate;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    public String getBioData() {
        return bioData;
    }

    public void setBioData(String bioData) {
        this.bioData = bioData;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }



    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", highestDegree='" + highestDegree + '\'' +
                ", topicToSpeck='" + topicToSpeck + '\'' +
                ", speakingDate='" + speakingDate + '\'' +
                ", bioData='" + bioData + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
