package com.emart.buyer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  ljg
 * @Date 2020/05/05 
 */

@Entity
@Table ( name ="purchase_history")
public class PurchaseHistory  implements Serializable {

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
	 * transaction id
	 */
   	@Column(name = "transaction_id" )
	private Long transactionId;

	/**
	 * item id
	 */
   	@Column(name = "item_id" )
	private Long itemId;
   	
	/**
	 * number of items
	 */
   	@Column(name = "number_of_items" )
	private Integer numberOfItems;
   	
	/**
	 * purchase date time
	 */
   	@Column(name = "purchase_datetime" )
	private Date purchaseDatetime;
   	
	/**
	 * remarks
	 */
   	@Column(name = "remarks" )
	private String remarks;


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

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(Integer numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public Date getPurchaseDatetime() {
		return purchaseDatetime;
	}

	public void setPurchaseDatetime(Date purchaseDatetime) {
		this.purchaseDatetime = purchaseDatetime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

//	@Override
//	public String toString() {
//		return "{" +
//					"categoryId='" + id + '\'' +
//					"buyerId='" + buyerId + '\'' +
//					"transactionId='" + transactionId + '\'' +
//					"itemId='" + itemId + '\'' +
//					"numberOfItems='" + numberOfItems + '\'' +
//					"purchaseDatetime='" + purchaseDatetime + '\'' +
//					"remarks='" + remarks + '\'' +
//				'}';
//	}

}