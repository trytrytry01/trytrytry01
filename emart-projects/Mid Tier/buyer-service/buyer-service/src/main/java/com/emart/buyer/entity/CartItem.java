package com.emart.buyer.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description  
 * @Author  ljg
 * @Date 2020/05/05 
 */

@Entity
@Table ( name ="cart")
public class CartItem  implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "id" )
	private Long id;

	/**
	 * buyer id
	 */
   	@Column(name = "buyer_id" )
	private Long buyerId;

	
	/**
	 * item id
	 */
   	@Column(name = "item_id" )
	private Long itemId;
   	
	/**
	 * item name
	 *  select item_name from items table by @Query sql
	 */
   	@Column(name = "item_name", insertable = false, updatable = false)
	private String itemName;
   	
	/**
	 * number of items
	 */
   	@Column(name = "number_of_items" )
	private Integer numberOfItems;
   	
	/**
	 * created time
	 */
   	@Column(name = "created_time" )
	private Date createdDateTime;
   	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(Integer numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

//	@Override
//	public String toString() {
//		return "{" +
//					"id='" + id + '\'' +
//					"buyerId='" + buyerId + '\'' +
//					"itemId='" + itemId + '\'' +
//					"numberOfItems='" + numberOfItems + '\'' +
//					"createdDateTime='" + createdDateTime + '\'' +
//				'}';
//	}

}