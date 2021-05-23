package com.thonglam.tedprojectbackend.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "investment_allocate")
public class InvestmentAllocate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String purpose;
    private Double allocatedAmount;
    private String allocateDate;
    private String description;
    private Double allocatedSum;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "investment_id", nullable = false)
    @JsonIgnore
    Investment investment;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAllocatedSum() {
        return allocatedSum;
    }

    public void setAllocatedSum(Double allocatedSum) {
        this.allocatedSum = allocatedSum;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }


    @Override
    public String toString() {
        return "InvestmentAllocate{" +
                "id=" + id +
                ", purpose='" + purpose + '\'' +
                ", allocatedAmount=" + allocatedAmount +
                ", allocateDate='" + allocateDate + '\'' +
                ", description='" + description + '\'' +
                ", allocatedSum=" + allocatedSum +
                '}';
    }
}
