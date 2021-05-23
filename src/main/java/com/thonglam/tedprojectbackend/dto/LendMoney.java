package com.thonglam.tedprojectbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "lend_money")
public class LendMoney {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String purpose;
    private Double lendAmount;
    private String lendDate;
    private String description;
    private Double lendSum;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "snowBank_id", nullable = false)
    @JsonIgnore
    SnowBank snowBank;

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

    public Double getLendAmount() {
        return lendAmount;
    }

    public void setLendAmount(Double lendAmount) {
        this.lendAmount = lendAmount;
    }

    public String getLendDate() {
        return lendDate;
    }

    public void setLendDate(String lendDate) {
        this.lendDate = lendDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLendSum() {
        return lendSum;
    }

    public void setLendSum(Double lendSum) {
        this.lendSum = lendSum;
    }

    public SnowBank getSnowBank() {
        return snowBank;
    }

    public void setSnowBank(SnowBank snowBank) {
        this.snowBank = snowBank;
    }

    @Override
    public String toString() {
        return "LendMoney{" +
                "id=" + id +
                ", purpose='" + purpose + '\'' +
                ", lendAmount=" + lendAmount +
                ", lendDate='" + lendDate + '\'' +
                ", description='" + description + '\'' +
                ", lendSum=" + lendSum +
                '}';
    }
}
