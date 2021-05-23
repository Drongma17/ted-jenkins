package com.thonglam.tedprojectbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "incubation_allocated")
public class IncubationAllot {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double allocatedAmount;
    private String purpose;
    private String description;
    private String allocatedDate;
    private Double allocatedSum;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entrepreneur_id", nullable = false)
    @JsonIgnore
    public Entrepreneurs entrepreneur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAllocatedAmount() {
        return allocatedAmount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setAllocatedAmount(Double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAllocatedDate() {
        return allocatedDate;
    }

    public void setAllocatedDate(String allocatedDate) {
        this.allocatedDate = allocatedDate;
    }

    public Double getAllocatedSum() {
        return allocatedSum;
    }

    public void setAllocatedSum(Double allocatedSum) {
        this.allocatedSum = allocatedSum;
    }

    public Entrepreneurs getEntrepreneur() {
        return entrepreneur;
    }

    public void setEntrepreneur(Entrepreneurs entrepreneur) {
        this.entrepreneur = entrepreneur;
    }


    @Override
    public String toString() {
        return "IncubationAllot{" +
                "id=" + id +
                ", allocatedAmount=" + allocatedAmount +
                ", purpose='" + purpose + '\'' +
                ", description='" + description + '\'' +
                ", allocatedDate='" + allocatedDate + '\'' +
                ", allocatedSum=" + allocatedSum +
                '}';
    }
}
