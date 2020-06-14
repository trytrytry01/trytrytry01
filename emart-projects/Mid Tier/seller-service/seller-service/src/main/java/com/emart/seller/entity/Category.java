package com.emart.seller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description  
 * @Author  ljg
 * @Date 2020/05/05 
 */
@Entity
@Table ( name ="category")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class Category  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * category id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "category_id" )
	private Long categoryId;

	/**
	 * category name
	 */
   	@Column(name = "category_name" )
	private String categoryName;

	/**
	 * brief details
	 */
   	@Column(name = "brief_details" )
	private String briefDetails;
   	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBriefDetails() {
		return briefDetails;
	}

	public void setBriefDetails(String briefDetails) {
		this.briefDetails = briefDetails;
	}

//	public List<Item> getItems() {
//		return items;
//	}
//
//	public void setItems(List<Item> items) {
//		this.items = items;
//	}


}