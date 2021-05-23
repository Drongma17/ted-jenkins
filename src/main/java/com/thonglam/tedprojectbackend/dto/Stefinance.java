package com.thonglam.tedprojectbackend.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "ste_finance")
public class Stefinance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String purpose;
    private double disburseAmount;
    private String disburseDate;
    private double grandTotal;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ste_id", nullable = false)
    @JsonIgnore
    public Ste ste;

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

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Ste getSte() {
        return ste;
    }

    public void setSte(Ste ste) {
        this.ste = ste;
    }


    @Override
    public String toString() {
        return "Stefinance{" +
                "id=" + id +
                ", purpose='" + purpose + '\'' +
                ", disburseAmount=" + disburseAmount +
                ", disburseDate='" + disburseDate + '\'' +
                ", grandTotal=" + grandTotal +
                '}';
    }
}
