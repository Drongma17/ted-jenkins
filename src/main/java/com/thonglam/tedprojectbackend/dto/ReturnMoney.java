package com.thonglam.tedprojectbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "return_money")
public class ReturnMoney {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String purpose;
    private double returnAmount;
    private String returnDate;
    private double grandTotal;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "snowbank_id", nullable = false)
    @JsonIgnore
    SnowBank snowBank;


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

    public double getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(double returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public SnowBank getSnowBank() {
        return snowBank;
    }

    public void setSnowBank(SnowBank snowBank) {
        this.snowBank = snowBank;
    }

    @Override
    public String toString() {
        return "ReturnMoney{" +
                "id=" + id +
                ", purpose='" + purpose + '\'' +
                ", returnAmount=" + returnAmount +
                ", returnDate='" + returnDate + '\'' +
                ", grandTotal=" + grandTotal +
                '}';
    }
}
