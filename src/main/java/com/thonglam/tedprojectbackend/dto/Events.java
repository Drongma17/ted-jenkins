package com.thonglam.tedprojectbackend.dto;

import javax.persistence.*;

@Entity
@Table(name = "Events_table")
public class Events {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private String participants;
    private String eventDate;
    private String agenda;
    private String organiser;
    private String eventVanue;
    private String aboutEvent;
    private String fileName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }


    public String getEventVanue() {
        return eventVanue;
    }

    public void setEventVanue(String eventVanue) {
        this.eventVanue = eventVanue;
    }

    public String getAboutEvent() {
        return aboutEvent;
    }

    public void setAboutEvent(String aboutEvent) {
        this.aboutEvent = aboutEvent;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Events() {
    }


    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", participants='" + participants + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", agenda='" + agenda + '\'' +
                ", organiser='" + organiser + '\'' +
                ", eventVanue='" + eventVanue + '\'' +
                ", aboutEvent='" + aboutEvent + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
