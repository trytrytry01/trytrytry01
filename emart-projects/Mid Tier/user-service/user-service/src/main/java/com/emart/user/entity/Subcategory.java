package com.emart.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description  
 * @Author  ljg
 * @Date 2020/05/05 
 */

@Entity
@Table ( name ="category")
public class Subcategory  implements Serializable {

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

	@Override
	public String toString() {
		return "{" +
					"categoryId='" + categoryId + '\'' +
					"categoryName='" + categoryName + '\'' +
					"briefDetails='" + briefDetails + '\'' +
				'}';
	}

}