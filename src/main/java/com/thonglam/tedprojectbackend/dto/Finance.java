package com.thonglam.tedprojectbackend.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Finance implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String purpose;
    private double disburseAmount;
    private String disburseDate;
    private double allocatedAmount;
    private double grandTotal;
    private String allocatedDate;



    public Finance() {
    }



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entrepreneur_id", nullable = false)
    @JsonIgnore
    public Entrepreneurs entrepreneur;


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

    public Entrepreneurs getEntrepreneur() {
        return entrepreneur;
    }

    public void setEntrepreneur(Entrepreneurs entrepreneur) {
        this.entrepreneur = entrepreneur;
    }


    @Override
    public String toString() {
        return "Finance{" +
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
