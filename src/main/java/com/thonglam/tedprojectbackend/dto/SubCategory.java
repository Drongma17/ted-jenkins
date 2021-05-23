package com.thonglam.tedprojectbackend.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sub_category")
public class SubCategory implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String subCategoryName;

    private String subCategoryDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category")
    private SubCategory subCategory;


    public SubCategory getSubCategory() {
        return null;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategoryDescription() {
        return subCategoryDescription;
    }

    public void setSubCategoryDescription(String subCategoryDescription) {
        this.subCategoryDescription = subCategoryDescription;
    }


    @Override
    public String toString() {
        return "Subcategory{" +
                "id=" + id +
                ", subCategoryName='" + subCategoryName + '\'' +
                ", subCategoryDescription='" + subCategoryDescription + '\'' +
                '}';
    }
}
