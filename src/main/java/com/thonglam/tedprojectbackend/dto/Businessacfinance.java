package com.thonglam.tedprojectbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "businessac_finance")
public class Businessacfinance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String purpose;
    private double disburseAmount;
    private String disburseDate;
    private double allocatedAmount;
    private double grandTotal;
    private String allocatedDate;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "businessac_id", nullable = false)
    @JsonIgnore
    private Businessac businessac;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public double getDisburseAmount() {
        return disburseAmount;
    }

    public void setDisburseAmount(double disburseAmount) {
        this.disburseAmount = disburseAmount;
    }

    public String getDisburseDate() {
        return disburseDate;
    }

    public void setDisburseDate(String disburseDate) {
        this.disburseDate = disburseDate;
    }

    public double getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getAllocatedDate() {
        return allocatedDate;
    }

    public void setAllocatedDate(String allocatedDate) {
        this.allocatedDate = allocatedDate;
    }

    public Businessac getBusinessac() {
        return businessac;
    }

    public void setBusinessac(Businessac businessac) {
        this.businessac = businessac;
    }


    @Override
    public String toString() {
        return "Businessacfinance{" +
                "id=" + id +
                ", purpose='" + purpose + '\'' +
                ", disburseAmount=" + disburseAmount +
                ", disburseDate='" + disburseDate + '\'' +
                ", allocatedAmount=" + allocatedAmount +
                ", grandTotal=" + grandTotal +
                ", allocatedDate='" + allocatedDate + '\'' +
                '}';
    }
}
