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
@Table ( name ="subcategory")
public class Category  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * sub category id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "subcategory_id" )
	private Long subcategoryId;

	/**
	 * sub category name
	 */
   	@Column(name = "subcategory_name" )
	private String subcategoryName;
   	
	/**
	 * category id
	 */
	@Id
   	@Column(name = "category_id" )
	private Long categoryId;

	/**
	 * brief details
	 */
   	@Column(name = "brief_details" )
	private String briefDetails;
   	
	/**
	 * GST%
	 */
   	@Column(name = "gst%" )
	private Integer gst;

	public Long getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(Long subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getBriefDetails() {
		return briefDetails;
	}

	public void setBriefDetails(String briefDetails) {
		this.briefDetails = briefDetails;
	}

	public Integer getGst() {
		return gst;
	}

	public void setGst(Integer gst) {
		this.gst = gst;
	}

	@Override
	public String toString() {
		return "{" +
					"subcategoryId='" + subcategoryId + '\'' +
					"subcategoryName='" + subcategoryName + '\'' +
					"categoryId='" + categoryId + '\'' +
					"briefDetails='" + briefDetails + '\'' +
					"gst='" + gst + '\'' +
				'}';
	}

}