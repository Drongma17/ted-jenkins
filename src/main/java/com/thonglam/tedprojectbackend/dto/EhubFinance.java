package com.thonglam.tedprojectbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ehub_finance")
public class EhubFinance {

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
    @JoinColumn(name = "ehub_id", nullable = false)
    @JsonIgnore
    private Ehub ehub;


    public EhubFinance() {
    }


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

    public Ehub getEhub() {
        return ehub;
    }

    public void setEhub(Ehub ehub) {
        this.ehub = ehub;
    }


    @Override
    public String toString() {
        return "EhubFinance{" +
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
