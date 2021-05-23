package com.thonglam.tedprojectbackend.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ba_allocate")
public class BAAllocate {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String purpose;
    private Double allocateAmount;
    private String allocateDate;
    private String description;
    private Double allocateSum;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "businessac_id", nullable = false)
    @JsonIgnore
    Businessac businessac;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Double getAllocateAmount() {
        return allocateAmount;
    }

    public void setAllocateAmount(Double allocateAmount) {
        this.allocateAmount = allocateAmount;
    }

    public String getAllocateDate() {
        return allocateDate;
    }

    public void setAllocateDate(String allocateDate) {
        this.allocateDate = allocateDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAllocateSum() {
        return allocateSum;
    }

    public void setAllocateSum(Double allocateSum) {
        this.allocateSum = allocateSum;
    }

    public Businessac getBusinessac() {
        return businessac;
    }

    public void setBusinessac(Businessac businessac) {
        this.businessac = businessac;
    }


    @Override
    public String toString() {
        return "BAAllocate{" +
                "id=" + id +
                ", purpose='" + purpose + '\'' +
                ", allocateAmount=" + allocateAmount +
                ", allocateDate='" + allocateDate + '\'' +
                ", description='" + description + '\'' +
                ", allocateSum=" + allocateSum +
                '}';
    }
}
