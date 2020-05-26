package com.emart.seller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description  
 * @Author  ljg
 * @Date 2020/05/05 
 */

@Entity
@Table ( name ="items")
public class Item  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * primary key ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long id;

	/**
	 * item name
	 */
   	@Column(name = "item_name" )
	private String itemName;
   	
	/**
	 * seller id
	 */
   	@Column(name = "seller_id" )
	private Long sellerId;

	/**
	 * category id
	 */
   	@Column(name = "category_id" )
	private Long categoryId;
   	
	/**
	 * category name
	 */
   	@Transient
	private String categoryName;
   	
	/**
	 * sub category id
	 */
   	@Column(name = "subcategory_id" )
	private Long subcategoryId;
   	
	/**
	 * sub category name
	 */
   	@Transient
	private String subcategoryName;

	/**
	 * price
	 */
   	@Column(name = "price" )
	private String price;
   	
	/**
	 * description
	 */
   	@Column(name = "description" )
	private String description;
   	
	/**
	 * stockNumber
	 */
   	@Column(name = "stock_number" )
	private Long stockNumber;
   	
	/**
	 * remarks
	 */
   	@Column(name = "remarks" )
	private String remarks;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(Long subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(Long stockNumber) {
		this.stockNumber = stockNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}


//	@Override
//	public String toString() {
//		return "{" +
//					"id='" + id + '\'' +
//					"itemName='" + itemName + '\'' +
//					"sellerId='" + sellerId + '\'' +
//					"categoryId='" + categoryId + '\'' +
//					"subcategoryId='" + subcategoryId + '\'' +
//					"price='" + price + '\'' +
//					"description='" + description + '\'' +
//					"remarks='" + remarks + '\'' +
//				'}';
//	}

}