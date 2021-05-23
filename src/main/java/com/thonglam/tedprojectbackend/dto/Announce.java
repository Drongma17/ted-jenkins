package com.thonglam.tedprojectbackend.dto;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Announce {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String date;
    @Size(max = 500)
    private String subject;
    @Lob
    private String body;

    private String fileName;


    public Announce() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public String toString() {
        return "Announce{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
